package br.com.mathias.barbearia.cortes.application.api;

import java.util.List;
import java.util.UUID;

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

	@Override
	public List<CorteListResponse> getTodosCortes() {
		log.info("[inicia] CortesController - getTodosCortes");
		List<CorteListResponse> cortes = corteService.buscaTodosCortes();
		log.info("[finaliza] CortesController - getTodosCortes");
		return cortes;
	}

	@Override
	public CorteDetalhadoResponse getCortePorId(UUID idCorte) {
		log.info("[inicia] CortesController - getCortePorId");
		CorteDetalhadoResponse corteDetalhado = corteService.buscaCortePorId(idCorte);
		log.info("[finaliza] CortesController - getCortePorId");
		return corteDetalhado;
	}

}
