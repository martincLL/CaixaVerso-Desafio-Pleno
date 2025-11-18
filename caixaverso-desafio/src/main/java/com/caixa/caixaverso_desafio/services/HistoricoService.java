package com.caixa.caixaverso_desafio.services;

import com.caixa.caixaverso_desafio.dtos.HistoricoInvestimentoDTO;
import com.caixa.caixaverso_desafio.entities.Historico;
import com.caixa.caixaverso_desafio.repositories.HistoricoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class HistoricoService {

    @Autowired
    private HistoricoRepository historicoRepository;

    @Transactional(readOnly = true)
    public List<HistoricoInvestimentoDTO> getInvestimentosPorClienteId(Long clienteId){

        List<Historico> historicoInvestimentos = historicoRepository.findByClienteId(clienteId);

        return historicoInvestimentos.stream().map(HistoricoInvestimentoDTO::new)
                .collect(Collectors.toList());
    }
}
