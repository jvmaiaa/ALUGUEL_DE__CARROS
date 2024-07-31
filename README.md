# Sistema de Locação de Veiculos [![NPM](https://img.shields.io/npm/l/react)](https://github.com/jvmaiaa/ALUGUEL_DE__CARROS/blob/main/LICENSE)

# Autor: João Víctor Maia
**ME ENCONTRE**   
[![Blog](https://img.shields.io/badge/LinkedIn-0077B5?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/joão-víctor-maia-4b9961265/)


# Sobre o projeto

Este projeto tem como finalidade, realizar toda a gerência de uma locadora de veículos, realizando o cadastro de locadoras, funcionários, veículos, clientes e a próprio pedido da locação.
Ele foi feito utilizando o ecossistema da linguagem **Java** e o seu framework **Spring Boot.**
Tentei deixar o mais organizado possível utilizando uma **modularização padrão para sistemas monolítos**
e uma organização simples e clara por commit, descrevendo o que estava sendo feito a cada feature nova. No projeto, utilizo tokens **JWT** para realizar a autenticação e autorização de cada usuário cadastrado no Banco.

## Diagrama de classes
Link do [diagrama](https://drive.google.com/file/d/1PJi2eeTTzuyV2QGSToa2TeomSYJI798l/view?usp=sharing)

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
- Alguma API Client para testar a aplicação -> recomendo **Postman**
- Algum SGBD caso queira manipular dados que irão ser salvos no banco
```bash
# clonar repositório
git clone https://github.com/jvmaiaa/APLICACAO_IBGE.git
# utilize alguma IDE para acessar o e executar o projeto clonado. Recomendo utilizar o IntelliJ IDEA
# configure as variaveis de ambiente. Vá até o arquivo .env.properties.example e renomeie para ".env.properties"
.env.properties
# após renomear o arquivo adicione os valores que estão configurados na sua máquina para cada campo das variáveis de ambiente e execute o projeto
execute a aplicação que está dentro de src/java/com/jvmaiaa/aluguelcarros/CarRentalApplication.java
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
-> JSON que precisa ser passado:
```
{
  "email": "string",
  "password": "string"
}
```
- Realize o cadastro de uma locação utilizando o **token JWT** de um `Funcionário` - **POST** -> `localhost:8080/api/locacao`

## Agradecimentos
-> Agradeço por experimentarem o projeto. Caso você identificar alguma área para melhorias ou tiver sugestões para aprimorar o projeto, não hesite em compartilhar suas ideias. Estou sempre aberto a aprender e explorar novas tecnologias, e valorizo muito a oportunidade de crescer com a ajuda da comunidade.
