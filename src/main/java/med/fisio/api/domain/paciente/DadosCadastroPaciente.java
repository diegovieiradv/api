package med.fisio.api.domain.paciente;

import med.fisio.api.domain.endereco.DadosEndereco;
import med.fisio.api.domain.medico.Especialidade;

public record DadosCadastroPaciente(String nome, String email, String telefone, String cpf,
                                    Especialidade especialidade, DadosEndereco endereco) {
}
