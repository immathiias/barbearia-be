package br.com.mathias.barbearia.usuario.application.api;

import java.util.UUID;

import br.com.mathias.barbearia.usuario.domain.Usuario;
import lombok.Value;

@Value
public class UsuarioResponse {
	private UUID idUsuario;
	
	public UsuarioResponse(Usuario usuarioNovo) {
		this.idUsuario = usuarioNovo.getIdUsuario();
	}
}
