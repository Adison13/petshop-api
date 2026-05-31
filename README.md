# Petshop API

API REST desenvolvida com Java + Spring Boot para gerenciamento de um e-commerce de produtos para pets.

## Tecnologias utilizadas

- Java 24
- Spring Boot 3.5
- Spring Data JPA
- PostgreSQL
- Swagger / OpenAPI 3
- Maven

## Como executar o projeto

### Pre-requisitos
- Java 17 ou superior instalado
- PostgreSQL instalado e rodando
- Maven instalado

### Passos

1. Clone o repositorio:
```bash
   git clone https://github.com/Adison13/petshop-api.git
   cd petshop-api
```

2. Crie o banco de dados no PostgreSQL:
```sql
   CREATE DATABASE petshopdb;
```

3. Configure o arquivo `src/main/resources/application.properties`:
```properties
   spring.datasource.url=jdbc:postgresql://localhost:5433/petshopdb
spring.datasource.username=postgres
spring.datasource.password=sua_senha
```

4. Execute o projeto:
```bash
   ./mvnw spring-boot:run
```

5. Acesse o Swagger:

http://localhost:8080/swagger-ui/index.html

## Endpoints disponiveis

| Recurso      | GET (listar)  | GET (por id)       | POST         | PUT               | DELETE            |
|--------------|---------------|--------------------|--------------|-------------------|-------------------|
| Clientes     | /clientes     | /clientes/{id}     | /clientes    | /clientes/{id}    | /clientes/{id}    |
| Pets         | /pets         | /pets/{id}         | /pets        | /pets/{id}        | /pets/{id}        |
| Categorias   | /categorias   | /categorias/{id}   | /categorias  | /categorias/{id}  | /categorias/{id}  |
| Produtos     | /produtos     | /produtos/{id}     | /produtos    | /produtos/{id}    | /produtos/{id}    |
| Pedidos      | /pedidos      | /pedidos/{id}      | /pedidos     | /pedidos/{id}     | /pedidos/{id}     |
| Atendimentos | /atendimentos | /atendimentos/{id} | /atendimentos| /atendimentos/{id}| /atendimentos/{id}|

## Modelo de dados

- Cliente possui varios Pets e varios Pedidos
- Pet pertence a um Cliente e possui varios Atendimentos
- Categoria possui varios Produtos
- Produto pertence a uma Categoria
- Pedido pertence a um Cliente e possui varios ItemPedido
- ItemPedido referencia um Produto e um Pedido

## Funcionalidades

- CRUD completo para todas as entidades
- Relacionamentos JPA entre entidades
- Validacao de dados de entrada
- Tratamento global de excecoes
- Documentacao automatica via Swagger
- Persistencia em banco PostgreSQL