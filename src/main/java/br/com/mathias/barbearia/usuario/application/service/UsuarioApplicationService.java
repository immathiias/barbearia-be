package br.com.mathias.barbearia.usuario.application.service;

import org.springframework.stereotype.Service;

import br.com.mathias.barbearia.usuario.application.api.UsuarioRequest;
import br.com.mathias.barbearia.usuario.application.api.UsuarioResponse;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class UsuarioApplicationService implements UsuarioService {

	@Override
	public UsuarioResponse criaUsuario(UsuarioRequest usuario) {
		log.info("[inicia] UsuarioApplicationService - criaUsuario");
		log.info("[finaliza] UsuarioApplicationService - criaUsuario");
		return null;
	}

}
