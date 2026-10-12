# BFFCN2
Microservicio BFF (Backend For Frontend) del Sistema de Gestión de Usuarios y Roles, desarrollado con Spring Boot. Es el punto de entrada del sistema: recibe las peticiones del cliente y orquesta las llamadas a las funciones serverless de Azure mediante REST y GraphQL, devolviendo las respuestas en formato JSON.
 
## Endpoints
 
| Método | Endpoint | Función destino |
| --- | --- | --- |
| GET, POST, PUT, DELETE | /api/usuarios | UsuariosFunction |
| GET, POST, PUT, DELETE | /api/roles | RolesFunction |
| POST | /api/graphql/usuarios | UsuariosGraphQLFunction |
| POST | /api/graphql/roles | RolesGraphQLFunction |
 
En PUT y DELETE el id va en el body, por ejemplo `{ "id_usuario": "1" }` o `{ "id_rol": "2" }`.
 
## Configuración
 
Las URLs de las funciones se configuran en `src/main/resources/application.properties`.
 
## Tecnologías
 
- Java 21
- Spring Boot (spring-boot-starter-webmvc)
- RestTemplate
- Docker
## Ejecutar
 
Local:
 
```bash
./mvnw spring-boot:run
```
 
Docker:
 
```bash
./mvnw clean package -DskipTests
docker build -t bff-usuarios-roles .
docker run -d -p 8080:8080 bff-usuarios-roles
```
 
El servicio queda disponible en `http://localhost:8080/api`.
