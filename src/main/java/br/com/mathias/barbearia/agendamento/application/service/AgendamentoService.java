package br.com.mathias.barbearia.agendamento.application.service;

import br.com.mathias.barbearia.agendamento.application.api.*;

import java.util.List;
import java.util.UUID;

public interface AgendamentoService {
    AgendamentoResponse criaAgendamento(AgendamentoRequest agendamentoRequest);
    List<AgendamentoListResponse> buscaTodosAgendamentos();
    AgendamentoDetalhadoResponse buscaAgendamentoPorId(UUID idAgendamento);
    void deletaAgendamentoPorId(UUID idAgendamento);
    void alteraAgendamentoPorId(UUID idAgendamento, AgendamentoAlteracaoRequest agendamentoAlteracaoRequest);
}
