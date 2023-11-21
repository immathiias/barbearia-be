package br.com.mathias.barbearia.agendamento.application.service;

import br.com.mathias.barbearia.agendamento.application.api.AgendamentoListResponse;
import br.com.mathias.barbearia.agendamento.application.api.AgendamentoRequest;
import br.com.mathias.barbearia.agendamento.application.api.AgendamentoResponse;
import br.com.mathias.barbearia.agendamento.application.repository.AgendamentoRepository;
import br.com.mathias.barbearia.agendamento.domain.Agendamento;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log4j2
@RequiredArgsConstructor
public class AgendamentoApplicationService implements AgendamentoService {
    private final AgendamentoRepository agendamentoRepository;

    @Override
    public AgendamentoResponse criaAgendamento(AgendamentoRequest agendamentoRequest) {
        log.info("[inicia] AgendamentoApplicationService - criaAgendamento");
        Agendamento agendamentoNovo = new Agendamento(agendamentoRequest);
        agendamentoRepository.salva(agendamentoNovo);
        log.info("[finaliza] AgendamentoApplicationService - criaAgendamento");
        return AgendamentoResponse.builder()
                .idAgendamento(agendamentoNovo.getIdAgendamento())
                .build();
    }

    @Override
    public List<AgendamentoListResponse> buscaTodosAgendamentos() {
        log.info("[inicia] AgendamentoApplicationService - buscaTodosAgendamentos");
        log.info("[finaliza] AgendamentoApplicationService - buscaTodosAgendamentos");
        return null;
    }
}
