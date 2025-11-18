package com.caixa.caixaverso_desafio.services;

import com.caixa.caixaverso_desafio.dtos.PeriodoDTO;
import com.caixa.caixaverso_desafio.dtos.TelemetriaDTO;
import com.caixa.caixaverso_desafio.dtos.TelemetriaServicoDTO;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class TelemetriaService {

    private final Map<String, DadosMetrica> metricas = new ConcurrentHashMap();

    private final LocalDateTime inicio = LocalDateTime.now();

    public void registrarChamada(String uri, Long tempoExecucao) {

        if(uri.contains("/telemetria") || uri.contains("/h2-console") || uri.contains("favicon")) {
            return;
        }

        metricas.computeIfAbsent(uri, k -> new DadosMetrica()).atualizar(tempoExecucao);
    }

    public TelemetriaDTO criarRelatorio() {

        List<TelemetriaServicoDTO> servicos = new ArrayList<>();

        metricas.forEach((uri, dados) -> {
            Long qtd = dados.quantidade.get();
            Long tempoTotal = dados.tempoTotal.get();
            Long media = qtd > 0 ? tempoTotal / qtd : 0;

            String nomeServico = uri.startsWith("/") ? uri.substring(1) : uri;

            servicos.add(new TelemetriaServicoDTO(nomeServico, qtd, media));

        });

        PeriodoDTO periodo = new PeriodoDTO(inicio, LocalDateTime.now());

        return new TelemetriaDTO(servicos, periodo);
    }

    private static class DadosMetrica {

        final AtomicLong quantidade = new AtomicLong(0);
        final AtomicLong tempoTotal = new AtomicLong(0);

        void atualizar(Long tempo) {
            quantidade.incrementAndGet();
            tempoTotal.addAndGet(tempo);
        }
    }
}
