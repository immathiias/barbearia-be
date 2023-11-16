package br.com.mathias.barbearia.usuario.application.api;

import java.util.List;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;

import br.com.mathias.barbearia.usuario.application.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RestController
@Validated
@Log4j2
@RequiredArgsConstructor
public class UsuarioController implements UsuarioAPI {

	private final UsuarioService usuarioService;

	@Override
	public UsuarioResponse postUsuario(UsuarioRequest usuario) {
		log.info("[inicia] UsuarioController - postUsuario");
		UsuarioResponse usuarioCriado = usuarioService.criaUsuario(usuario);
		log.info("[finaliza] UsuarioController - postUsuario");
		return usuarioCriado;
	}

	@Override
	public List<UsuarioListResponse> getTodosUsuarios() {
		log.info("[inicia] UsuarioController - getTodosUsuarios");
		log.info("[finaliza] UsuarioController - getTodosUsuarios");
		return null;
	}

}
