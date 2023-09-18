# <img id="inicio" src="https://scontent.ffor1-2.fna.fbcdn.net/v/t39.30808-6/291155788_749134162931729_5904111411624050166_n.jpg?_nc_cat=103&ccb=1-7&_nc_sid=a2f6c7&_nc_ohc=7R8HtoL_VSwAX82trcQ&_nc_ht=scontent.ffor1-2.fna&oh=00_AfChLnnWTFXtrejMnVw_3E5t9-HObewJ05KaBBj7UININQ&oe=650CFF50" height=30/> Avaliação Back-end para Attornatus

![Badge Status](http://img.shields.io/badge/status-concluído-success?style=for-the-badge)
![Badge Size](https://img.shields.io/github/languages/code-size/lewoaragao/avaliacao.back.end.Attornatus?style=for-the-badge)
![Badge Version](https://img.shields.io/badge/version-1.0-important?style=for-the-badge)


## 🗂 Sumário
- <a href="#visaogeral">Visão geral</a>
  - <a href="#entidadepessoa">Entidade Pessoa</a>
  - <a href="#entidadeendereco">Entidade Endereço</a>
- <a href="#executarprojeto">Executar projeto</a>
- <a href="#executartestes">Executar testes</a>
- <a href="#perguntas">Perguntas</a>
- <a href="#informacoes">Informações</a>
- <a href="#tecnologias">Tecnologias</a>
- <a href="#documentacao">Documentação</a>
  - <a href="#fluxopessoa">Fluxo Pessoa</a>
  - <a href="#fluxoendereco">Fluxo Endereço</a>
- <a href="#proximaatualizacao">Próxima atualização</a>
- <a href="#contato">Contato</a>

## 📑 <span id="visaogeral">Visão geral</span>
<a href="#inicio">⬆️ Voltar para o topo</a>

Usando Spring Boot, foi criada uma API para gerenciar Pessoas. Esta API permite:  
- Criar uma pessoa
- Editar uma pessoa
- Consultar uma pessoa
- Listar pessoas
- Criar endereço para pessoa
- Listar endereços da pessoa
- Informar qual endereço é o principal da pessoa  

### <span id="entidadepessoa">Entidade Pessoa</span> (tabela = t_pessoa)
Tipo | Nome
:--- | :---
`Long` | ID
`String` | Nome
`LocalDate` | Data de nascimento
`List<Endereco>` | Enderecos

### <span id="entidadeendereco">Entidade Endereço</span> (tabela = t_endereco)
Tipo | Nome
:--- | :---
`Long` | ID
`String` | Logradouro
`String` | CEP
`Integer` | Numero
`String` | Cidade

## 👩‍💻 <span id="executarprojeto">Executar Projeto</span>
<a href="#inicio">⬆️ Voltar para o topo</a>

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

## 🧩 <span id="executartestes">Executar testes</span>
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
   3. <span id="passoIii">Procurar</span> a classe `PessoaServiceTest.java` ou a `EnderecoServiceTeste.java` que fica na pasta `src/test/java`
   4. Iniciar executando ou em modo debug
  
## 💬 <span id="perguntas">Perguntas</span>
<a href="#inicio">⬆️ Voltar para o topo</a>

1. Durante a implementação de uma nova funcionalidade de software solicitada, quais critérios você avalia e implementa para garantia de qualidade de software?

> Se está cumprindo as medidas de segurança de acordo com as regras de negócio, se atendeu as necessidades propostas da nova funcionalidade criando testes automatizados, reviso o código para conferir se não existe algum método ou comentários que não são para subir na versão de produção, crio uma documentação clara e abrangente para ajudar a garantir que outros desenvolvedores possam entender e mander o código no futuro, após ir para produção monitorar o desempenho da nova funcionalidade em diferentes situações para poder ajudar a identificar possíveis problemas de desempenho e garantir que esteja funcionando de maneira eficiente.

2. Em qual etapa da implementação você considera a qualidade de software?

> Desde o planejamento até a implantação, conferindo principalmente na hora do desenvolvimento se foi capturado algum erro que não havia sido pensado gerando uma exceção, para que o mesmo possa ser logo tratado.

## ℹ <span id="informacoes">Informações</span>
<a href="#inicio">⬆️ Voltar para o topo</a>

- Clean Code
- Teste unitários
- Banco de dados H2
- Todas as respostas da API em JSON  
- Paginação nas respostas que listam todos os dados
- Boas práticas na programação, estrutura, arquitetura e organização do projeto

## ⚙ <span id="tecnologias">Tecnologias</span>
<a href="#inicio">⬆️ Voltar para o topo</a>

Desenvolvimento | Versionamento | Teste 
:-------------: | :-----------: | :----
![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white) | ![Git](https://img.shields.io/badge/git-%23F05033.svg?style=for-the-badge&logo=git&logoColor=white) | ![Postman](https://img.shields.io/badge/Postman-FF6C37?style=for-the-badge&logo=postman&logoColor=white)
![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white) | ![GitHub](https://img.shields.io/badge/github-%23121011.svg?style=for-the-badge&logo=github&logoColor=white) | ![JUnit](https://img.shields.io/badge/junit-%F41F1F.svg?style=for-the-badge&logo=junit&logoColor=white)
![Apache Maven](https://img.shields.io/badge/Apache%20Maven-C71A36?style=for-the-badge&logo=Apache%20Maven&logoColor=white) 

## 📚 <span id="documentacao">Documentação</span> 
<a href="#inicio">⬆️ Voltar para o topo</a>

- `URL_BASE` = /api/pessoas

### <span id="fluxopessoa">Fluxo Pessoa</span>

Exemplo Pessoa:
```json
{
    "nome" : "João",
    "dataNascimento" : "2000-01-01"
}
```

Endpoint | Method | PathVariable | RequestBody | Response
:------- | :----: | :----------- | :---------- | :-------
`URL_BASE` | <img src="https://img.shields.io/badge/-Post-yellow?style=for-the-badge"> | Vazio | Pessoa | Criar pessoa
`URL_BASE` | <img src="https://img.shields.io/badge/-Put-blue?style=for-the-badge"> | ID Pessoa | Pessoa | Atualizar pessoa
`URL_BASE` | <img src="https://img.shields.io/badge/-Get-green?style=for-the-badge"> | ID Pessoa | Vazio | Consultar pessoa
`URL_BASE` | <img src="https://img.shields.io/badge/-Get-green?style=for-the-badge"> | Vazio | Vazio | Listar pessoas

### <span id="fluxoendereco">Fluxo Endereço</span>
Exemplo Endereço:
```json
{
    "logradouro" : "Rua logradouro",
    "cep" : "60000-000",
    "numero" : 60,
    "cidade" : "Fortaleza"
}
```

Endpoint | Method | PathVariable | RequestBody | Response
:------- | :----: | :----------- | :---------- | :-------
`URL_BASE/{pessoaId}/enderecos` | <img src="https://img.shields.io/badge/-Post-yellow?style=for-the-badge"> | ID Pessoa | Endereco | Criar endereço
`URL_BASE/{pessoaId}/enderecos/{enderecoId}/principal` | <img src="https://img.shields.io/badge/-Put-blue?style=for-the-badge"> | ID Pessoa, ID Endereco | Vazio | Definir endereço principal
`URL_BASE/{pessoaId}/enderecos` | <img src="https://img.shields.io/badge/-Get-green?style=for-the-badge"> | ID Pessoa | Vazio | Listar endereços da pessoa
`URL_BASE/{pessoaId}/enderecos/principal` | <img src="https://img.shields.io/badge/-Get-green?style=for-the-badge"> | ID Pessoa | Vazio | Consultar endereço principal da pessoa


## 🆕 <span id="proximaatualizacao">Próxima atualização</span>
<a href="#inicio">⬆️ Voltar para o topo</a>

- [ ] Implementar documentação via Swagger

## 📞 <span id="contato">Contato</span>
<a href="#inicio">⬆️ Voltar para o topo</a>

<a href="https://api.whatsapp.com/send/?phone=5585997972854&text=Ol%C3%A1">![Badge Whatsapp](https://img.shields.io/badge/WhatsApp-25D366?style=for-the-badge&logo=whatsapp&logoColor=white)</a>
<a href="mailto:lewoaragao@gmail.com">![Badge Gmail](https://img.shields.io/badge/Gmail-D14836?style=for-the-badge&logo=gmail&logoColor=white)</a>
<a href="https://linkedin.com/in/lewoaragao">![Badge Linkedin](https://img.shields.io/badge/LinkedIn-0077B5?style=for-the-badge&logo=linkedin&logoColor=white)</a>
<a href="https://t.me/leonardoaragao">![Badge Telegram](https://img.shields.io/badge/Telegram-2CA5E0?style=for-the-badge&logo=telegram&logoColor=white)</a>
<a href="https://instagram.com/lewoaragao">![Badge Instagram](https://img.shields.io/badge/Instagram-E4405F?style=for-the-badge&logo=instagram&logoColor=white)</a>
