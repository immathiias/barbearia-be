package br.com.mathias.barbearia.cortes.application.api;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Value;

@Value
public class CorteRequest {
	@NotBlank
	private String nomeCorte;
	@NotNull
	private Double valorCorte;
	private Integer tempoEstimado;
}
