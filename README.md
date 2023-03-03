# Avaliação Back-end para Attornatus.
## Visão geral
Usando Spring Boot, foi criada uma API para gerenciar Pessoas. Esta API permiti:  
- Criar uma pessoa
- Editar uma pessoa
- Consultar uma pessoa
- Listar pessoas
- Criar endereço para pessoa
- Listar endereços da pessoa
- Informar qual endereço é o principal da pessoa  

### Entidade Pessoa (tabela = t_pessoa)
Tipo | Nome
:--- | :---
`Long` | ID
`String` | Nome
`LocalDate` | Data de nascimento
`List<Endereco>` | Enderecos

### Entidade Endereço (tabela = t_endereco)
Tipo | Nome
:--- | :---
`Long` | ID
`String` | Logradouro
`String` | CEP
`Integer` | Numero
`String` | Cidade
  
## Perguntas
1. Durante a implementação de uma nova funcionalidade de software solicitada, quais critérios você avalia e implementa para garantia de qualidade de software?

> Resposta.

2. Em qual etapa da implementação você considera a qualidade de software?

> Resposta.

## Informações
- Clean Code
- Teste unitários
- Banco de dados H2
- Todas as respostas da API em JSON  
- Paginação nas respostas que listam todos os dados
- Boas práticas na programação, estrutura, arquitetura e organização do projeto

## Tecnologias
Desenvolvimento | Versionamento | Teste 
:-------------: | :-----------: | :----
![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=java&logoColor=white) | ![Git](https://img.shields.io/badge/git-%23F05033.svg?style=for-the-badge&logo=git&logoColor=white) | ![Postman](https://img.shields.io/badge/Postman-FF6C37?style=for-the-badge&logo=postman&logoColor=white)
![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white) | ![GitHub](https://img.shields.io/badge/github-%23121011.svg?style=for-the-badge&logo=github&logoColor=white)
![Apache Maven](https://img.shields.io/badge/Apache%20Maven-C71A36?style=for-the-badge&logo=Apache%20Maven&logoColor=white) 

## Documentação
- `URL_BASE_PESSOA` = /api/pessoas

### Fluxo Pessoa
Endpoint | Method | PathVariable | RequestBody | Response
:------- | :----: | :----------- | :---------- | :-------
`URL_BASE_PESSOA` | <img src="https://img.shields.io/badge/-Post-yellow?style=for-the-badge"> | Vazio | Pessoa | Criar pessoa
`URL_BASE_PESSOA` | <img src="https://img.shields.io/badge/-Put-blue?style=for-the-badge"> | ID Pessoa | Pessoa | Atualizar pessoa
`URL_BASE_PESSOA` | <img src="https://img.shields.io/badge/-Get-green?style=for-the-badge"> | ID Pessoa | Vazio | Consultar pessoa
`URL_BASE_PESSOA` | <img src="https://img.shields.io/badge/-Get-green?style=for-the-badge"> | Vazio | Vazio | Listar pessoas

### Fluxo Endereço
Endpoint | Method | PathVariable | RequestBody | Response
:------- | :----: | :----------- | :---------- | :-------
`URL_BASE_PESSOA/{pessoaId}/enderecos` | <img src="https://img.shields.io/badge/-Post-yellow?style=for-the-badge"> | ID Pessoa | Endereco | Criar endereço
`URL_BASE_PESSOA/{pessoaId}/enderecos` | <img src="https://img.shields.io/badge/-Put-blue?style=for-the-badge"> | ID Pessoa, ID Endereco | Vazio | Definir endereço principal
`URL_BASE_PESSOA/{pessoaId}/enderecos` | <img src="https://img.shields.io/badge/-Get-green?style=for-the-badge"> | ID Pessoa | Vazio | Listar endereços da pessoa
