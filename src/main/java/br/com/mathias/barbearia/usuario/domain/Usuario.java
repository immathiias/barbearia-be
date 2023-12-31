package br.com.mathias.barbearia.usuario.domain;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import br.com.mathias.barbearia.usuario.application.api.UsuarioAlteracaoRequest;
import br.com.mathias.barbearia.usuario.application.api.UsuarioRequest;
import jakarta.validation.constraints.NotBlank;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Document(collection = "Usuario")
public class Usuario {
	@Id
	private UUID idUsuario;
	@NotBlank
	private String nomeUsuario;
	@NotBlank
	@Indexed(unique = true)
	private String telefone;
	
	private LocalDateTime dataHoraDoCadastro;
	private LocalDateTime dataHoraUltimaAtualizacao;
	
	public Usuario(UsuarioRequest usuario) {
		this.idUsuario = UUID.randomUUID();
		this.nomeUsuario = usuario.getNome();
		this.telefone = usuario.getTelefone();
		this.dataHoraDoCadastro = LocalDateTime.now();
	}

	public void altera(UsuarioAlteracaoRequest usuarioAlteracaoRequest) {
		this.nomeUsuario = usuarioAlteracaoRequest.getNome();
		this.telefone = usuarioAlteracaoRequest.getTelefone();
		this.dataHoraUltimaAtualizacao = LocalDateTime.now();
	}
}
