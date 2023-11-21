package br.com.mathias.barbearia.agendamento.application.service;

import br.com.mathias.barbearia.agendamento.application.api.AgendamentoDetalhadoResponse;
import br.com.mathias.barbearia.agendamento.application.api.AgendamentoListResponse;
import br.com.mathias.barbearia.agendamento.application.api.AgendamentoRequest;
import br.com.mathias.barbearia.agendamento.application.api.AgendamentoResponse;

import java.util.List;
import java.util.UUID;

public interface AgendamentoService {
    AgendamentoResponse criaAgendamento(AgendamentoRequest agendamentoRequest);
    List<AgendamentoListResponse> buscaTodosAgendamentos();
    AgendamentoDetalhadoResponse buscaAgendamentoPorId(UUID idAgendamento);
}
