package br.com.mathias.barbearia.cortes.application.api;

import lombok.Value;

@Value
public class CorteAlteracaoRequest {
	private String nomeCorte;
	private Double valorCorte;
	private Integer tempoEstimado;
}
