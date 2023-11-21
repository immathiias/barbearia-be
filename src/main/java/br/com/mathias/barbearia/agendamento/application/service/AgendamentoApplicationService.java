package br.com.mathias.barbearia.agendamento.application.service;

import br.com.mathias.barbearia.agendamento.application.api.AgendamentoDetalhadoResponse;
import br.com.mathias.barbearia.agendamento.application.api.AgendamentoListResponse;
import br.com.mathias.barbearia.agendamento.application.api.AgendamentoRequest;
import br.com.mathias.barbearia.agendamento.application.api.AgendamentoResponse;
import br.com.mathias.barbearia.agendamento.application.repository.AgendamentoRepository;
import br.com.mathias.barbearia.agendamento.domain.Agendamento;
import br.com.mathias.barbearia.cortes.application.repository.CorteRepository;
import br.com.mathias.barbearia.cortes.domain.Corte;
import br.com.mathias.barbearia.usuario.application.repository.UsuarioRepository;
import br.com.mathias.barbearia.usuario.domain.Usuario;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Log4j2
@RequiredArgsConstructor
public class AgendamentoApplicationService implements AgendamentoService {
    private final AgendamentoRepository agendamentoRepository;
    private final UsuarioRepository usuarioRepository;
    private final CorteRepository corteRepository;

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

        List<Agendamento> agendamentos = agendamentoRepository.buscaTodosAgendamentos();
        List<AgendamentoListResponse> todosAgendamentos = agendamentos.stream()
                .map(agenda -> AgendamentoListResponse.converte(
                        agenda,
                        usuarioRepository.buscaUsuarioPorId(agenda.getUsuarioId()),
                        corteRepository.buscaCortePorId(agenda.getCorteId())
                ))
                .collect(Collectors.toList());

        log.info("[finaliza] AgendamentoApplicationService - buscaTodosAgendamentos");
        return todosAgendamentos;
    }

    @Override
    public AgendamentoDetalhadoResponse buscaAgendamentoPorId(UUID idAgendamento) {
        log.info("[inicia] AgendamentoApplicationService - buscaAgendamentoPorId");
        Agendamento agendamentoDetalhado = agendamentoRepository.buscaAgendamentoPorId(idAgendamento);
        Usuario usuario = usuarioRepository.buscaUsuarioPorId(agendamentoDetalhado.getUsuarioId());
        Corte corte = corteRepository.buscaCortePorId(agendamentoDetalhado.getCorteId());
        log.info("[finaliza] AgendamentoApplicationService - buscaAgendamentoPorId");
        return new AgendamentoDetalhadoResponse(agendamentoDetalhado, usuario, corte);
    }

    @Override
    public void deletaAgendamentoPorId(UUID idAgendamento) {
        log.info("[inicia] AgendamentoApplicationService - deletaAgendamentoPorId");
        Agendamento agendamento = agendamentoRepository.buscaAgendamentoPorId(idAgendamento);
        agendamentoRepository.deletaAgendamento(agendamento);
        log.info("[finaliza] AgendamentoApplicationService - deletaAgendamentoPorId");
    }
}
