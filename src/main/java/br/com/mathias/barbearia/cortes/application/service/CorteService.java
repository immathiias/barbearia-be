package br.com.mathias.barbearia.cortes.application.service;

import java.util.List;

import br.com.mathias.barbearia.cortes.application.api.CorteListResponse;
import br.com.mathias.barbearia.cortes.application.api.CorteRequest;
import br.com.mathias.barbearia.cortes.application.api.CorteResponse;

public interface CorteService {

	CorteResponse criaCorte(CorteRequest corteRequest);

	List<CorteListResponse> buscaTodosCortes();

}
