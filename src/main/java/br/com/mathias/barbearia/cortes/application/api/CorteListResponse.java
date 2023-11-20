package br.com.mathias.barbearia.cortes.application.api;

import java.util.List;
import java.util.stream.Collectors;

import br.com.mathias.barbearia.cortes.domain.Corte;
import lombok.Value;

@Value
public class CorteListResponse {
	private String nomeCorte;
	private Double valorCorte;
	private Integer tempoEstimado;
	
	public static List<CorteListResponse> converte(List<Corte> cortes) {
		return cortes.stream()
				.map(CorteListResponse::new)
				.collect(Collectors.toList());
	}

	public CorteListResponse(Corte corte) {
		this.nomeCorte = corte.getNomeCorte();
		this.valorCorte = corte.getValorCorte();
		this.tempoEstimado = corte.getTempoEstimadoEmMinutos();
	}
}
