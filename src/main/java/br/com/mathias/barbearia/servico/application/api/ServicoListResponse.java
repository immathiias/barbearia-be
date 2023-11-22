package br.com.mathias.barbearia.servico.application.api;

import java.util.List;
import java.util.stream.Collectors;

import br.com.mathias.barbearia.servico.domain.Servico;
import br.com.mathias.barbearia.servico.domain.TipoServico;
import lombok.Value;

@Value
public class ServicoListResponse {
	private String nomeServico;
	private Double valorServico;
	private TipoServico tipoServico;
	private Integer tempoEstimado;
	
	public static List<ServicoListResponse> converte(List<Servico> servicos) {
		return servicos.stream()
				.map(ServicoListResponse::new)
				.collect(Collectors.toList());
	}

	public ServicoListResponse(Servico servico) {
		this.nomeServico = servico.getNomeServico();
		this.valorServico = servico.getValorServico();
		this.tipoServico = servico.getTipoServico();
		this.tempoEstimado = servico.getTempoEstimadoEmMinutos();
	}
}
