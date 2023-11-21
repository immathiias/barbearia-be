package br.com.mathias.barbearia.agendamento.infra;

import br.com.mathias.barbearia.agendamento.application.repository.AgendamentoRepository;
import br.com.mathias.barbearia.agendamento.domain.Agendamento;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

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

    @Override
    public Agendamento buscaAgendamentoPorId(UUID idAgendamento) {
        log.info("[inicia] AgendamentoInfraRepository - buscaAgendamentoPorId");
        Agendamento agendamento = agendamentoMongoSpringRepository.findById(idAgendamento)
                .orElseThrow(() -> new RuntimeException("Agendamento não encontrado!"));
        log.info("[finaliza] AgendamentoInfraRepository - buscaAgendamentoPorId");
        return agendamento;
    }
}
