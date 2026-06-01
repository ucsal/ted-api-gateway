# TED API Gateway

Ponto de entrada único da arquitetura de microserviços do sistema TED. Atua como orquestrador, roteando as requisições do cliente para os microserviços corretos e validando a autenticação JWT em todas as rotas protegidas.

## Sobre

O API Gateway recebe todas as requisições externas e as repassa para os serviços responsáveis via balanceamento de carga (`lb://`). Antes de repassar, valida o token JWT — rotas públicas como `/api/auth/login` e `/api/auth/register` são liberadas sem autenticação. O Gateway também agrega o Swagger UI de todos os serviços em uma única interface.

## Tecnologias

- Java 21
- Spring Boot 3.4.1
- Spring Cloud Gateway 2024.0.1
- Spring Cloud Netflix Eureka Client
- JJWT 0.12.6
- SpringDoc OpenAPI WebFlux UI 2.3.0

## Configuração

| Propriedade | Valor |
|---|---|
| Porta | 8080 |
| Eureka | http://localhost:8761/eureka |

## Rotas configuradas

| Rota | Serviço destino | Path |
|---|---|---|
| ted-professor-service | TED-PROFESSOR-SERVICE | /api/professors/** |
| ted-aluno-service | TED-ALUNO-SERVICE | /api/students/** |
| ted-projeto-service | TED-PROJETO-SERVICE | /api/projects/** |
| ted-grupo-service | TED-GRUPO-SERVICE | /api/groups/** |
| ted-auth-service | TED-AUTH-SERVICE | /api/auth/** |

## Como executar

```bash
mvn clean package -DskipTests
java -jar target/ted-api-gateway-0.0.1-SNAPSHOT.jar
```

## Swagger UI agregado

```
http://localhost:8080/swagger-ui.html
```

## Observações

- O Gateway deve ser o **último** serviço a subir
- O `jwt.secret` deve ser idêntico ao configurado no auth-service
- Rotas públicas: `/api/auth/login`, `/api/auth/register` e endpoints do Swagger