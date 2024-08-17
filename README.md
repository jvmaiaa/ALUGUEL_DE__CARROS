# Sistema de Locação de Veículos [![NPM](https://img.shields.io/npm/l/react)](https://github.com/jvmaiaa/ALUGUEL_DE__CARROS/blob/main/LICENSE)

# Autor: João Víctor Maia
**ME ENCONTRE**   
[![Blog](https://img.shields.io/badge/LinkedIn-0077B5?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/joão-víctor-maia-4b9961265/)


# Sobre o projeto

Este projeto tem como finalidade, realizar toda a gerência de uma locadora de veículos, realizando o cadastro de locadoras, funcionários, veículos, clientes e o próprio pedido da locação.
Este projeto foi desenvolvido utilizando o ecossistema da linguagem **Java** e o seu framework **Spring Boot.**
Tentei deixar o mais organizado possível utilizando uma **modularização padrão para sistemas monolíticos**
e uma organização simples e clara por commit, descrevendo o que estava sendo feito a cada feature nova. No projeto, utilizo tokens **JWT** para realizar a autenticação e autorização de cada usuário cadastrado no Banco.

## Diagrama de classes
### Instruções para acessar

<ol>
  <li>Acesse o <a href="https://drive.google.com/file/d/1PJi2eeTTzuyV2QGSToa2TeomSYJI798l/view?usp=sharing">link</a></li>
  <li>Clique em <strong>abrir com draw.io</strong> - Caso essa opção não apareça, aperte no select ao lado, e selecione a opção <strong>draw.io</strong> </li>
  <li>Navegue pelo Diagrama de classes livremente</li>
</ol>

## Endpoints / Documentação (URIs)
Para vizualizar todas as rotas disponíveis da aplicação com mais detalhes acesse:
- `http://localhost:8080/api/swagger-ui/index.html` -> A aplicação deve estar rodando na sua máquina.
- Documentação feita com `Swagger`.

# Tecnologias e Versões
<table>
  <tr>
    <td>Java</td>
    <td>Spring Boot</td>
    <td>Lombok</td>
    <td>Spring Security</td>
    <td>SpringDoc OpenApi</td>
    <td>Java-jwt</td>
    <td>Java-dotenv</td>
    <td>ModelMapper</td>
  </tr>
  <tr>
    <td>17</td>
    <td>3.2.3</td>
    <td>1.18.30</td>
    <td>3.2.3</td>
    <td>2.6.0</td>
    <td>4.4.0</td>
    <td>5.2.2</td>
    <td>3.2.0</td>
  </tr>
</table>
  
## Banco de Dados
- Postgres

# Como executar o projeto
Pré-requisitos:
- Java 17 instalado
- Postgres instalado
- Algum API Client para testar a aplicação -> recomendo **Postman** pelo seu uso simples, que facilita o envio de requisições HTTP e a visualização das respostas feitas API
- Algum SGBD que tenha suporte à `Bancos Relacionais` devido ao uso do `PostgreSQL` **caso queira manipular os dados** -> recomendo o **Dbeaver** pois oferece suporte a varios Bancos Relacionais diferentes
```bash
# clonar repositório
git clone https://github.com/jvmaiaa/APLICACAO_IBGE.git
# utilize alguma IDE para acessar e executar o projeto clonado. Recomendo utilizar o IntelliJ IDEA
# configure as variaveis de ambiente. Vá até o arquivo .env.properties.example e renomeie para ".env.properties"
.env.properties
# após renomear o arquivo adicione os valores que estão configurados na sua máquina para cada campo das variáveis de ambiente e execute o projeto
execute a aplicação que está dentro de `src/java/com/jvmaiaa/aluguelcarros/CarRentalApplication.java`
```
## Ordem de cadastro de entidades
**OBS**: Coloquei um prefixo no meu arquivo `application.yml` que toda rota do meu projeto, irá conter `/api` no início, **FIQUE ATENTO**. utilizei a configuração:
```
server:
  servlet:
    context-path: /api
```
- Cadastre uma locadora - **POST** -> `localhost:8080/api/locadora`
- Cadastre um funcionário - **POST** -> `localhost:8080/api/funcionario`
- Autentique o funcionário - **POST** -> `localhost:8080/api/auth`
-> JSON que precisa ser passado:
```
{
  "email": "string",
  "password": "string"
}
```
- Pegue o **Token JWT** e passe em cada requisição que queira realizar com a permissão de um funcionário
- Cadastre um Carro **Apenas funcionários Autenticados** - **POST** -> `localhost:8080/api/carro`
- Cadastre um Endereço -  **POST** -> `localhost:8080/api/endereco`
- Cadastre um Cliente -  **POST** -> `localhost:8080/api/cliente`
- Authentique o cliente caso queira realizar ações limitadas como buscar outros clientes e endereços - **POST** -> `localhost:8080/api/auth`
-> O JSON que precisa ser passado é:
```
{
  "email": "string",
  "password": "string"
}
```
- Realize o cadastro de uma locação utilizando o **token JWT** de um `Funcionário` - **POST** -> `localhost:8080/api/locacao`

## Agradecimentos
-> Agradeço por experimentar o projeto. Caso você identifique alguma área para melhorias ou tenha sugestões para aprimorar o projeto, não hesite em compartilhar suas ideias. Estou sempre aberto a aprender e explorar novas tecnologias, e valorizo muito a oportunidade de crescer com a ajuda da comunidade.
