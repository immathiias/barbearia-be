package br.com.mathias.barbearia.cortes.application.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import br.com.mathias.barbearia.cortes.application.api.CorteDetalhadoResponse;
import br.com.mathias.barbearia.cortes.application.api.CorteListResponse;
import br.com.mathias.barbearia.cortes.application.api.CorteRequest;
import br.com.mathias.barbearia.cortes.application.api.CorteResponse;
import br.com.mathias.barbearia.cortes.application.repository.CorteRepository;
import br.com.mathias.barbearia.cortes.domain.Corte;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
@RequiredArgsConstructor
public class CorteApplicationService implements CorteService {

	private final CorteRepository corteRepository;

	@Override
	public CorteResponse criaCorte(CorteRequest corteRequest) {
		log.info("[inicia] CorteApplicationService - criaCorte");
		Corte corteNovo = new Corte(corteRequest);
		corteRepository.salva(corteNovo);
		log.info("[finaliza] CorteApplicationService - criaCorte");
		return CorteResponse.builder()
				.idCorte(corteNovo.getIdCorte())
				.build();
	}

	@Override
	public List<CorteListResponse> buscaTodosCortes() {
		log.info("[inicia] CorteApplicationService - buscaTodosCortes");
		List<Corte> cortes = corteRepository.buscaTodosCortes();
		log.info("[finaliza] CorteApplicationService - buscaTodosCortes");
		return CorteListResponse.converte(cortes);
	}

	@Override
	public CorteDetalhadoResponse buscaCortePorId(UUID idCorte) {
		log.info("[inicia] CorteApplicationService - buscaCortePorId");
		Corte corte = corteRepository.buscaCortePorId(idCorte);
		log.info("[finaliza] CorteApplicationService - buscaCortePorId");
		return new CorteDetalhadoResponse(corte);
	}

	@Override
	public void deletaCortePorId(UUID idCorte) {
		log.info("[inicia] CorteApplicationService - deletaCortePorId");
		Corte corte = corteRepository.buscaCortePorId(idCorte);
		corteRepository.deletaCorte(corte);
		log.info("[finaliza] CorteApplicationService - deletaCortePorId");
	}

}
