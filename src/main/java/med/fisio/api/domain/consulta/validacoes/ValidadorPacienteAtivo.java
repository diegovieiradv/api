package med.fisio.api.domain.consulta.validacoes;

import jakarta.validation.ValidationException;
import med.fisio.api.domain.consulta.DadosAgendamentoConsulta;
import med.fisio.api.domain.paciente.PacienteRepository;

public class ValidadorPacienteAtivo {

    private PacienteRepository repository;

    public void validar(DadosAgendamentoConsulta dados){
        var pacienteEstaAtivo = repository.findAtivoById(dados.idPaciente());
        if (!(boolean) pacienteEstaAtivo){
            throw new ValidationException("Consulta náo pode ser agendada com paciente não ativo");
        }
    }
}
