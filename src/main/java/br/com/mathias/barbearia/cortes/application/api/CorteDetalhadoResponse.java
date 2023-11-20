package br.com.mathias.barbearia.cortes.application.api;

import java.time.LocalDateTime;

import lombok.Value;

@Value
public class CorteDetalhadoResponse {
	private String nomeCorte;
	private Double valorCorte;
	private Integer tempoEstimado;
	private LocalDateTime dataHoraDoCadastro;
}
