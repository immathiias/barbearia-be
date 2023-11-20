package br.com.mathias.barbearia.cortes.application.service;

import br.com.mathias.barbearia.cortes.application.api.CorteRequest;
import br.com.mathias.barbearia.cortes.application.api.CorteResponse;

public interface CorteService {

	CorteResponse criaCorte(CorteRequest corteRequest);

}
