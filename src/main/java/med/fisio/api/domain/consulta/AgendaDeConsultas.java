package med.fisio.api.domain.consulta;

import med.fisio.api.domain.ValidacaoException;
import med.fisio.api.domain.consulta.validacoes.ValidadorAgendamentoDeConsulta;
import med.fisio.api.domain.medico.Medico;
import med.fisio.api.domain.medico.MedicoRepository;
import med.fisio.api.domain.paciente.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgendaDeConsultas {

    @Autowired
    private ConsultaRepository consultaRepository;

    @Autowired
    private MedicoRepository medicoRepository;

    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private List<ValidadorAgendamentoDeConsulta> validadores;

    public DadosDetalhamentoConsulta agendar(DadosAgendamentoConsulta dados) {

        if (!pacienteRepository.existsById(dados.idPaciente())) {
            throw new ValidacaoException("Id do paciente informado nao existe");
        }

        if (dados.idMedico() != null && !medicoRepository.existsById(dados.idMedico())) {
            throw new ValidacaoException("Id do medico informado não existe");
        }

        validadores.forEach(validador -> validador.validar(dados));

        var paciente = pacienteRepository.getReferenceById(dados.idPaciente());
        var medico = escolherMedico(dados);

        var consulta = new Consulta(null, medico, paciente, dados.data());
        consultaRepository.save(consulta);

        return new DadosDetalhamentoConsulta(consulta);
    }

    private Medico escolherMedico(DadosAgendamentoConsulta dados) {

        if (dados.idMedico() != null) {
            return medicoRepository.getReferenceById(dados.idMedico());
        }

        if (dados.especialidade() == null) {
            throw new ValidacaoException(
                    "Especialidade é obrigatória quando o médico não for escolhido!"
            );
        }

        var page = medicoRepository.buscarMedicosLivresNaData(
                dados.especialidade(),
                dados.data(),
                PageRequest.of(0, 1)
        );

        if (page.isEmpty()) {
            throw new ValidacaoException("Nenhum médico disponível nessa data");
        }

        return page.getContent().get(0);
    }
}
