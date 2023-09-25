CREATE DATABASE labcar;

CREATE TABLE usuario (
    id    bigserial PRIMARY KEY,
    nome  varchar(255) NOT NULL,
    email varchar(255) NOT NULL,
    senha varchar(255) NOT NULL
);

CREATE TABLE carro (
    id     bigserial PRIMARY KEY,
    marca  varchar(100) NOT NULL,
    modelo varchar(100) NOT NULL,
    ano    int          NOT NULL,
    preco  numeric(19, 2),
    foto   text
);

/*

{
  "usuarios": [
    {
      "id": 1
      "nome": "Usuário Teste",
      "email": "teste@teste.com",
      "senha": "abcd1234",
    }
  ],
  "carros": [
    {
      "id": 1,
      "modelo": "Fusca",
      "marca": "Volkswagen",
      "ano": 1968,
      "preco": 10000,
      "foto": "https://images.unsplash.com/photo-1662584117293-4d937511febc?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=1169&q=80"
    },
    {
      "id": 2,
      "modelo": "Mustang",
      "marca": "Ford",
      "ano": 1969,
      "preco": 65000,
      "foto": "https://images.unsplash.com/photo-1517703499713-8aa43b3e4800?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=1171&q=80"
    }
  ]
}

*/
