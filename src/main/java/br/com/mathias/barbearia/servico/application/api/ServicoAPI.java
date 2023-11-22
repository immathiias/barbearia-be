package br.com.mathias.barbearia.servico.application.api;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/v1/servico")
public interface ServicoAPI {
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	ServicoResponse postServico(@RequestBody @Valid ServicoRequest servicoRequest);
	
	@GetMapping
	@ResponseStatus(code = HttpStatus.OK)
	List<ServicoListResponse> getTodosServicos();
	
	@GetMapping("/{idServico}")
	@ResponseStatus(code = HttpStatus.OK)
	ServicoDetalhadoResponse getServicoPorId(@PathVariable UUID idServico);
	
	@DeleteMapping("/{idServico}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	void deleteServicoPorId(@PathVariable UUID idServico);
	
	@PatchMapping("/{idServico}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	void patchServicoPorId(@PathVariable UUID idServico, @RequestBody @Valid ServicoAlteracaoRequest servicoAlteracaoRequest);
}
