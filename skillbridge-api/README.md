# SkillBridge - API RESTful (Global Solution 2025)

Plataforma de Upskilling/Reskilling para o futuro do trabalho (2030+).

## Tecnologias
- Java 17
- Spring Boot 3.2.x
- Spring Data JPA
- H2 (banco em memória)
- Bean Validation (jakarta.validation)
- Lombok (apenas para reduzir boilerplate; opcional)

## Como executar (local)
1. Tenha Java 17+ e Maven instalados.
2. Rodar:
```bash
mvn clean install
mvn spring-boot:run
```
3. A API estará disponível em: `http://localhost:8080`

H2 Console: `http://localhost:8080/h2-console` (JDBC URL: `jdbc:h2:mem:skillbridge`, user `sa`, senha vazia)

## Endpoints principais (exemplos)
### Usuários
- `GET /api/usuarios`
- `GET /api/usuarios/{id}`
- `POST /api/usuarios`
- `PUT /api/usuarios/{id}`
- `DELETE /api/usuarios/{id}`

### Trilhas
- `GET /api/trilhas`
- `GET /api/trilhas/{id}`
- `POST /api/trilhas`
- `PUT /api/trilhas/{id}`
- `DELETE /api/trilhas/{id}`

## Seeds
Dados iniciais são carregados via `src/main/resources/data.sql`

## Observações
- O projeto usa Lombok para gerar getters/setters/constructors (se preferir, remova e gere manualmente).
- Ajuste `application.properties` para utilizar MySQL em vez do H2, se necessário.
