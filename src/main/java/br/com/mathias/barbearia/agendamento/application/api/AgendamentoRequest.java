package br.com.mathias.barbearia.agendamento.application.api;

import jakarta.validation.constraints.NotNull;
import lombok.Value;
import org.springframework.data.mongodb.core.index.Indexed;

import java.time.LocalDateTime;
import java.util.UUID;

@Value
public class AgendamentoRequest {
    private UUID usuarioId;
    private UUID corteId;
    private LocalDateTime dataHora;
}
