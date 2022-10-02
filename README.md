# Intenção de voto Api

Repositório para o código fonte da api.
Usado banco de dados PostgreSQL.

## Grupo
Ana Flávia Alves Ferreira - RA: 832473 \
Ivan Carvalho - RA: 767331 \
Lorene Zorzetto Carniel - RA: 832401 \

## Usando com Maven (OpenJDK 19)

Instale o OpenJDK 19 https://openjdk.org/install/

Inicie a aplicação com Maven

```bash
./mvnw spring-boot:run
```

## Usando com Docker

Verifique se o docker está instalado e rodando no seu computador

```bash
docker --version
```

Crie a imagem do docker com Maven

```bash
./mvnw spring-boot:build-image
```

E inicie o container do Docker

```bash
docker compose up
```
