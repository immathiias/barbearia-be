package br.com.mathias.barbearia.agendamento.application.repository;

import br.com.mathias.barbearia.agendamento.domain.Agendamento;

import java.util.List;
import java.util.UUID;

public interface AgendamentoRepository {
    Agendamento salva(Agendamento agendamentoNovo);
    List<Agendamento> buscaTodosAgendamentos();
    Agendamento buscaAgendamentoPorId(UUID idAgendamento);
    void deletaAgendamento(Agendamento agendamento);
}
