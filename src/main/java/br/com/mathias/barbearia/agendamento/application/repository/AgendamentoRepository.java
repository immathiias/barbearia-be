package br.com.mathias.barbearia.agendamento.application.repository;

import br.com.mathias.barbearia.agendamento.domain.Agendamento;

public interface AgendamentoRepository {
    Agendamento salva(Agendamento agendamentoNovo);
}
