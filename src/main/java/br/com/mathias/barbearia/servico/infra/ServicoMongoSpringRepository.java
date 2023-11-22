package br.com.mathias.barbearia.servico.infra;

import java.util.UUID;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.mathias.barbearia.servico.domain.Servico;

public interface ServicoMongoSpringRepository extends MongoRepository<Servico, UUID> {

}
