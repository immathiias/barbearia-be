package br.com.mathias.barbearia.cortes.infra;

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

}
