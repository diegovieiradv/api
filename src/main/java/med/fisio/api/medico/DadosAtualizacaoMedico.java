package med.fisio.api.medico;

import jakarta.validation.constraints.NotNull;
import med.fisio.api.endereco.DadosEndereco;

public record DadosAtualizacaoMedico(
        @NotNull
        Long id,
                                     String nome,
                                     String telefone,
                                     DadosEndereco endereco) {
}
