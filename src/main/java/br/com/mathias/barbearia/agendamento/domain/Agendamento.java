package br.com.mathias.barbearia.agendamento.domain;

import br.com.mathias.barbearia.agendamento.application.api.AgendamentoAlteracaoRequest;
import br.com.mathias.barbearia.agendamento.application.api.AgendamentoListResponse;
import br.com.mathias.barbearia.agendamento.application.api.AgendamentoRequest;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

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
    private UUID servicoId;
    @NotNull
    private LocalDateTime dataHora;

    private LocalDateTime dataHoraDoCadastro;
    private LocalDateTime dataHoraUltimaAtualizacao;


    public Agendamento(AgendamentoRequest agendamentoRequest) {
        this.idAgendamento = UUID.randomUUID();
        this.usuarioId = agendamentoRequest.getUsuarioId();
        this.servicoId = agendamentoRequest.getServicoId();
        this.dataHora = agendamentoRequest.getDataHora();

        this.dataHoraDoCadastro = LocalDateTime.now();
    }

    public void altera(AgendamentoAlteracaoRequest agendamentoAlteracaoRequest) {
        this.servicoId = agendamentoAlteracaoRequest.getServicoId();
        this.dataHora = agendamentoAlteracaoRequest.getDataHora();

        this.dataHoraUltimaAtualizacao = LocalDateTime.now();
    }
}




