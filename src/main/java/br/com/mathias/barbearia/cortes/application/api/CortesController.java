package br.com.mathias.barbearia.cortes.application.api;

import org.springframework.web.bind.annotation.RestController;

import lombok.extern.log4j.Log4j2;

@RestController
@Log4j2
public class CortesController implements CortesAPI {

	@Override
	public CortesResponse postCorte(CortesRequest corteRequest) {
		log.info("[inicia] CortesController - postCorte");
		log.info("[finaliza] CortesController - postCorte");
		return null;
	}

}
