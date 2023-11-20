package br.com.mathias.barbearia.cortes.application.repository;

import java.util.List;
import java.util.UUID;

import br.com.mathias.barbearia.cortes.domain.Corte;

public interface CorteRepository {
	Corte salva(Corte corteNovo);
	List<Corte> buscaTodosCortes();
	Corte buscaCortePorId(UUID idCorte);
}
