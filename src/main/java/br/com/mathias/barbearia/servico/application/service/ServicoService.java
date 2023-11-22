package br.com.mathias.barbearia.servico.application.service;

import java.util.List;
import java.util.UUID;

import br.com.mathias.barbearia.servico.application.api.ServicoAlteracaoRequest;
import br.com.mathias.barbearia.servico.application.api.ServicoDetalhadoResponse;
import br.com.mathias.barbearia.servico.application.api.ServicoListResponse;
import br.com.mathias.barbearia.servico.application.api.ServicoRequest;
import br.com.mathias.barbearia.servico.application.api.ServicoResponse;

public interface ServicoService {
	ServicoResponse criaServico(ServicoRequest servicoRequest);
	List<ServicoListResponse> buscaTodosServicos();
	ServicoDetalhadoResponse buscaServicoPorId(UUID idServico);
	void deletaServicoPorId(UUID idServico);
	void alteraServico(UUID idServico, ServicoAlteracaoRequest servicoAlteracaoRequest);
}
