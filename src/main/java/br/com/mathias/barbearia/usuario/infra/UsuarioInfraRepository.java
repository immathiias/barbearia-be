package br.com.mathias.barbearia.usuario.infra;

import java.util.List;
import java.util.UUID;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Repository;

import br.com.mathias.barbearia.usuario.application.repository.UsuarioRepository;
import br.com.mathias.barbearia.usuario.domain.Usuario;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Repository
@Log4j2
@RequiredArgsConstructor
public class UsuarioInfraRepository implements UsuarioRepository {

	private final UsuarioMongoSpringRepository usuarioMongoRepository;
	
	@Override
	public Usuario salva(Usuario usuarioNovo) {
		log.info("[inicia] UsuarioInfraRepository - salva");
		try {
			usuarioMongoRepository.save(usuarioNovo);
		} catch (DataIntegrityViolationException e) {
			throw new RuntimeException("Existem dados duplicados.");
		}
		log.info("[finaliza] UsuarioInfraRepository - salva");
		return usuarioNovo;
	}

	@Override
	public List<Usuario> buscaTodosUsuarios() {
		log.info("[inicia] UsuarioInfraRepository - buscaTodosUsuarios");
		List<Usuario> usuarios = usuarioMongoRepository.findAll();
		log.info("[finaliza] UsuarioInfraRepository - buscaTodosUsuarios");
		return usuarios;
	}

	@Override
	public Usuario buscaUsuarioPorId(UUID idUsuario) {
		log.info("[inicia] UsuarioInfraRepository - buscaUsuarioPorId");
		Usuario usuario = usuarioMongoRepository.findById(idUsuario)
				.orElseThrow(() -> new RuntimeException("Usuário não encontrado."));
		log.info("[finaliza] UsuarioInfraRepository - buscaUsuarioPorId");
		return usuario;
	}

	@Override
	public void deletaUsuario(Usuario usuario) {
		log.info("[inicia] UsuarioInfraRepository - deletaUsuario");
		usuarioMongoRepository.delete(usuario);
		log.info("[finaliza] UsuarioInfraRepository - deletaUsuario");
	}

}
