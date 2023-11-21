package br.com.mathias.barbearia.agendamento.domain;

import br.com.mathias.barbearia.cortes.domain.Corte;
import br.com.mathias.barbearia.usuario.domain.Usuario;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.UUID;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Document(collection = "Agendamento")
public class Agendamento {
    @Id
    private UUID idAgendamento;
    @Indexed
    private UUID usuarioId;
    @Indexed
    private UUID corteId;
    @NotNull
    private LocalDateTime dataHora;

    private LocalDateTime dataHoraDoCadastro;
    private LocalDateTime dataHoraUltimaAtualizacao;
}



