package br.com.mathias.barbearia.servico.application.api;

import java.util.List;
import java.util.UUID;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;

import br.com.mathias.barbearia.servico.application.service.ServicoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RestController
@Validated
@Log4j2
@RequiredArgsConstructor

public class ServicoController implements ServicoAPI {
	private final ServicoService servicoService;

	@Override
	public ServicoResponse postServico(ServicoRequest servicoRequest) {
		log.info("[inicia] ServicoController - postServico");
		ServicoResponse servico = servicoService.criaServico(servicoRequest);
		log.info("[finaliza] ServicoController - postServico");
		return servico;
	}

	@Override
	public List<ServicoListResponse> getTodosServicos() {
		log.info("[inicia] ServicoController - getTodosServicos");
		List<ServicoListResponse> servicos = servicoService.buscaTodosServicos();
		log.info("[finaliza] ServicoController - getTodosServicos");
		return servicos;
	}

	@Override
	public ServicoDetalhadoResponse getServicoPorId(UUID idServico) {
		log.info("[inicia] ServicoController - getServicoPorId");
		log.info("[idServico] {}", idServico);
		ServicoDetalhadoResponse servicoDetalhado = servicoService.buscaServicoPorId(idServico);
		log.info("[finaliza] ServicoController - getServicoPorId");
		return servicoDetalhado;
	}

	@Override
	public void deleteServicoPorId(UUID idServico) {
		log.info("[inicia] ServicoController - deleteServicoPorId");
		log.info("[idServico] {}", idServico);
		servicoService.deletaServicoPorId(idServico);
		log.info("[finaliza] ServicoController - deleteServicoPorId");
	}

	@Override
	public void patchServicoPorId(UUID idServico, ServicoAlteracaoRequest servicoAlteracaoRequest) {
		log.info("[inicia] ServicoController - patchServicoPorId");
		log.info("[idServico] {}", idServico);
		servicoService.alteraServico(idServico, servicoAlteracaoRequest);
		log.info("[finaliza] ServicoController - patchServicoPorId");
	}

}
