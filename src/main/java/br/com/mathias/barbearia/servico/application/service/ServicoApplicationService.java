package br.com.mathias.barbearia.servico.application.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import br.com.mathias.barbearia.servico.application.api.ServicoAlteracaoRequest;
import br.com.mathias.barbearia.servico.application.api.ServicoDetalhadoResponse;
import br.com.mathias.barbearia.servico.application.api.ServicoListResponse;
import br.com.mathias.barbearia.servico.application.api.ServicoRequest;
import br.com.mathias.barbearia.servico.application.api.ServicoResponse;
import br.com.mathias.barbearia.servico.application.repository.ServicoRepository;
import br.com.mathias.barbearia.servico.domain.Servico;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
@RequiredArgsConstructor
public class ServicoApplicationService implements ServicoService {

	private final ServicoRepository servicoRepository;

	@Override
	public ServicoResponse criaServico(ServicoRequest corteRequest) {
		log.info("[inicia] ServicoApplicationService - criaServico");
		Servico servicoNovo = new Servico(corteRequest);
		servicoRepository.salva(servicoNovo);
		log.info("[finaliza] ServicoApplicationService - criaServico");
		return ServicoResponse.builder()
				.idServico(servicoNovo.getIdServico())
				.build();
	}

	@Override
	public List<ServicoListResponse> buscaTodosServicos() {
		log.info("[inicia] ServicoApplicationService - buscaTodosServicos");
		List<Servico> servicos = servicoRepository.buscaTodosServicos();
		log.info("[finaliza] ServicoApplicationService - buscaTodosServicos");
		return ServicoListResponse.converte(servicos);
	}

	@Override
	public ServicoDetalhadoResponse buscaServicoPorId(UUID idServico) {
		log.info("[inicia] ServicoApplicationService - buscaServicoPorId");
		Servico servico = servicoRepository.buscaServicoPorId(idServico);
		log.info("[finaliza] ServicoApplicationService - buscaServicoPorId");
		return new ServicoDetalhadoResponse(servico);
	}

	@Override
	public void deletaServicoPorId(UUID idServico) {
		log.info("[inicia] ServicoApplicationService - deletaServicoPorId");
		Servico servico = servicoRepository.buscaServicoPorId(idServico);
		servicoRepository.deletaServico(servico);
		log.info("[finaliza] ServicoApplicationService - deletaServicoPorId");
	}

	@Override
	public void alteraServico(UUID idServico, ServicoAlteracaoRequest corteAlteracaoRequest) {
		log.info("[inicia] ServicoApplicationService - alteraServico");
		Servico servico = servicoRepository.buscaServicoPorId(idServico);
		servico.altera(corteAlteracaoRequest);
		servicoRepository.salva(servico);
		log.info("[finaliza] ServicoApplicationService - alteraServico");
	}

}
