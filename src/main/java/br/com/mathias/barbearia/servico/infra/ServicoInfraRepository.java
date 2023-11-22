package br.com.mathias.barbearia.servico.infra;

import java.util.List;
import java.util.UUID;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Repository;

import br.com.mathias.barbearia.servico.application.repository.ServicoRepository;
import br.com.mathias.barbearia.servico.domain.Servico;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Repository
@Log4j2
@RequiredArgsConstructor
public class ServicoInfraRepository implements ServicoRepository {

	private final ServicoMongoSpringRepository servicoMongoSpringRepository;

	@Override
	public Servico salva(Servico servicoNovo) {
		log.info("[inicia] ServicoInfraRepository - salva");
		try {
			servicoMongoSpringRepository.save(servicoNovo);
		} catch (DataIntegrityViolationException e) {
			throw new RuntimeException("Existem dados duplicados.");
		}
		log.info("[finaliza] ServicoInfraRepository - salva");
		return servicoNovo;
	}

	@Override
	public List<Servico> buscaTodosServicos() {
		log.info("[inicia] ServicoInfraRepository - buscaTodosServicos");
		List<Servico> servicos = servicoMongoSpringRepository.findAll();
		log.info("[finaliza] ServicoInfraRepository - buscaTodosServicos");
		return servicos;
	}

	@Override
	public Servico buscaServicoPorId(UUID idServico) {
		log.info("[inicia] ServicoInfraRepository - buscaServicoPorId");
		Servico servico = servicoMongoSpringRepository.findById(idServico)
				.orElseThrow(() -> new RuntimeException("Serviço não encontrado!"));
		log.info("[finaliza] ServicoInfraRepository - buscaServicoPorId");
		return servico;
	}

	@Override
	public void deletaServico(Servico servico) {
		log.info("[inicia] ServicoInfraRepository - deletaServico");
		servicoMongoSpringRepository.delete(servico);
		log.info("[finaliza] ServicoInfraRepository - deletaServico");
	}

}
