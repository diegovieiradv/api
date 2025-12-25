package med.fisio.api.medico;

import med.fisio.api.endereco.DadosEndereco;

public record DadosCadastroMedico(String nome, String email, String telefone, String crm,
                                  Especialidade especialidade, DadosEndereco endereco) {
}
