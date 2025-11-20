package com.caixa.caixaverso_desafio.services;

import com.caixa.caixaverso_desafio.dtos.PerfilRiscoDTO;
import com.caixa.caixaverso_desafio.entities.Cliente;
import com.caixa.caixaverso_desafio.repositories.ClienteRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PerfilRiscoServiceTest {

    @InjectMocks
    private PerfilRiscoService perfilRiscoService;

    @Mock
    private ClienteRepository clienteRepository;

    @Test
    @DisplayName("Deve definir o perfil do cliente como conservador")
    void definirPerfilConservador() {

        Cliente clienteTeste = new Cliente();
        clienteTeste.setClienteId(1L);
        clienteTeste.setVolumeInvestimentos(new BigDecimal("1500.00"));
        clienteTeste.setFrequenciaMovimentacoes(2);
        clienteTeste.setPreferencia("Liquidez");

        when(clienteRepository.findById(1L)).thenReturn(Optional.of(clienteTeste));

        PerfilRiscoDTO perfilCliente = perfilRiscoService.calcularPerfilRisco(1l);
        assertEquals("Conservador", perfilCliente.getPerfil());
        assertEquals(20, perfilCliente.getPontuacao());
    }

    @Test
    @DisplayName("Deve definir o perfil do cliente como moderado")
    void definirPerfilModerado() {

        Cliente clienteTeste = new Cliente();
        clienteTeste.setClienteId(1L);
        clienteTeste.setVolumeInvestimentos(new BigDecimal("15000.00"));
        clienteTeste.setFrequenciaMovimentacoes(5);
        clienteTeste.setPreferencia("Equilíbrio");

        when(clienteRepository.findById(1L)).thenReturn(Optional.of(clienteTeste));

        PerfilRiscoDTO perfilCliente = perfilRiscoService.calcularPerfilRisco(1l);
        assertEquals("Moderado", perfilCliente.getPerfil());
        assertEquals(50, perfilCliente.getPontuacao());
    }

    @Test
    @DisplayName("Deve definir o perfil do cliente como agressivo")
    void definirPerfilAgressivo() {

        Cliente clienteTeste = new Cliente();
        clienteTeste.setClienteId(1L);
        clienteTeste.setVolumeInvestimentos(new BigDecimal("50000.00"));
        clienteTeste.setFrequenciaMovimentacoes(15);
        clienteTeste.setPreferencia("Rentabilidade");

        when(clienteRepository.findById(1L)).thenReturn(Optional.of(clienteTeste));

        PerfilRiscoDTO perfilCliente = perfilRiscoService.calcularPerfilRisco(1l);
        assertEquals("Agressivo", perfilCliente.getPerfil());
        assertEquals(100, perfilCliente.getPontuacao());
    }
}
