package br.com.mathias.barbearia.agendamento.application.api;

import java.time.LocalDateTime;

public class AgendamentoDetalhadoResponse {
    private String nomeUsuario;
    private String telefoneUsuario;
    private String nomeCorte;
    private Double valorCorte;
    private Integer tempoEstimado;
    private LocalDateTime dataHora;

    private LocalDateTime dataHoraDoCadastro;
}
