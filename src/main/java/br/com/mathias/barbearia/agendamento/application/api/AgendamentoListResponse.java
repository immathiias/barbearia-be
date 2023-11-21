package br.com.mathias.barbearia.agendamento.application.api;

import br.com.mathias.barbearia.agendamento.domain.Agendamento;
import br.com.mathias.barbearia.cortes.domain.Corte;
import br.com.mathias.barbearia.usuario.domain.Usuario;
import lombok.Value;

import java.time.LocalDateTime;
import java.util.Collections;

@Value
public class AgendamentoListResponse {
    private String nomeUsuario;
    private String nomeCorte;
    private LocalDateTime dataHora;


    public static AgendamentoListResponse converte(Agendamento agenda, Usuario usuario, Corte corte) {
        return new AgendamentoListResponse(agenda, usuario, corte);
    }

    public AgendamentoListResponse(Agendamento agendamento, Usuario usuario, Corte corte) {
        this.nomeUsuario = usuario.getNomeUsuario();
        this.nomeCorte = corte.getNomeCorte();
        this.dataHora = agendamento.getDataHora();
    }

}
