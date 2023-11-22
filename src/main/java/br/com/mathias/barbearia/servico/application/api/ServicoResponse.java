package br.com.mathias.barbearia.servico.application.api;

import java.util.UUID;

import lombok.Builder;
import lombok.Value;

@Builder
@Value
public class ServicoResponse {
	private UUID idServico;
}
