package br.com.mathias.barbearia.agendamento.infra;

import br.com.mathias.barbearia.agendamento.application.repository.AgendamentoRepository;
import br.com.mathias.barbearia.agendamento.domain.Agendamento;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Repository;

import java.util.List;

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

    @Override
    public List<Agendamento> buscaTodosAgendamentos() {
        log.info("[inicia] AgendamentoInfraRepository - buscaTodosAgendamentos");
        List<Agendamento> agendamentos = agendamentoMongoSpringRepository.findAll();
        log.info("[finaliza] AgendamentoInfraRepository - buscaTodosAgendamentos");
        return agendamentos;
    }
}
