﻿# AS-POO (Loja de Veículos)

## Descrição do Sistema
As lojas de veículos enfrentam dificuldades no gerenciamento das informações de clientes, vendedores, veículos e vendas, especialmente quando esses dados são controlados manualmente ou por ferramentas não integradas. A ausência de um sistema centralizado compromete a tomada de decisões estratégicas, o controle de estoque e a análise de desempenho de vendas.

Este projeto consiste em uma API RESTful desenvolvida em Java com Spring Boot e MySQL, que centraliza e automatiza esses processos, oferecendo:

- Cadastro completo e integrado de clientes, veículos, vendedores e vendas
- Geração de relatórios gerenciais e estatísticos
- Facilidade de visualização e tomada de decisão através de uma **view unificada de vendas**

## Tecnologias Utilizadas
- Java 21
- Spring Boot 3.5 (Spring Web, Spring Data JPA)
- MySQL 8
- Gradle Kotlin DSL
- Hibernate

## Modelagem de Dados

### Entidades Principais

- **Cliente**
    - `id` (Integer)
    - `nome` (String)
    - `cpf` (String)
    - `telefone` (String)
    - `email` (String)
    - `endereco` (String)

- **Vendedor**
    - `id` (Integer)
    - `nome` (String)
    - `cpf` (String)
    - `telefone` (String)
    - `email` (String)

- **Carro**
    - `id` (Integer)
    - `marca` (String)
    - `modelo` (String)
    - `ano` (Integer)
    - `preco` (Decimal)
    - Outros atributos (cor, placa, etc.)

- **Venda**
    - `id` (Integer)
    - `data` (DateTime)
    - `valorTotal` (Decimal)
    - Relacionamento com `Cliente`, `Vendedor` e `Carro`

### Relacionamentos
- **Cliente** 1 — N **Venda**
- **Vendedor** 1 — N **Venda**
- **Carro** 1 — N **Venda**


## Configuração e Execução

### Pré-requisitos
- JDK 21 instalado
- MySQL 8 em execução
- Git

### Passo a passo
1. Clone o repositório:
   ```bash
   git clone https://github.com/dudamatoss/As-db.git
   cd As-db
    ```

2. Crie o banco de dados no MySQL:
   ```bash
    CREATE DATABASE loja_carros;
    ```
3. Ajuste as credenciais de acesso em src/main/resources/application.properties:
   ```bash
    spring.datasource.url=jdbc:mysql://localhost:3306/loja_carros?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC
    spring.datasource.username=seu_usuario
    spring.datasource.password=sua_senha
    spring.jpa.hibernate.ddl-auto=update
    spring.jpa.show-sql=true

    ```

4. Execute a aplicação:

   ```bash
    ./gradlew bootRun
    ```


## Endpoints Principais (exemplos)

- **GET** `/clientes` — Lista todos os clientes
- **POST** `/clientes` — Cria um novo cliente
- **GET** `/vendedores` — Lista todos os vendedores
- **POST** `/vendedores` — Cria um novo vendedor
- **GET** `/carros` — Lista todos os carros
- **POST** `/carros` — Cria um novo carro
- **GET** `/vendas` — Lista todas as vendas
- **POST** `/vendas` — Cria uma nova venda

_Consulte o código em `controller` para detalhes completos das rotas._  
