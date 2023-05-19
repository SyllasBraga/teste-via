drop database if exists teste_via;
create database teste_via;
use teste_via;

create table produtos(
id_produto int primary key auto_increment not null ,
nome_produto varchar(255) not null,
descricao varchar(255) not null,
status_venda varchar(255) not null
);

INSERT INTO produtos (nome_produto, descricao, status_venda) VALUES 
    ('Macarrão', 'Pacote de 1KG', 'VENDIDO'),
    ('Refrigerante de Limão', 'Garrafa de 2L', 'NAO_VENDIDO'),
    ('Mussarela', 'Bandeja de 500g', 'VENDIDO'),
    ('Feijão', 'Pacote de 1KG', 'VENDIDO'),
    ('Biscoito', 'Pacote de 200g', 'NAO_VENDIDO'),
    ('Leite', 'Caixa de 1L', 'VENDIDO'),
    ('Café', 'Pacote de 250g', 'NAO_VENDIDO'),
    ('Chocolate', 'Barra de 100g', 'VENDIDO'),
    ('Banana', 'Dúzia', 'NAO_VENDIDO'),
    ('Tomate', 'Quilo', 'VENDIDO'),
    ('Sabonete', 'Unidade', 'NAO_VENDIDO'),
    ('Desinfetante', 'Frasco de 500ml', 'VENDIDO'),
    ('Creme dental', 'Tubo de 90g', 'NAO_VENDIDO');