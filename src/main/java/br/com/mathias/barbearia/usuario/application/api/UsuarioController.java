package br.com.mathias.barbearia.usuario.application.api;

import org.springframework.web.bind.annotation.RestController;

import lombok.extern.log4j.Log4j2;

@RestController
@Log4j2
public class UsuarioController implements UsuarioAPI {

	@Override
	public UsuarioResponse postUsuario(UsuarioRequest usuario) {
		log.info("[inicia] UsuarioController - postUsuario");
		log.info("[finaliza] UsuarioController - postUsuario");
		return null;
	}

}
