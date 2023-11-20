package br.com.mathias.barbearia.cortes.application.api;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;

import br.com.mathias.barbearia.cortes.application.service.CorteService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RestController
@Validated
@Log4j2
@RequiredArgsConstructor
public class CorteController implements CorteAPI {

	private final CorteService corteService;

	@Override
	public CorteResponse postCorte(CorteRequest corteRequest) {
		log.info("[inicia] CortesController - postCorte");
		CorteResponse corte = corteService.criaCorte(corteRequest);
		log.info("[finaliza] CortesController - postCorte");
		return corte;
	}

}
