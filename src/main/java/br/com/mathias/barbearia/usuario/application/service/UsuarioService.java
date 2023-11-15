package br.com.mathias.barbearia.usuario.application.service;

import br.com.mathias.barbearia.usuario.application.api.UsuarioRequest;
import br.com.mathias.barbearia.usuario.application.api.UsuarioResponse;

public interface UsuarioService {

	UsuarioResponse criaUsuario(UsuarioRequest usuario);

}
