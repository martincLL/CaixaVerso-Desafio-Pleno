package com.caixa.caixaverso_desafio.repositories;

import com.caixa.caixaverso_desafio.dtos.RelatorioSimulacaoDTO;
import com.caixa.caixaverso_desafio.entities.Simulacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SimulacaoRepository extends JpaRepository<Simulacao, Long> {

    @Query("""
       SELECT new com.caixa.caixaverso_desafio.dtos.RelatorioSimulacaoDTO(
            s.produto, 
            CAST(s.dataSimulacao AS LocalDate), 
            COUNT(s), 
            AVG(s.valorFinal)
       )
       FROM Simulacao s 
       GROUP BY s.produto, CAST(s.dataSimulacao AS LocalDate)
       """)
    List<RelatorioSimulacaoDTO> relatorioProdutoDia();
}
