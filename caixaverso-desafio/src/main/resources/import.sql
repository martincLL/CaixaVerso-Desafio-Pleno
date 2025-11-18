-- ##################################################################
-- 1. POPULAR TABELA DE PRODUTOS (tb_produtos)
-- ##################################################################

INSERT INTO tb_produtos (nome, tipo, rentabilidade, risco, prazo_minimo_meses, valor_minimo) VALUES ('CDB Caixa 2026', 'CDB', 0.125, 'Baixo', 12, 1000.00);

INSERT INTO tb_produtos (nome, tipo, rentabilidade, risco, prazo_minimo_meses, valor_minimo) VALUES ('LCI Imobiliário CAIXA', 'LCI', 0.098, 'Baixo', 6, 5000.00);

INSERT INTO tb_produtos (nome, tipo, rentabilidade, risco, prazo_minimo_meses, valor_minimo) VALUES ('LCA Agronegócio CAIXA', 'LCA', 0.105, 'Baixo', 24, 2500.00);

INSERT INTO tb_produtos (nome, tipo, rentabilidade, risco, prazo_minimo_meses, valor_minimo) VALUES ('Fundo CAIXA Agressivo', 'Fundo', 0.180, 'Alto', 36, 10000.00);

INSERT INTO tb_produtos (nome, tipo, rentabilidade, risco, prazo_minimo_meses, valor_minimo) VALUES ('Tesouro Direto 2035', 'Tesouro Direto', 0.110, 'Médio', 1, 100.00);


-- ##################################################################
-- 2. POPULAR TABELA DE CLIENTES (tb_clientes)
-- ##################################################################

-- Cliente 1 (Conservador)
INSERT INTO tb_clientes (perfil, pontuacao, volume_investimentos, frequencia_movimentacoes, preferencia) VALUES ('Conservador', 20, 15000.00, 2, 'Liquidez');

-- Cliente 2 (Moderado) - (Esta era a linha com erro, agora corrigida)
INSERT INTO tb_clientes (perfil, pontuacao, volume_investimentos, frequencia_movimentacoes, preferencia) VALUES ('Moderado', 65, 50000.00, 10, 'Equilíbrio');

-- Cliente 3 (Agressivo)
INSERT INTO tb_clientes (perfil, pontuacao, volume_investimentos, frequencia_movimentacoes, preferencia) VALUES ('Agressivo', 90, 150000.00, 25, 'Rentabilidade');

-- Cliente 4 (Ainda sem perfil)
INSERT INTO tb_clientes (perfil, pontuacao, volume_investimentos, frequencia_movimentacoes, preferencia) VALUES ('Indefinido', 0, 0.00, 0, 'Indefinido');


-- ##################################################################
-- 3. POPULAR HISTÓRICO DE INVESTIMENTOS (tb_historicos)
-- (Verificado para garantir que todos os 'VALUES' estão corretos)
-- ##################################################################

-- Histórico do Cliente 1 (Conservador)
INSERT INTO tb_historicos (tipo, valor, rentabilidade, data_investimento, cliente_id) VALUES ('CDB', 10000.00, 0.11, '2024-05-20', 1);

INSERT INTO tb_historicos (tipo, valor, rentabilidade, data_investimento, cliente_id) VALUES ('LCI', 5000.00, 0.09, '2025-01-10', 1);

-- Histórico do Cliente 2 (Moderado)
INSERT INTO tb_historicos (tipo, valor, rentabilidade, data_investimento, cliente_id) VALUES ('CDB', 20000.00, 0.12, '2023-11-01', 2);

INSERT INTO tb_historicos (tipo, valor, rentabilidade, data_investimento, cliente_id) VALUES ('Fundo', 30000.00, 0.15, '2024-08-15', 2);

-- Histórico do Cliente 3 (Agressivo)
INSERT INTO tb_historicos (tipo, valor, rentabilidade, data_investimento, cliente_id) VALUES ('Fundo', 150000.00, 0.18, '2024-03-01', 3);