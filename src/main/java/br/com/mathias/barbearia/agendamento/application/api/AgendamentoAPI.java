package br.com.mathias.barbearia.agendamento.application.api;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/v1/agendamento")
public interface AgendamentoAPI {
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    AgendamentoResponse postAgendamento(@RequestBody @Valid AgendamentoRequest agendamentoRequest);

    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    List<AgendamentoListResponse> getTodosAgendamentos();

    @GetMapping("/{idAgendamento}")
    @ResponseStatus(code = HttpStatus.OK)
    AgendamentoDetalhadoResponse getAgendamentoPorId(@PathVariable UUID idAgendamento);

}
