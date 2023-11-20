package br.com.mathias.barbearia.cortes.application.api;

import lombok.Value;

@Value
public class CorteListResponse {
	private String nomeCorte;
	private Double valorCorte;
	private Integer tempoEstimado;
}
