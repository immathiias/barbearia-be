package br.com.mathias.barbearia.cortes.infra;

import java.util.UUID;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.mathias.barbearia.cortes.domain.Corte;

public interface CorteMongoSpringRepository extends MongoRepository<Corte, UUID> {

}
