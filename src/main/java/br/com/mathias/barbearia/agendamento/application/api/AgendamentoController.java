package br.com.mathias.barbearia.agendamento.application.api;

import br.com.mathias.barbearia.agendamento.application.service.AgendamentoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@Validated
@Log4j2
@RequiredArgsConstructor
public class AgendamentoController implements AgendamentoAPI {
    private final AgendamentoService agendamentoService;
    @Override
    public AgendamentoResponse postAgendamento(AgendamentoRequest agendamentoRequest) {
        log.info("[inicia] AgendamentoController - postAgendamento");
        AgendamentoResponse agendamento = agendamentoService.criaAgendamento(agendamentoRequest);
        log.info("[finaliza] AgendamentoController - postAgendamento");
        return agendamento;
    }

    @Override
    public List<AgendamentoListResponse> getTodosAgendamentos() {
        log.info("[inicia] AgendamentoController - getTodosAgendamentos");
        List<AgendamentoListResponse> agendamentos = agendamentoService.buscaTodosAgendamentos();
        log.info("[finaliza] AgendamentoController - getTodosAgendamentos");
        return agendamentos;
    }

    @Override
    public AgendamentoDetalhadoResponse getAgendamentoPorId(UUID idAgendamento) {
        log.info("[inicia] AgendamentoController - getAgendamentoPorId");
        AgendamentoDetalhadoResponse agendamento = agendamentoService.buscaAgendamentoPorId(idAgendamento);
        log.info("[finaliza] AgendamentoController - getAgendamentoPorId");
        return agendamento;
    }
}
