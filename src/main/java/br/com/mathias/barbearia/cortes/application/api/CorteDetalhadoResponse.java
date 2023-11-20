package br.com.mathias.barbearia.cortes.application.api;

import java.time.LocalDateTime;

import br.com.mathias.barbearia.cortes.domain.Corte;
import lombok.Value;

@Value
public class CorteDetalhadoResponse {
	private String nomeCorte;
	private Double valorCorte;
	private Integer tempoEstimado;
	private LocalDateTime dataHoraDoCadastro;
	public CorteDetalhadoResponse(Corte corte) {
		this.nomeCorte = corte.getNomeCorte();
		this.valorCorte = corte.getValorCorte();
		this.tempoEstimado = corte.getTempoEstimadoEmMinutos();
		this.dataHoraDoCadastro = corte.getDataHoraDoCadastro();
	}
}
