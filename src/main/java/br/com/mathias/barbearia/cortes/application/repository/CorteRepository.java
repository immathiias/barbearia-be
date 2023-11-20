package br.com.mathias.barbearia.cortes.application.repository;

import java.util.List;

import br.com.mathias.barbearia.cortes.domain.Corte;

public interface CorteRepository {
	Corte salva(Corte corteNovo);
	List<Corte> buscaTodosCortes();
}
