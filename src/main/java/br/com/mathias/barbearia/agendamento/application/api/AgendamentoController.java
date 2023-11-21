package br.com.mathias.barbearia.agendamento.application.api;

import lombok.extern.log4j.Log4j2;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Validated
@Log4j2
public class AgendamentoController implements AgendamentoAPI {
    @Override
    public AgendamentoResponse postAgendamento(AgendamentoRequest agendamentoRequest) {
        log.info("[inicia] AgendamentoController - postAgendamento");
        log.info("[finaliza] AgendamentoController - postAgendamento");
        return null;
    }
}
