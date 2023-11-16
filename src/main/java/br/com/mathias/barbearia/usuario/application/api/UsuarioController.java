package br.com.mathias.barbearia.usuario.application.api;

import java.util.List;
import java.util.UUID;

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
		List<UsuarioListResponse> usuarios = usuarioService.buscaTodosUsuarios();
		log.info("[finaliza] UsuarioController - getTodosUsuarios");
		return usuarios;
	}

	@Override
	public UsuarioDetalhadoResponse getUsuarioPorId(UUID idUsuario) {
		log.info("[inicia] UsuarioController - getUsuarioPorId");
		UsuarioDetalhadoResponse usuarioDetalhado = usuarioService.buscaUsuarioPorId(idUsuario);
		log.info("[finaliza] UsuarioController - getUsuarioPorId");
		return usuarioDetalhado;
	}

	@Override
	public void deleteUsuarioPorId(UUID idUsuario) {
		log.info("[inicia] UsuarioController - deleteUsuarioPorId");
		log.info("[finaliza] UsuarioController - deleteUsuarioPorId");
		
	}

}
