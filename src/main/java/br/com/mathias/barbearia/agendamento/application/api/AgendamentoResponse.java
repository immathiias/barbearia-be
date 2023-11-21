package br.com.mathias.barbearia.agendamento.application.api;

import lombok.Builder;
import lombok.Value;

import java.util.UUID;

@Builder
@Value
public class AgendamentoResponse {
    private UUID idAgendamento;
}
