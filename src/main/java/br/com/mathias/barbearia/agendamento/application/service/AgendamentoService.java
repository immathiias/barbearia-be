package br.com.mathias.barbearia.agendamento.application.service;

import br.com.mathias.barbearia.agendamento.application.api.AgendamentoListResponse;
import br.com.mathias.barbearia.agendamento.application.api.AgendamentoRequest;
import br.com.mathias.barbearia.agendamento.application.api.AgendamentoResponse;

import java.util.List;

public interface AgendamentoService {
    AgendamentoResponse criaAgendamento(AgendamentoRequest agendamentoRequest);
    List<AgendamentoListResponse> buscaTodosAgendamentos();
}
