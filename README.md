
# Tech Challenge: Sistema de Agendamento e Gerenciamento de Serviços de Beleza e Bem-Estar

O Tech Challenge é o projeto de fase que englobará os conhecimentos obtidos em todas as disciplinas. É importante atentar-se ao prazo de entrega, pois esta é uma atividade obrigatória, que vale 60% da nota de todas as disciplinas da fase.

## Tecnologias Utilizadas

- **Spring Boot**
- **Docker**
- **Java 21**
- **PostgreSQL**

## Configuração do Ambiente

### Requisitos

- Docker
- Java 21
- Maven

### Passos para Configuração

1. **Clonar o Repositório**

```sh
git clone https://github.com/MatheusFDS/spring-boot-salao-fiap
cd spring-boot-salao-fiap
```

2. **Configurar o PostgreSQL no Docker**

Crie um arquivo `docker-compose.yml` com o seguinte conteúdo:

```yaml
version: '3.1'

services:
  db:
    image: postgres:latest
    environment:
      POSTGRES_DB: fiap
      POSTGRES_USER: mathex
      POSTGRES_PASSWORD: Ma241194
    ports:
      - "5432:5432"
```

Inicie o container PostgreSQL:

```sh
docker-compose up -d
```

3. **Configurar as Variáveis de Ambiente**

Certifique-se de que o arquivo `application.properties` esteja configurado corretamente para conectar-se ao banco de dados PostgreSQL:

```properties
# Database Configuration
spring.datasource.url=jdbc:postgresql://localhost:5432/fiap
spring.datasource.username=mathex
spring.datasource.password=Ma241194
spring.datasource.driver-class-name=org.postgresql.Driver

# Hibernate Configuration
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
spring.jpa.hibernate.ddl-auto=update
```

4. **Construir o Projeto**

```sh
mvn clean install
```

5. **Executar a Aplicação**

```sh
mvn spring-boot:run
```

A aplicação estará disponível em [http://localhost:8080](http://localhost:8080).

## API Endpoints

### Estabelecimentos

- **POST /api/establishments**
- **GET /api/establishments**
- **GET /api/establishments/searchByLocation**
- **PUT /api/establishments/{id}**
- **DELETE /api/establishments/{id}**

### Profissionais

- **POST /api/professionals**
- **GET /api/professionals**
- **GET /api/professionals/searchBySpecialty**
- **GET /api/professionals/searchByAvailableHours**
- **PUT /api/professionals/{id}**
- **DELETE /api/professionals/{id}**

### Agendamentos

- **POST /api/appointments**
- **GET /api/appointments**
- **GET /api/appointments/{id}**
- **PUT /api/appointments/{id}**
- **DELETE /api/appointments/{id}**

### Avaliações

- **POST /api/reviews**
- **GET /api/reviews**
- **GET /api/reviews/{id}**
- **GET /api/reviews/establishment/{id}**
- **GET /api/reviews/professional/{id}**
- **PUT /api/reviews/{id}**
- **DELETE /api/reviews/{id}**

### Pesquisa

- **GET /api/search/establishments**
- **GET /api/search/professionals**

### Integração com Google Calendar

- **POST /api/calendar/google**
