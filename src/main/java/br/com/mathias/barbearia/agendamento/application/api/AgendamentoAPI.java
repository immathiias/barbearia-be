package br.com.mathias.barbearia.agendamento.application.api;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/agendamento")
public interface AgendamentoAPI {

    AgendamentoResponse postAgendamento(@RequestBody @Valid AgendamentoRequest agendamentoRequest);

}
