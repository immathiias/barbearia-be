package br.com.mathias.barbearia.usuario.infra;

import java.util.List;

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
		usuarioMongoRepository.save(usuarioNovo);
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

}
