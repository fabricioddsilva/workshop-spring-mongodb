# Workshop Spring MongoDB
[![NPM](https://img.shields.io/npm/l/react)](https://github.com/fabricioddsilva/workshop-spring-mongodb/blob/main/LICENSE)

# Sobre o Projeto
Essa é uma aplicação acadêmica construida durante o meu percurso durante o curso: Java COMPLETO Programação Orientada a Objetos + Projetos, na [Udemy](https://www.udemy.com/ "Site da Udemy")  

A aplicação consiste em uma API para registro e manipução de usuários, mostragem de postagens e comentários.

## Tecnologias Utilizadas
- Java
- Spring Boot
- Maven
- MongoDB

## Como executar o projeto
Pré-requisitos: Java 17

```bash
# clonar repositório
git clone = https://github.com/fabricioddsilva/workshop-spring-mongodb

# executar o projeto
./mvnw spring-boot:run
```

## Endpoints

  OBS.: os endpoints que tiverem {} representam que se deve passar o parametro pedido naquele local, não que deve ser construido desse jeito.  
  
  EX: O Endpoint _/users/{id}_ seria escrito assim: _/users/1_ assim trazendo o usuário com Id igual a 1.  
  
  Nesse projeto em especifico foi usado o banco MongoDB, e o ID usado nesse banco seria uma String não um Long como normalmente é usado. 
  
#### Usuarios
- @GET _/users_ : Mostra a lista de todos os usuários.
- @GET _/users/{id}_ : Mostra o usuário de acordo com o Id passado.
- @GET _/users/{id}/posts_ : Mostras as postagens do usuários de acordo com o Id passado.
- @POST _/users_ : Insere um usuário no banco de dados.
- @PUT _/users/{id}_ : Edita o usuário de acordo com o Id passado.
- @DELETE _/users/{id}_ : Deleta o usuário de acordo com o Id passado.

#### Postagens
- @GET _/posts/{id}_ : Mostra a postagem de acordo com Id passado.
- @GET _/posts/titlesearch_ : Mostra as postagens a partir do título comparando com o texto passado. EX: _/posts/titlesearch?text=bom%20dia_
- @GET _/posts/fullsearch_ : Mostra as postagens a partir do título, corpo ou comentários comparando com o texto passado, e também por data minima e/ou data máxima. EX: _/posts/fullsearch?text=aproveite&minDate=2018-03-22&maxDate=2018-03-30_
  
---
Para ver o que eu aprendi durante esse curso, meu repositório https://github.com/fabricioddsilva/curso-java contem todos
os exercícios que eu fiz durante o curso.

# Autor

Fabrício Dias da Silva.  

https://www.linkedin.com/in/fabr%C3%ADcio-dias-860252247/
