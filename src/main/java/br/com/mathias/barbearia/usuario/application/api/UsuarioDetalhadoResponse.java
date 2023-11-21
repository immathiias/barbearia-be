package br.com.mathias.barbearia.usuario.application.api;

import br.com.mathias.barbearia.usuario.domain.Usuario;
import lombok.Value;

import java.time.LocalDateTime;
import java.util.UUID;

@Value
public class UsuarioDetalhadoResponse {
	private UUID idUsuario;
	private String nomeUsuario;
	private String telefone;
	private LocalDateTime dataHoraDoCadastro;
	
	public UsuarioDetalhadoResponse(Usuario usuario) {
		this.idUsuario = usuario.getIdUsuario();
		this.nomeUsuario = usuario.getNomeUsuario();
		this.telefone = usuario.getTelefone();
		this.dataHoraDoCadastro = usuario.getDataHoraDoCadastro();
	}
}
