package br.com.mathias.barbearia.usuario.application.service;

import org.springframework.stereotype.Service;

import br.com.mathias.barbearia.usuario.application.api.UsuarioRequest;
import br.com.mathias.barbearia.usuario.application.api.UsuarioResponse;
import br.com.mathias.barbearia.usuario.application.repository.UsuarioRepository;
import br.com.mathias.barbearia.usuario.domain.Usuario;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
@RequiredArgsConstructor
public class UsuarioApplicationService implements UsuarioService {

	private final UsuarioRepository usuarioRepository;

	@Override
	public UsuarioResponse criaUsuario(UsuarioRequest usuario) {
		log.info("[inicia] UsuarioApplicationService - criaUsuario");
		Usuario usuarioNovo = new Usuario(usuario);
		usuarioRepository.salva(usuarioNovo);
		log.info("[finaliza] UsuarioApplicationService - criaUsuario");
		return new UsuarioResponse(usuarioNovo);
	}

}
