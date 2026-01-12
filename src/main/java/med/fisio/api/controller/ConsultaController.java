package med.fisio.api.controller;

import med.fisio.api.domain.consulta.AgendaDeConsultas;
import med.fisio.api.domain.consulta.DadosAgendamentoConsulta;
import med.fisio.api.domain.consulta.DadosDetalhamentoConsulta;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/consultas")
public class ConsultaController {

    @Autowired
    private AgendaDeConsultas agenda;



    @PostMapping
    @Transactional
    public ResponseEntity agendar(
            @RequestBody @Valid DadosAgendamentoConsulta dados) {
                agenda.agendar(dados);

        return ResponseEntity.ok(
                new DadosDetalhamentoConsulta(null, null, null, null)
        );
    }
}
