package br.com.mathias.barbearia.usuario.application.service;

import java.util.List;
import java.util.UUID;

import br.com.mathias.barbearia.usuario.application.api.UsuarioDetalhadoResponse;
import br.com.mathias.barbearia.usuario.application.api.UsuarioListResponse;
import br.com.mathias.barbearia.usuario.application.api.UsuarioRequest;
import br.com.mathias.barbearia.usuario.application.api.UsuarioResponse;

public interface UsuarioService {

	UsuarioResponse criaUsuario(UsuarioRequest usuario);

	List<UsuarioListResponse> buscaTodosUsuarios();

	UsuarioDetalhadoResponse buscaUsuarioPorId(UUID idUsuario);

}
