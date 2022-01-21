# Projeto de crud

Essa é uma api reativa utilizando springboot-webflux.


Arquitetura do projeto

![Alt text](clean/download.jfif?raw=true "Clean Architecture")



##Tecnologias Utilizadas


* Maven
* Web-flux
* Mongo-Reactive
* ModelMapper
* Swagger

## Todo
- [ ] Melhorar documentação
- [ ] Implementação dos testes unitários
- [x] Swagger
- [x] Endpoints

# Swagger
Para compilar o projeto
1. Esse serviço dispõe de um swagger-ui.html
```
http:\\localhost:8080\swagger-ui.html
```


# Como iniciar
Para compilar o projeto
1. Utilize o comando abaixo
```
mvn clean package 
```


2. Para rodar o docker:
```
docker-compose up --build --force-recreate
```

