package med.fisio.api.domain.consulta.validacoes;

import jakarta.validation.ValidationException;
import med.fisio.api.domain.consulta.ConsultaRepository;
import med.fisio.api.domain.consulta.DadosAgendamentoConsulta;

public class ValidadorPacienteSemOutraConsulta{

    private ConsultaRepository repository;

    public void validar(DadosAgendamentoConsulta dados){
        var primeiroHorario = dados.data().withHour(7);
        var ultimoHorario = dados.data().withHour(18);
        var pacientePossuiOutraConsulta = repository.existsByPacienteIdAndDataBetween(dados.idPaciente(), primeiroHorario, ultimoHorario);
        if ((boolean) pacientePossuiOutraConsulta){
            throw new ValidationException("Paciente ja tem uma consulta nesse horario");
        }

    }
}
