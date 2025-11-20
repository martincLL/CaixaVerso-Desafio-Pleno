package com.caixa.caixaverso_desafio.controllers;

import com.caixa.caixaverso_desafio.dtos.HistoricoSimulacaoDTO;
import com.caixa.caixaverso_desafio.dtos.RelatorioSimulacaoDTO;
import com.caixa.caixaverso_desafio.dtos.SimulacaoRequestDTO;
import com.caixa.caixaverso_desafio.dtos.SimulacaoResponseDTO;
import com.caixa.caixaverso_desafio.services.SimulacaoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag(name = "Simulação de Investimentos", description = "Simular investimentos e consultar as simulações realizadas")
public class SimulacaoController {

    @Autowired
    private SimulacaoService simulacaoService;

    @Operation(summary = "Buscar todas as simulações", description = "Retorna todo o histórico de simulações realizadas")
    @ApiResponses(@ApiResponse(responseCode = "200", description = "Lista de simulação retornada com sucesso"))
    @GetMapping(value = "/simulacoes")
    public ResponseEntity<List<HistoricoSimulacaoDTO>> getHistorico() {

        List<HistoricoSimulacaoDTO> historico = simulacaoService.getHistoricoSimulacoes();
        return ResponseEntity.ok(historico);
    }

    @Operation(summary = "Simular um novo investimento", description = "Realiza a simulação e o cálculo de investimento em um produto específico")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Simulação foi realizada com sucesso"),
            @ApiResponse(responseCode = "400", description = "Dados da requisição estão inválidos"),
            @ApiResponse(responseCode = "404", description = "Cliente ou Produto não encontrado")
    })
    @PostMapping(value = "/simular-investimento")
    public ResponseEntity<SimulacaoResponseDTO> simularInvestimento(@RequestBody SimulacaoRequestDTO request) {

        SimulacaoResponseDTO response = simulacaoService.simularInvestimento(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @Operation(summary = "Buscar o relatório de simulação", description = "Retorna o relatório da simulação realizada")
    @ApiResponse(responseCode = "200", description = "Relatório de simulação retornado com sucesso")
    @GetMapping(value = "/simulacoes/por-produto-dia")
    public ResponseEntity<List<RelatorioSimulacaoDTO>> getRelatorioAgregado() {

        List<RelatorioSimulacaoDTO> relatorio = simulacaoService.relatorioProdutoDia();

        return ResponseEntity.ok(relatorio);
    }
}
