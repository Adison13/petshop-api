-- Script de criação do banco de dados
-- Petshop API

CREATE DATABASE petshopdb;

\c petshopdb;

-- Tabela de clientes
CREATE TABLE clientes (
    id BIGSERIAL PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    telefone VARCHAR(20),
    email VARCHAR(255)
);

-- Tabela de pets
CREATE TABLE pets (
    id BIGSERIAL PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    especie VARCHAR(100),
    raca VARCHAR(100),
    idade INTEGER,
    cliente_id BIGINT REFERENCES clientes(id)
);

-- Tabela de atendimentos
CREATE TABLE atendimentos (
    id BIGSERIAL PRIMARY KEY,
    servico VARCHAR(255),
    data DATE,
    pet_id BIGINT REFERENCES pets(id)
);

-- Tabela de categorias
CREATE TABLE categorias (
    id BIGSERIAL PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    descricao TEXT
);

-- Tabela de produtos
CREATE TABLE produtos (
    id BIGSERIAL PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    descricao TEXT,
    preco NUMERIC(10,2) NOT NULL,
    estoque INTEGER NOT NULL,
    categoria_id BIGINT REFERENCES categorias(id)
);

-- Tabela de pedidos
CREATE TABLE pedidos (
    id BIGSERIAL PRIMARY KEY,
    data DATE,
    status VARCHAR(50),
    total NUMERIC(10,2),
    cliente_id BIGINT REFERENCES clientes(id)
);

-- Tabela de itens do pedido
CREATE TABLE itens_pedido (
    id BIGSERIAL PRIMARY KEY,
    quantidade INTEGER NOT NULL,
    preco_unitario NUMERIC(10,2),
    pedido_id BIGINT REFERENCES pedidos(id),
    produto_id BIGINT REFERENCES produtos(id)
);

-- Dados de exemplo
INSERT INTO clientes (nome, telefone, email) VALUES
('João Silva', '21999999999', 'joao@email.com'),
('Maria Santos', '21988888888', 'maria@email.com');

INSERT INTO categorias (nome, descricao) VALUES
('Alimentação', 'Rações e petiscos para pets'),
('Higiene', 'Produtos de banho e tosa'),
('Brinquedos', 'Brinquedos e acessórios');

INSERT INTO produtos (nome, descricao, preco, estoque, categoria_id) VALUES
('Ração Premium Cão Adulto 15kg', 'Ração completa para cães adultos', 189.90, 50, 1),
('Shampoo Neutro para Cães', 'Shampoo suave para banho', 29.90, 100, 2),
('Bola de Borracha', 'Bola resistente para cães', 19.90, 200, 3);