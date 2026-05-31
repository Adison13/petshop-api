# 🐾 Petshop API

API REST desenvolvida com Java + Spring Boot para gerenciamento de um e-commerce de produtos para pets.

## 🛠️ Tecnologias utilizadas

- Java 24
- Spring Boot 3.5
- Spring Data JPA
- PostgreSQL
- Swagger / OpenAPI 3
- Maven

## ▶ Como executar o projeto

### Pré-requisitos
- Java 17 ou superior instalado
- PostgreSQL instalado e rodando
- Maven instalado

### Passos

1. Clone o repositório:
```bash
   git clone https://github.com/seu-usuario/petshop-api.git
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