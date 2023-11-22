package br.com.mathias.barbearia.agendamento.application.api;

import br.com.mathias.barbearia.agendamento.domain.Agendamento;
import br.com.mathias.barbearia.servico.domain.Servico;
import br.com.mathias.barbearia.usuario.domain.Usuario;
import lombok.Value;

import java.time.LocalDateTime;

@Value
public class AgendamentoListResponse {
    private String nomeUsuario;
    private String nomeServico;
    private LocalDateTime dataHora;


    public static AgendamentoListResponse converte(Agendamento agenda, Usuario usuario, Servico servico) {
        return new AgendamentoListResponse(agenda, usuario, servico);
    }

    public AgendamentoListResponse(Agendamento agendamento, Usuario usuario, Servico servico) {
        this.nomeUsuario = usuario.getNomeUsuario();
        this.nomeServico = servico.getNomeServico();
        this.dataHora = agendamento.getDataHora();
    }

}
