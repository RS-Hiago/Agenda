# Sistema de Agenda de Contatos

Este projeto consiste em um sistema de agenda de contatos desenvolvido utilizando o framework NetBeans para a parte de frontend e o Xampp para armazenamento do banco de dados.

## Objetivo

O objetivo deste projeto é permitir a realização das operações CRUD (Create, Read, Update, Delete) em uma base de dados contendo informações de contatos pessoais.

## Estrutura do Banco de Dados

O banco de dados utilizado neste projeto consiste em duas tabelas:

1. **Tabela de Usuários (login e senha):**
   - Campos: id, email, senha

2. **Tabela de Contatos:**
   - Campos: id, nome, ddd, celular, email, mês de nascimento, cpf, endereço, cidade, estado

## Funcionalidades

### Formulário de Login
- Permite que o usuário acesse o sistema através de um login e senha.
- Valida os dados inseridos pelo usuário.
- Possui opções de limpar campos e realizar login.

### Cadastro de Contatos
- Permite inserir, excluir, editar e visualizar informações dos contatos.
- Todos os formulários são centralizados na tela.
- Títulos são atribuídos a cada formulário para facilitar a identificação.

## Como Executar

Para executar o projeto:

1. Instale e configure o Xampp com MySQL.
2. Inicie os serviços do Apache e MySQL no Xampp.
3. No phpMyAdmin, crie um novo banco de dados.
4. Execute o script SQL fornecido para criar as tabelas necessárias.
5. Importe o projeto no NetBeans.
6. Configure a conexão com o banco de dados no NetBeans.
7. Compile e execute o projeto.

Certifique-se de seguir todas as etapas para garantir o funcionamento correto do sistema.

## Autor

[RS-Hiago](https://github.com/RS-Hiago)

