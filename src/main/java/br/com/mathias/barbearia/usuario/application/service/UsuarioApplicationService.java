package br.com.mathias.barbearia.usuario.application.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import br.com.mathias.barbearia.usuario.application.api.UsuarioAlteracaoRequest;
import br.com.mathias.barbearia.usuario.application.api.UsuarioDetalhadoResponse;
import br.com.mathias.barbearia.usuario.application.api.UsuarioListResponse;
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
		return UsuarioResponse.builder()
				.idUsuario(usuarioNovo.getIdUsuario())
				.build();
	}

	@Override
	public List<UsuarioListResponse> buscaTodosUsuarios() {
		log.info("[inicia] UsuarioApplicationService - buscaTodosUsuarios");
		List<Usuario> usuarios = usuarioRepository.buscaTodosUsuarios();
		log.info("[finaliza] UsuarioApplicationService - buscaTodosUsuarios");
		return UsuarioListResponse.converte(usuarios);
	}

	@Override
	public UsuarioDetalhadoResponse buscaUsuarioPorId(UUID idUsuario) {
		log.info("[inicia] UsuarioApplicationService - buscaUsuarioPorId");
		Usuario usuario = usuarioRepository.buscaUsuarioPorId(idUsuario);
		log.info("[finaliiza] UsuarioApplicationService - buscaUsuarioPorId");
		return new UsuarioDetalhadoResponse(usuario);
	}

	@Override
	public void deletaUsuarioPorId(UUID idUsuario) {
		log.info("[inicia] UsuarioApplicationService - deletaUsuarioPorId");
		Usuario usuario = usuarioRepository.buscaUsuarioPorId(idUsuario);
		usuarioRepository.deletaUsuario(usuario);
		log.info("[finaliza] UsuarioApplicationService - deletaUsuarioPorId");
	}

	@Override
	public void atualizaUsuarioPorId(UUID idUsuario, UsuarioAlteracaoRequest usuarioAlteracaoRequest) {
		log.info("[inicia] UsuarioApplicationService - atualizaUsuarioPorId");
		Usuario usuario = usuarioRepository.buscaUsuarioPorId(idUsuario);
		usuario.altera(usuarioAlteracaoRequest);
		usuarioRepository.salva(usuario);
		log.info("[finaliza] UsuarioApplicationService - atualizaUsuarioPorId");
		
	}

}
