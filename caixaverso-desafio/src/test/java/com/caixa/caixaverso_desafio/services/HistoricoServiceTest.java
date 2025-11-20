package com.caixa.caixaverso_desafio.services;

import com.caixa.caixaverso_desafio.dtos.HistoricoInvestimentoDTO;
import com.caixa.caixaverso_desafio.entities.Cliente;
import com.caixa.caixaverso_desafio.entities.Historico;
import com.caixa.caixaverso_desafio.repositories.HistoricoRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class HistoricoServiceTest {

    @InjectMocks
    private HistoricoService historicoService;

    @Mock
    private HistoricoRepository historicoRepository;

    @Test
    @DisplayName("Deve retornar o historico de investimentos do cliente")
    void RetornarHistoricoInvestimentos() {

        Cliente clienteTeste = new Cliente();
        clienteTeste.setClienteId(1L);

        Historico historico = new Historico();
        historico.setId(4L);
        historico.setTipo("CDB");
        historico.setValor(new BigDecimal("2500.00"));
        historico.setRentabilidade(new BigDecimal("0.13"));
        historico.setDataInvestimento(LocalDate.now());
        historico.setCliente(clienteTeste);

        when(historicoRepository.findByClienteId(1L)).thenReturn(List.of(historico));
        List<HistoricoInvestimentoDTO> listaHistorico = historicoService.getInvestimentosPorClienteId(1L);

        assertFalse(listaHistorico.isEmpty());
        assertEquals("CDB", listaHistorico.get(0).getTipo());
        assertEquals(new BigDecimal("2500.00"), listaHistorico.get(0).getValor());
    }
}
