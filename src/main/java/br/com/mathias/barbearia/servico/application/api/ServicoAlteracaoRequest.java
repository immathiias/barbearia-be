package br.com.mathias.barbearia.servico.application.api;

import br.com.mathias.barbearia.servico.domain.TipoServico;
import lombok.Value;

@Value
public class ServicoAlteracaoRequest {
	private String nomeServico;
	private Double valorServico;
	private TipoServico tipoServico;
	private Integer tempoEstimado;
}
