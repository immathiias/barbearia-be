package br.com.mathias.barbearia.servico.domain;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import br.com.mathias.barbearia.servico.application.api.ServicoAlteracaoRequest;
import br.com.mathias.barbearia.servico.application.api.ServicoRequest;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Document(collection = "Servicos")
public class Servico {
	
	@Id
	private UUID idServico;
	@NotBlank
	private String nomeServico;
	@NotNull
	private Double valorServico;
	@NotNull
	private TipoServico tipoServico;
	private Integer tempoEstimadoEmMinutos;
	
	private LocalDateTime dataHoraDoCadastro;
	private LocalDateTime dataHoraUltimaAtualizacao;
	
	
	public Servico(ServicoRequest servicoRequest) {
		this.idServico = UUID.randomUUID();
		this.nomeServico = servicoRequest.getNomeServico();
		this.valorServico = servicoRequest.getValorServico();
		this.tipoServico = servicoRequest.getTipoServico();
		this.tempoEstimadoEmMinutos = servicoRequest.getTempoEstimado();
		this.dataHoraDoCadastro = LocalDateTime.now();
	}


	public void altera(ServicoAlteracaoRequest servicoAlteracaoRequest) {
		this.nomeServico = servicoAlteracaoRequest.getNomeServico();
		this.valorServico = servicoAlteracaoRequest.getValorServico();
		this.tipoServico = servicoAlteracaoRequest.getTipoServico();
		this.tempoEstimadoEmMinutos = servicoAlteracaoRequest.getTempoEstimado();
	}
}
