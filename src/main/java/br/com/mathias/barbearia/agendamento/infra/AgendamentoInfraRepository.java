package br.com.mathias.barbearia.agendamento.infra;

import br.com.mathias.barbearia.agendamento.application.repository.AgendamentoRepository;
import br.com.mathias.barbearia.agendamento.domain.Agendamento;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Repository;

@Repository
@Log4j2
@RequiredArgsConstructor
public class AgendamentoInfraRepository implements AgendamentoRepository {
    private final AgendamentoMongoSpringRepository agendamentoMongoSpringRepository;

    @Override
    public Agendamento salva(Agendamento agendamentoNovo) {
        log.info("[inicia] AgendamentoInfraRepository - salva");
        try {
            agendamentoMongoSpringRepository.save(agendamentoNovo);
        } catch (DataIntegrityViolationException e) {
            throw new RuntimeException("Existem dados duplicados.");
        }
        log.info("[finaliza] AgendamentoInfraRepository - salva");
        return agendamentoNovo;
    }
}
