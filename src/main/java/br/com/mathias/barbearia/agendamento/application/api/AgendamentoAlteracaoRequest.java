package br.com.mathias.barbearia.agendamento.application.api;

import lombok.Value;

import java.time.LocalDateTime;
import java.util.UUID;

@Value
public class AgendamentoAlteracaoRequest {
    private UUID servicoId;
    private LocalDateTime dataHora;
}
