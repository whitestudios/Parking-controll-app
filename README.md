

# 🚗 Parking Control Application

## 📌 Visão Geral

A **Parking Control Application** é uma API REST construída com **Spring Boot**, projetada para gerenciar vagas de estacionamento em ambientes residenciais ou comerciais. A aplicação permite criar, consultar, atualizar e excluir registros de vagas de forma eficiente, com validações e integrações com banco de dados PostgreSQL.

---

## ✅ Funcionalidades

- **CRUD Completo**: Criação, leitura, atualização e exclusão de registros de vagas de estacionamento.
- **Validações**:
  - Placas de veículos únicas.
  - Números de vagas únicos.
  - Combinação única de apartamento/bloco.
- **Tratamento de Erros**: Respostas HTTP significativas e mensagens de erro claras.
- **Persistência de Dados**: Integração com banco de dados PostgreSQL.
- **API RESTful**: Ideal para integração com front-ends modernos.

---

## 🛠️ Tecnologias Utilizadas

- **Java 17**
- **Spring Boot 3.x**
  - Spring Web
  - Spring Data JPA
  - Spring Validation
- **PostgreSQL**
- **Lombok**
- **Jakarta Validation**
- **Maven**

---

## 📁 Estrutura do Projeto


```
src/main/java/com/darkcommit/parking_control/
├── controllers/ # Controladores REST (ex: ParkingSpotController.java)
├── dtos/ # Data Transfer Objects para validação de requisições
├── models/ # Entidades do banco de dados
├── repositories/ # Repositórios JPA para operações de persistência
├── services/ # Camada de lógica de negócio (ex: ParkingSpotService.java)
└── ParkingControlApplication.java # Ponto de entrada da aplicação
```


---

## 🌐 Endpoints da API

**Base URL**: `/parking-spot`

| Método HTTP | Endpoint         | Descrição                                     | Corpo da Requisição | Corpo da Resposta      |
|-------------|------------------|-----------------------------------------------|----------------------|-------------------------|
| `POST`      | `/create`        | Cria uma nova vaga de estacionamento          | `ParkingSpotDto`     | `ParkingSpotModel`      |
| `GET`       | `/`              | Retorna todas as vagas                        | —                    | Lista de `ParkingSpotModel` |
| `GET`       | `/{id}`          | Retorna uma vaga específica por UUID          | —                    | `ParkingSpotModel`      |
| `DELETE`    | `/{id}`          | Remove uma vaga pelo UUID                     | —                    | Mensagem de sucesso     |
| `PUT`       | `/edit/{id}`     | Atualiza uma vaga existente pelo UUID         | `ParkingSpotDto`     | `ParkingSpotModel`      |

---

## 🗄️ Configuração do Banco de Dados

A aplicação utiliza o **PostgreSQL**. Exemplo de configuração no `application.properties`:

```properties
spring.application.name=parking-control
spring.datasource.url=jdbc:postgresql://localhost:5432/parkingtest
spring.datasource.username=postgres
# spring.datasource.password=123456
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
```

> ⚠️ Substitua os dados acima conforme suas credenciais locais.

---

## 🚀 Como Executar o Projeto

1. Clone o repositório:


```bash
git clone https://github.com/your-username/parking-control-app.git
cd parking-control-app
```

2. Crie um banco de dados no PostgreSQL com o nome `parkingtest`.

3. Configure o arquivo `application.properties` com suas credenciais do banco.

4. Compile e execute o projeto via Maven ou sua IDE preferida:


```bash
./mvnw spring-boot:run
```

5. Acesse a API em:
    📍 `http://localhost:8080/parking-spot`


---

## 📈 Melhorias Futuras

- Adicionar autenticação e autorização (ex: JWT, OAuth2).

- Implementar paginação no endpoint `GET /`.

- Adicionar filtros e ordenações dinâmicas.

- Criar uma interface front-end para facilitar a interação com a API.


---

## 📬 Contato

Para mais informações, consulte o [código-fonte no GitHub](https://github.com/your-username/parking-control-app) ou entre em contato com os mantenedores do projeto.

