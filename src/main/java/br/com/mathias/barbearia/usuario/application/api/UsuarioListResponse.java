package br.com.mathias.barbearia.usuario.application.api;

import java.util.List;
import java.util.stream.Collectors;

import br.com.mathias.barbearia.usuario.domain.Usuario;
import lombok.Value;

@Value
public class UsuarioListResponse {
	
	private String nomeUsuario;
	private String telefone;
	
	public static List<UsuarioListResponse> converte(List<Usuario> usuarios) {
		return usuarios.stream()
				.map(UsuarioListResponse::new)
				.collect(Collectors.toList());
	}

	public UsuarioListResponse(Usuario usuario) {
		this.nomeUsuario = usuario.getNomeUsuario();
		this.telefone = usuario.getTelefone();
	}
	
}
