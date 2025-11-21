package com.caixa.caixaverso_desafio.config;

import com.caixa.caixaverso_desafio.entities.Cliente;
import com.caixa.caixaverso_desafio.entities.Historico;
import com.caixa.caixaverso_desafio.entities.Produto;
import com.caixa.caixaverso_desafio.entities.Usuario;
import com.caixa.caixaverso_desafio.entities.UserRole;
import com.caixa.caixaverso_desafio.repositories.ClienteRepository;
import com.caixa.caixaverso_desafio.repositories.HistoricoRepository;
import com.caixa.caixaverso_desafio.repositories.ProdutoRepository;
import com.caixa.caixaverso_desafio.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;

@Configuration
public class BancoDeDadosSeeder implements CommandLineRunner {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private HistoricoRepository historicoRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        if (usuarioRepository.count() == 0) {
            seedUsuarios();
            seedProdutos();
            seedClientesEHistorico();
        }
    }

    private void seedUsuarios() {
        Usuario admin = new Usuario(
                "admin",
                passwordEncoder.encode("senha"),
                UserRole.ADMIN
        );
        usuarioRepository.save(admin);

        Usuario user = new Usuario(
                "usuario",
                passwordEncoder.encode("senha"),
                UserRole.USER
        );
        usuarioRepository.save(user);
    }

    private void seedProdutos() {
        Produto p1 = new Produto(null, "CDB Caixa 2026", "CDB", new BigDecimal("0.125"), "Baixo", 12, new BigDecimal("1000.00"));
        Produto p2 = new Produto(null, "LCI Imobiliário CAIXA", "LCI", new BigDecimal("0.098"), "Baixo", 6, new BigDecimal("5000.00"));
        Produto p3 = new Produto(null, "Tesouro Selic 2029", "Tesouro Direto", new BigDecimal("0.1075"), "Baixo", 1, new BigDecimal("150.00"));

        Produto p4 = new Produto(null, "CDB Progressivo 3 Anos", "CDB", new BigDecimal("0.135"), "Médio", 36, new BigDecimal("5000.00"));
        Produto p5 = new Produto(null, "Fundo Multimercado Macro", "Fundo", new BigDecimal("0.15"), "Médio", 12, new BigDecimal("2500.00"));

        Produto p6 = new Produto(null, "Fundo Ações Ibovespa", "Fundo", new BigDecimal("0.22"), "Alto", 24, new BigDecimal("1000.00"));
        Produto p7 = new Produto(null, "Fundo Crypto Experience", "Fundo", new BigDecimal("0.45"), "Alto", 12, new BigDecimal("500.00"));

        produtoRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5, p6, p7));
    }

    private void seedClientesEHistorico() {
        Cliente c1 = new Cliente(null, "Conservador", 20, new BigDecimal("15000.00"), 2, "Liquidez");
        c1 = clienteRepository.save(c1);

        Historico h1 = new Historico(null, "CDB", new BigDecimal("10000.00"), new BigDecimal("0.11"), LocalDate.now().minusMonths(12), c1);
        Historico h2 = new Historico(null, "LCI", new BigDecimal("5000.00"), new BigDecimal("0.09"), LocalDate.now().minusMonths(6), c1);
        historicoRepository.saveAll(Arrays.asList(h1, h2));

        Cliente c2 = new Cliente(null, "Moderado", 65, new BigDecimal("50000.00"), 10, "Equilíbrio");
        c2 = clienteRepository.save(c2);

        Historico h3 = new Historico(null, "CDB", new BigDecimal("20000.00"), new BigDecimal("0.12"), LocalDate.now().minusMonths(24), c2);
        Historico h4 = new Historico(null, "Fundo", new BigDecimal("30000.00"), new BigDecimal("0.15"), LocalDate.now().minusMonths(3), c2);
        historicoRepository.saveAll(Arrays.asList(h3, h4));

        Cliente c3 = new Cliente(null, "Agressivo", 90, new BigDecimal("150000.00"), 25, "Rentabilidade");
        c3 = clienteRepository.save(c3);

        Historico h5 = new Historico(null, "Fundo Ações", new BigDecimal("150000.00"), new BigDecimal("0.18"), LocalDate.now().minusMonths(10), c3);
        historicoRepository.save(h5);
    }
}