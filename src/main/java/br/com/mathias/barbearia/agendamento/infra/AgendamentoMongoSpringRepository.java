package br.com.mathias.barbearia.agendamento.infra;

import br.com.mathias.barbearia.agendamento.domain.Agendamento;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface AgendamentoMongoSpringRepository extends MongoRepository<Agendamento, UUID> {
}
