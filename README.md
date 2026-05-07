# 💰 Spring Boot Finanças

API REST para gerenciamento de finanças pessoais, desenvolvida com Spring Boot e MySQL.

## 🚀 Tecnologias
- Java 17
- Spring Boot 3.5
- Spring Data JPA
- MySQL
- Lombok
- Maven

## ✅ Funcionalidades
- Cadastro de usuários
- CRUD completo de lançamentos financeiros
- Vinculação de lançamentos a usuários
- Filtros dinâmicos por mês, tipo e categoria
- Listagem de lançamentos por usuário
- Resumo financeiro com total de receitas, despesas e saldo
- Respostas seguras com DTO (sem exposição de senha)

## ⚙️ Como rodar localmente

1. Clone o repositório
2. Crie um banco de dados MySQL chamado `financas`
3. Copie o arquivo de configuração:
   cp src/main/resources/application.properties.example src/main/resources/application.properties
4. Preencha suas credenciais no `application.properties`
5. Rode o projeto:
