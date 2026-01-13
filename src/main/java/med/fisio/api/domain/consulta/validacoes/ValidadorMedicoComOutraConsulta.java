package med.fisio.api.domain.consulta.validacoes;

import jakarta.validation.ValidationException;
import med.fisio.api.domain.consulta.ConsultaRepository;
import med.fisio.api.domain.consulta.DadosAgendamentoConsulta;

public class ValidadorMedicoComOutraConsulta {

    private ConsultaRepository repository;

    public void validar(DadosAgendamentoConsulta dados){
        var medicoPossuiOutraConsulta = repository.existsByMedicoIdAndData(dados.idMedico(), dados.data());
        if (medicoPossuiOutraConsulta){
            throw new ValidationException("Medico ja tem uma consulta nesse horario");
        }
    }

}
