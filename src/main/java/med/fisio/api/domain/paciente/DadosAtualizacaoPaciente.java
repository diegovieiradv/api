package med.fisio.api.domain.paciente;

import jakarta.validation.constraints.NotNull;
import med.fisio.api.domain.endereco.DadosEndereco;

public record DadosAtualizacaoPaciente(
        @NotNull
        Long id,
        String nome,
        String telefone,
        DadosEndereco endereco) {
}