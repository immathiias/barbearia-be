package br.com.mathias.barbearia.servico.application.api;

import br.com.mathias.barbearia.servico.domain.TipoServico;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Value;

@Value
public class ServicoRequest {
	@NotBlank
	private String nomeServico;
	@NotNull
	private Double valorServico;
	@NotNull
	private TipoServico tipoServico;
	private Integer tempoEstimado;
}
