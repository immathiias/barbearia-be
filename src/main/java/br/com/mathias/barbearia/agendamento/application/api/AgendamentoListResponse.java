package br.com.mathias.barbearia.agendamento.application.api;

import lombok.Value;

@Value
public class AgendamentoListResponse {
    private String nomeUsuario;
    private String nomeCorte;
    private String dataHora;
}
