package br.com.mathias.barbearia.servico.application.api;

import java.time.LocalDateTime;

import br.com.mathias.barbearia.servico.domain.Servico;
import br.com.mathias.barbearia.servico.domain.TipoServico;
import lombok.Value;

@Value
public class ServicoDetalhadoResponse {
	private String nomeServico;
	private Double valorServico;
	private TipoServico tipoServico;
	private Integer tempoEstimado;
	private LocalDateTime dataHoraDoCadastro;
	public ServicoDetalhadoResponse(Servico servico) {
		this.nomeServico = servico.getNomeServico();
		this.valorServico = servico.getValorServico();
		this.tipoServico = servico.getTipoServico();
		this.tempoEstimado = servico.getTempoEstimadoEmMinutos();
		this.dataHoraDoCadastro = servico.getDataHoraDoCadastro();
	}
}
