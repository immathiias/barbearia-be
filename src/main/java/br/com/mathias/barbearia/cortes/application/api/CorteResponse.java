package br.com.mathias.barbearia.cortes.application.api;

import java.util.UUID;

import lombok.Builder;
import lombok.Value;

@Builder
@Value
public class CorteResponse {
	private UUID idCorte;
}
