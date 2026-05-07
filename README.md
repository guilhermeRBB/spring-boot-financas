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
- CRUD completo de usuários
- CRUD completo de lançamentos financeiros
- Vinculação de lançamentos a usuários
- Filtros dinâmicos por mês, tipo e categoria
- Listagem de lançamentos por usuário
- Resumo financeiro com total de receitas, despesas e saldo
- Respostas seguras com DTO (sem exposição de senha)
- Deleção em cascata — ao deletar usuário, seus lançamentos são removidos automaticamente

## ⚙️ Como rodar localmente

1. Clone o repositório
2. Crie um banco de dados MySQL chamado `financas`
3. Copie o arquivo de configuração: cp src/main/resources/application.properties.example src/main/resources/application.properties
4. Preencha suas credenciais no `application.properties`
5. Rode o projeto: ./mvnw spring-boot:run

## 📌 Endpoints

### Usuários
| Método | Rota | Descrição |
|---|---|---|
| GET | /usuarios | Listar todos os usuários |
| GET | /usuarios/{id} | Buscar usuário por id |
| POST | /usuarios | Cadastrar usuário |
| PUT | /usuarios/{id} | Atualizar usuário |
| DELETE | /usuarios/{id} | Deletar usuário e seus lançamentos |

### Lançamentos
| Método | Rota | Descrição |
|---|---|---|
| GET | /lancamentos | Listar todos |
| GET | /lancamentos/{id} | Buscar por id |
| GET | /lancamentos/usuario/{usuarioId} | Listar por usuário |
| GET | /lancamentos/resumo/{usuarioId} | Resumo financeiro do usuário |
| GET | /lancamentos/filtrar | Filtrar lançamentos |
| POST | /lancamentos | Criar lançamento |
| PUT | /lancamentos/{id} | Atualizar lançamento |
| DELETE | /lancamentos/{id} | Deletar lançamento |

### Parâmetros do filtro
| Parâmetro | Obrigatório | Exemplo |
|---|---|---|
| usuarioId | ✅ | 1 |
| mes | ❌ | 5 |
| tipo | ❌ | RECEITA ou DESPESA |
| categoria | ❌ | Trabalho |

## 📊 Exemplo de resposta do resumo financeiro

```json
{
    "totalReceitas": 3500.00,
    "totalDespesas": 1270.00,
    "saldo": 2230.00
}
```   
