package br.com.mathias.barbearia.usuario.domain;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
@Document(collection = "Usuario")
public class Usuario {
	@MongoId
	private UUID idUsuario;
	private String nomeUsuario;
	private String telefone;
	
	private LocalDateTime dataHoraDoCadastro;
	private LocalDateTime dataHoraUltimaAtualizacao;
}
