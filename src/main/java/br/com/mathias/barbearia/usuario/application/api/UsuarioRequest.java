package br.com.mathias.barbearia.usuario.application.api;

import jakarta.validation.constraints.NotBlank;
import lombok.Value;

@Value
public class UsuarioRequest {
	@NotBlank
	private String nome;
	@NotBlank
	private String telefone;
	
}
