package br.com.mathias.barbearia.usuario.application.api;

import java.util.UUID;

import br.com.mathias.barbearia.usuario.domain.Usuario;
import lombok.Value;

@Value
public class UsuarioDetalhadoResponse {
	private UUID idUsuario;
	private String nomeUsuario;
	private String telefone;
	
	public UsuarioDetalhadoResponse(Usuario usuario) {
		this.idUsuario = usuario.getIdUsuario();
		this.nomeUsuario = usuario.getNomeUsuario();
		this.telefone = usuario.getTelefone();
	}
}
