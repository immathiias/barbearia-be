package br.com.mathias.barbearia.usuario.infra;

import java.util.UUID;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.mathias.barbearia.usuario.domain.Usuario;

public interface UsuarioMongoSpringRepository extends MongoRepository<Usuario, UUID> {

}
