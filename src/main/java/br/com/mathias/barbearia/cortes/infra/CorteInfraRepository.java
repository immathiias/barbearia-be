package br.com.mathias.barbearia.cortes.infra;

import java.util.List;
import java.util.UUID;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Repository;

import br.com.mathias.barbearia.cortes.application.repository.CorteRepository;
import br.com.mathias.barbearia.cortes.domain.Corte;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Repository
@Log4j2
@RequiredArgsConstructor
public class CorteInfraRepository implements CorteRepository {

	private final CorteMongoSpringRepository corteMongoSpringRepository;

	@Override
	public Corte salva(Corte corteNovo) {
		log.info("[inicia] CorteInfraRepository - salva");
		try {
			corteMongoSpringRepository.save(corteNovo);
		} catch (DataIntegrityViolationException e) {
			throw new RuntimeException("Existem dados duplicados.");
		}
		log.info("[finaliza] CorteInfraRepository - salva");
		return corteNovo;
	}

	@Override
	public List<Corte> buscaTodosCortes() {
		log.info("[inicia] CorteInfraRepository - buscaTodosCortes");
		List<Corte> cortes = corteMongoSpringRepository.findAll();
		log.info("[finaliza] CorteInfraRepository - buscaTodosCortes");
		return cortes;
	}

	@Override
	public Corte buscaCortePorId(UUID idCorte) {
		log.info("[inicia] CorteInfraRepository - buscaCortePorId");
		Corte corte = corteMongoSpringRepository.findById(idCorte)
				.orElseThrow(() -> new RuntimeException("Corte não encontrado!"));
		log.info("[finaliza] CorteInfraRepository - buscaCortePorId");
		return corte;
	}

	@Override
	public void deletaCorte(Corte corte) {
		log.info("[inicia] CorteInfraRepository - deletaCorte");
		corteMongoSpringRepository.delete(corte);
		log.info("[finaliza] CorteInfraRepository - deletaCorte");
	}

}
