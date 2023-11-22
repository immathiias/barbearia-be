package br.com.mathias.barbearia.servico.application.repository;

import java.util.List;
import java.util.UUID;

import br.com.mathias.barbearia.servico.domain.Servico;

public interface ServicoRepository {
	Servico salva(Servico servicoNovo);
	List<Servico> buscaTodosServicos();
	Servico buscaServicoPorId(UUID idServico);
	void deletaServico(Servico servico);
}
