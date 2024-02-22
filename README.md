<h1 align="center">
  CRUD MJV
</h1>
API para gerenciar tarefas (CRUD) que faz parte [desse desafio](https://github.com/simplify-liferay/desafio-junior-backend-simplify) para pessoas desenvolvedoras backend júnior, que se candidatam para a Simplify.

## Tecnologias
 
- [Spring Boot](https://spring.io/projects/spring-boot)
- [Spring MVC](https://docs.spring.io/spring-framework/reference/web/webmvc.html)
- [Spring Data JPA](https://spring.io/projects/spring-data-jpa)
- [SpringDoc OpenAPI 3](https://springdoc.org/v2/#spring-webflux-support)
- [PostgreSQL](https://www.postgresql.org/)

## Práticas adotadas

- SOLID, DRY, YAGNI, KISS
- API REST
- Consultas com Spring Data JPA
- Injeção de Dependências
- Tratamento de respostas de erro
- Geração automática do Swagger com a OpenAPI 3

Adicionalmente, foram implementados DTOs para separação de responsabilidades no projeto.

## Como Executar

- Clonar repositório git
- Construir o projeto:
```
$ ./mvnw clean package
```
- Executar a aplicação:
```
$ java -jar target/crudmjv-0.0.1-SNAPSHOT.jar
```

A API poderá ser acessada em [localhost:8080](http://localhost:8080).
O Swagger poderá ser visualizado em [localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

## API Endpoints

Para fazer as requisições HTTP abaixo, foi utilizada a ferramenta [httpie](https://httpie.io):

- Criar Tarefa 
```
$ http POST :8080/cruds name="Tarefa 1" description="Descrição Tarefa 1" done=false priority=1

[
  {
    "description": "Descrição Tarefa 1",
    "id": 1,
    "name": "Tarefa 1",
    "priority": 1,
    "done": false
  }
]
```

- Listar Tarefas
```
$ http GET :8080/cruds

[
  {
    "description": "Descrição Tarefa 1",
    "id": 1,
    "name": "Tarefa 1",
    "priority": 1,
    "done": false
  }
]
```

- Atualizar Tarefa
```
$ http PUT :8080/cruds/1 name="Tarefa 1 Atualizada" description="Descrição Tarefa 1 Atualizada" done=true priority=2

[
  {
    "description": "Descrição Tarefa 1 Atualizada",
    "id": 1,
    "name": "Tarefa 1 Atualizada",
    "priority": 2,
    "done": true
  }
]
```

- Remover Tarefa
```
http DELETE :8080/cruds/1

[ ]
```

