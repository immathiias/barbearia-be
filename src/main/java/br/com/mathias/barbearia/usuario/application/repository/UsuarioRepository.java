package br.com.mathias.barbearia.usuario.application.repository;

import java.util.List;
import java.util.UUID;

import br.com.mathias.barbearia.usuario.domain.Usuario;

public interface UsuarioRepository {

	Usuario salva(Usuario usuarioNovo);

	List<Usuario> buscaTodosUsuarios();

	Usuario buscaUsuarioPorId(UUID idUsuario);

}
