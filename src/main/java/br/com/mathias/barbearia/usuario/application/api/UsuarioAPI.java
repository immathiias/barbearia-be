package br.com.mathias.barbearia.usuario.application.api;

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
@RequestMapping("/v1/usuario")
public interface UsuarioAPI {
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	UsuarioResponse postUsuario(@RequestBody @Valid UsuarioRequest usuario);
	
	@GetMapping
	@ResponseStatus(code = HttpStatus.OK)
	List<UsuarioListResponse> getTodosUsuarios();
	
	@GetMapping("/{idUsuario}")
	@ResponseStatus(code = HttpStatus.OK)
	UsuarioDetalhadoResponse getUsuarioPorId(@PathVariable UUID idUsuario);
	
	@DeleteMapping("/{idUsuario}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	void deleteUsuarioPorId(@PathVariable UUID idUsuario);
	
	@PatchMapping("/{idUsuario}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	void patchUsuarioPorId(@PathVariable UUID idUsuario, @RequestBody @Valid UsuarioAlteracaoRequest usuarioAlteracaoRequest);

}
