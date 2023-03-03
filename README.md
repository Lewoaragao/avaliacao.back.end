# <img src="https://scontent.ffor1-2.fna.fbcdn.net/v/t39.30808-1/291155788_749134162931729_5904111411624050166_n.jpg?stp=cp0_dst-jpg_e15_p120x120_q65&_nc_cat=103&ccb=1-7&_nc_sid=dbb9e7&_nc_ohc=PL112LV44swAX84nPDX&_nc_ht=scontent.ffor1-2.fna&oh=00_AfAq8QYCsqG06awIpXJrQtvXU9RXr5_L_LpMg6u7kAT5zA&oe=64070FCA" height=30/> Avaliação Back-end para Attornatus

![Badge em Desenvolvimento](http://img.shields.io/static/v1?label=status&message=em%20desenvolvimento&color=yellow&style=for-the-badge)

## 🗂 Sumário
- <a href="#visaoGeral">Visão geral</a>
  - <a href="#entidadePessoa">Entidade Pessoa</a>
  - <a href="#entidadeEndereco">Entidade Endereço</a>
- <a href="#executarProjeto">Executar projeto</a>
- <a href="#perguntas">Perguntas</a>
- <a href="#informacoes">Informações</a>
- <a href="#tecnologias">Tecnologias</a>
- <a href="#documentacao">Documentação</a>
  - <a href="#fluxoPessoa">Fluxo Pessoa</a>
  - <a href="#fluxoEndereco">Fluxo Endereço</a>

## 📑 <span id="visaoGeral">Visão geral</span>
Usando Spring Boot, foi criada uma API para gerenciar Pessoas. Esta API permiti:  
- Criar uma pessoa
- Editar uma pessoa
- Consultar uma pessoa
- Listar pessoas
- Criar endereço para pessoa
- Listar endereços da pessoa
- Informar qual endereço é o principal da pessoa  

### <span id="entidadePessoa">Entidade Pessoa</span> (tabela = t_pessoa)
Tipo | Nome
:--- | :---
`Long` | ID
`String` | Nome
`LocalDate` | Data de nascimento
`List<Endereco>` | Enderecos

### <span id="entidadeEndereco">Entidade Endereço</span> (tabela = t_endereco)
Tipo | Nome
:--- | :---
`Long` | ID
`String` | Logradouro
`String` | CEP
`Integer` | Numero
`String` | Cidade

## 👩‍💻 <span id="executarProjeto">Executar projeto</span>
1. Abrir Git Bash
2. Digitar `git clone https://github.com/Lewoaragao/avaliacao.back.end.git`
   1. Caso tenha use a IDE VSCode
      1. Digitar `cd avaliacao.back.end`
      2. Digitar `code .`
      3. Pular para o passo <a href="#passoIii">iii</a>
   2. Caso tenha outra IDE (Exemplo: _Eclipe_)
      1. Clicar em `File`
      2. Clicar em `Import`
      3. Clicar na pasta `Maven`
      4. Clicar em `Existing Maven Projects`
      5. Clicar em `Browse`
      6. Procurar o diretório do projeto onde foi clonado
      7. Em `Project` selecionar o `pom.xml`
      8. Clicar em `Finish`
   3. <span id="passoIii">Procurar</span> a classe `Application.java` que fica na pasta `src/main/java`
   4. Iniciar executando ou em modo debug
  
## 💬 <span id="perguntas">Perguntas</span>
1. Durante a implementação de uma nova funcionalidade de software solicitada, quais critérios você avalia e implementa para garantia de qualidade de software?

> Resposta.

2. Em qual etapa da implementação você considera a qualidade de software?

> Resposta.

## ℹ <span id="informacoes">Informações</span>
- Clean Code
- Teste unitários
- Banco de dados H2
- Todas as respostas da API em JSON  
- Paginação nas respostas que listam todos os dados
- Boas práticas na programação, estrutura, arquitetura e organização do projeto

## ⚙ <span id="tecnologias">Tecnologias</span>
Desenvolvimento | Versionamento | Teste 
:-------------: | :-----------: | :----
![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=java&logoColor=white) | ![Git](https://img.shields.io/badge/git-%23F05033.svg?style=for-the-badge&logo=git&logoColor=white) | ![Postman](https://img.shields.io/badge/Postman-FF6C37?style=for-the-badge&logo=postman&logoColor=white)
![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white) | ![GitHub](https://img.shields.io/badge/github-%23121011.svg?style=for-the-badge&logo=github&logoColor=white) | ![JUnit](https://img.shields.io/badge/junit-%F41F1F.svg?style=for-the-badge&logo=junit&logoColor=white)
![Apache Maven](https://img.shields.io/badge/Apache%20Maven-C71A36?style=for-the-badge&logo=Apache%20Maven&logoColor=white) 

## 📚 <span id="documentacao">Documentação</span>
- `URL_BASE_PESSOA` = /api/pessoas

### <span id="fluxoPessoa">Fluxo Pessoa</span>
Endpoint | Method | PathVariable | RequestBody | Response
:------- | :----: | :----------- | :---------- | :-------
`URL_BASE_PESSOA` | <img src="https://img.shields.io/badge/-Post-yellow?style=for-the-badge"> | Vazio | Pessoa | Criar pessoa
`URL_BASE_PESSOA` | <img src="https://img.shields.io/badge/-Put-blue?style=for-the-badge"> | ID Pessoa | Pessoa | Atualizar pessoa
`URL_BASE_PESSOA` | <img src="https://img.shields.io/badge/-Get-green?style=for-the-badge"> | ID Pessoa | Vazio | Consultar pessoa
`URL_BASE_PESSOA` | <img src="https://img.shields.io/badge/-Get-green?style=for-the-badge"> | Vazio | Vazio | Listar pessoas

### <span id="fluxoEndereco">Fluxo Endereço</span>
Endpoint | Method | PathVariable | RequestBody | Response
:------- | :----: | :----------- | :---------- | :-------
`URL_BASE_PESSOA/{pessoaId}/enderecos` | <img src="https://img.shields.io/badge/-Post-yellow?style=for-the-badge"> | ID Pessoa | Endereco | Criar endereço
`URL_BASE_PESSOA/{pessoaId}/enderecos` | <img src="https://img.shields.io/badge/-Put-blue?style=for-the-badge"> | ID Pessoa, ID Endereco | Vazio | Definir endereço principal
`URL_BASE_PESSOA/{pessoaId}/enderecos` | <img src="https://img.shields.io/badge/-Get-green?style=for-the-badge"> | ID Pessoa | Vazio | Listar endereços da pessoa
