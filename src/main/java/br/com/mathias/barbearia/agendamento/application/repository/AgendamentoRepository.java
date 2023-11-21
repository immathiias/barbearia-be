package br.com.mathias.barbearia.agendamento.application.repository;

import br.com.mathias.barbearia.agendamento.domain.Agendamento;

import java.util.List;

public interface AgendamentoRepository {
    Agendamento salva(Agendamento agendamentoNovo);
    List<Agendamento> buscaTodosAgendamentos();
}
