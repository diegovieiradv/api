package med.fisio.api.medico;

import med.fisio.api.endereco.DadosEndereco;

public record DadosCadastroPaciente(String nome, String email, String telefone, String cpf,
                                    Especialidade especialidade, DadosEndereco endereco) {
}
