package br.com.mathias.barbearia.agendamento.application.api;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/agendamento")
public interface AgendamentoAPI {
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    AgendamentoResponse postAgendamento(@RequestBody @Valid AgendamentoRequest agendamentoRequest);

}
