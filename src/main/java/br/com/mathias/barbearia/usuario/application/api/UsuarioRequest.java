package br.com.mathias.barbearia.usuario.application.api;

import lombok.Value;

@Value
public class UsuarioRequest {
	
	private String nome;
	private String telefone;
	
}
