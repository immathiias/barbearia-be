package br.com.mathias.barbearia.agendamento.application.api;

import br.com.mathias.barbearia.agendamento.domain.Agendamento;
import br.com.mathias.barbearia.cortes.domain.Corte;
import br.com.mathias.barbearia.usuario.domain.Usuario;
import lombok.Value;

import java.time.LocalDateTime;

@Value
public class AgendamentoDetalhadoResponse {
    private String nomeUsuario;
    private String telefoneUsuario;
    private String nomeCorte;
    private Double valorCorte;
    private Integer tempoEstimado;
    private LocalDateTime dataHora;

    private LocalDateTime dataHoraDoCadastro;

    public AgendamentoDetalhadoResponse(Agendamento agendamento, Usuario usuario, Corte corte) {
        this.nomeUsuario = usuario.getNomeUsuario();
        this.telefoneUsuario = usuario.getTelefone();
        this.nomeCorte = corte.getNomeCorte();
        this.valorCorte = corte.getValorCorte();
        this.tempoEstimado = corte.getTempoEstimadoEmMinutos();
        this.dataHora = agendamento.getDataHora();
        this.dataHoraDoCadastro = agendamento.getDataHoraDoCadastro();
    }
}
