package br.com.mathias.barbearia.cortes.application.service;

import org.springframework.stereotype.Service;

import br.com.mathias.barbearia.cortes.application.api.CorteRequest;
import br.com.mathias.barbearia.cortes.application.api.CorteResponse;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class CorteApplicationService implements CorteService {

	@Override
	public CorteResponse criaCorte(CorteRequest corteRequest) {
		log.info("[inicia] CorteApplicationService - criaCorte");
		log.info("[finaliza] CorteApplicationService - criaCorte");
		return null;
	}

}
