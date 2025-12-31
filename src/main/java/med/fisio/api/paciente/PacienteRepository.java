package med.fisio.api.paciente;

import med.fisio.api.domain.paciente.Paciente;

import java.awt.print.Pageable;
import java.util.Optional;

public interface PacienteRepository {
    void save(Paciente paciente);

    Optional<Object> findAllByAtivoTrue(Pageable paginacao);

    Object getReferenceById(Long id);
}
