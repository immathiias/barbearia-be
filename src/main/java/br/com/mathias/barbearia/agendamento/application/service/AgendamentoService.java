package br.com.mathias.barbearia.agendamento.application.service;

import br.com.mathias.barbearia.agendamento.application.api.AgendamentoRequest;
import br.com.mathias.barbearia.agendamento.application.api.AgendamentoResponse;

public interface AgendamentoService {
    AgendamentoResponse criaAgendamento(AgendamentoRequest agendamentoRequest);
}
