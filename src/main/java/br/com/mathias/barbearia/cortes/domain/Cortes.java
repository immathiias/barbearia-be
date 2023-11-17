package br.com.mathias.barbearia.cortes.domain;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Document(collection = "Cortes")
public class Cortes {
	
	@Id
	private UUID idCortes;
	private String nomeCorte;
	private Double valorCorte;
	private Integer tempoEstimadoEmMinutos;
	
	private LocalDateTime dataHoraDoCadastro;
	private LocalDateTime dataHoraUltimaAtualizacao;
}
