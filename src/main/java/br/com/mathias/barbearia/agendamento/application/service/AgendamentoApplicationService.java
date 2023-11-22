package br.com.mathias.barbearia.agendamento.application.service;

import br.com.mathias.barbearia.agendamento.application.api.*;
import br.com.mathias.barbearia.agendamento.application.repository.AgendamentoRepository;
import br.com.mathias.barbearia.agendamento.domain.Agendamento;
import br.com.mathias.barbearia.servico.application.repository.ServicoRepository;
import br.com.mathias.barbearia.servico.domain.Servico;
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
    private final ServicoRepository servicoRepository;

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
                        servicoRepository.buscaServicoPorId(agenda.getServicoId())
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
        Servico servico = servicoRepository.buscaServicoPorId(agendamentoDetalhado.getServicoId());
        log.info("[finaliza] AgendamentoApplicationService - buscaAgendamentoPorId");
        return new AgendamentoDetalhadoResponse(agendamentoDetalhado, usuario, servico);
    }

    @Override
    public void deletaAgendamentoPorId(UUID idAgendamento) {
        log.info("[inicia] AgendamentoApplicationService - deletaAgendamentoPorId");
        Agendamento agendamento = agendamentoRepository.buscaAgendamentoPorId(idAgendamento);
        agendamentoRepository.deletaAgendamento(agendamento);
        log.info("[finaliza] AgendamentoApplicationService - deletaAgendamentoPorId");
    }

    @Override
    public void alteraAgendamentoPorId(UUID idAgendamento, AgendamentoAlteracaoRequest agendamentoAlteracaoRequest) {
        log.info("[inicia] AgendamentoApplicationService - alteraAgendamentoPorId");
        Agendamento agendamento = agendamentoRepository.buscaAgendamentoPorId(idAgendamento);
        agendamento.altera(agendamentoAlteracaoRequest);
        agendamentoRepository.salva(agendamento);
        log.info("[finaliza] AgendamentoApplicationService - alteraAgendamentoPorId");
    }
}
