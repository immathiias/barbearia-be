package br.com.mathias.barbearia.cortes.domain;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import br.com.mathias.barbearia.cortes.application.api.CorteAlteracaoRequest;
import br.com.mathias.barbearia.cortes.application.api.CorteRequest;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Document(collection = "Cortes")
public class Corte {
	
	@Id
	private UUID idCorte;
	@NotBlank
	private String nomeCorte;
	@NotNull
	private Double valorCorte;
	private Integer tempoEstimadoEmMinutos;
	
	private LocalDateTime dataHoraDoCadastro;
	private LocalDateTime dataHoraUltimaAtualizacao;
	
	
	public Corte(CorteRequest corteRequest) {
		this.idCorte = UUID.randomUUID();
		this.nomeCorte = corteRequest.getNomeCorte();
		this.valorCorte = corteRequest.getValorCorte();
		this.tempoEstimadoEmMinutos = corteRequest.getTempoEstimado();
		this.dataHoraDoCadastro = LocalDateTime.now();
	}


	public void altera(CorteAlteracaoRequest corteAlteracaoRequest) {
		this.nomeCorte = corteAlteracaoRequest.getNomeCorte();
		this.valorCorte = corteAlteracaoRequest.getValorCorte();
		this.tempoEstimadoEmMinutos = corteAlteracaoRequest.getTempoEstimado();
	}
}
