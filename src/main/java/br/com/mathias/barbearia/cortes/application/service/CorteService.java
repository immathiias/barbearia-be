package br.com.mathias.barbearia.cortes.application.service;

import java.util.List;
import java.util.UUID;

import br.com.mathias.barbearia.cortes.application.api.CorteAlteracaoRequest;
import br.com.mathias.barbearia.cortes.application.api.CorteDetalhadoResponse;
import br.com.mathias.barbearia.cortes.application.api.CorteListResponse;
import br.com.mathias.barbearia.cortes.application.api.CorteRequest;
import br.com.mathias.barbearia.cortes.application.api.CorteResponse;

public interface CorteService {
	CorteResponse criaCorte(CorteRequest corteRequest);
	List<CorteListResponse> buscaTodosCortes();
	CorteDetalhadoResponse buscaCortePorId(UUID idCorte);
	void deletaCortePorId(UUID idCorte);
	void alteraCorte(UUID idCorte, CorteAlteracaoRequest corteAlteracaoRequest);
}
