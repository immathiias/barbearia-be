package br.com.mathias.barbearia.agendamento.application.api;

import br.com.mathias.barbearia.agendamento.domain.Agendamento;
import br.com.mathias.barbearia.servico.domain.Servico;
import br.com.mathias.barbearia.usuario.domain.Usuario;
import lombok.Value;

import java.time.LocalDateTime;

@Value
public class AgendamentoDetalhadoResponse {
    private String nomeUsuario;
    private String telefoneUsuario;
    private String nomeServico;
    private Double valorServico;
    private Integer tempoEstimado;
    private LocalDateTime dataHora;

    private LocalDateTime dataHoraDoCadastro;

    public AgendamentoDetalhadoResponse(Agendamento agendamento, Usuario usuario, Servico servico) {
        this.nomeUsuario = usuario.getNomeUsuario();
        this.telefoneUsuario = usuario.getTelefone();
        this.nomeServico = servico.getNomeServico();
        this.valorServico = servico.getValorServico();
        this.tempoEstimado = servico.getTempoEstimadoEmMinutos();
        this.dataHora = agendamento.getDataHora();
        this.dataHoraDoCadastro = agendamento.getDataHoraDoCadastro();
    }
}
