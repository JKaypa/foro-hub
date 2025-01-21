# Foro Hub API

## English

### Overview
Foro Hub is a RESTful API designed for managing discussion topics and comments, providing authentication and authorization functionalities. It is implemented using Java and Spring Boot and includes Swagger documentation for easy API exploration.

---

### Features
- **Topic Management**: Full CRUD operations for topics.
- **Comment Management**: Full CRUD operations for comments.
- **Authentication**:
  - User Signup.
  - User Signin with JWT-based authentication.
- **API Documentation**: Explore endpoints using Swagger.

---

### Technologies
- **Backend**: Java, Spring Boot.
- **Security**: Spring Security, JWT.
- **Database**: MySQL.
- **Documentation**: Swagger UI.
- **Build Tool**: Maven.

---

### Endpoints

#### Authentication

1. **Signup**
   - **URL**: `/auth/signup`
   - **Method**: POST
   - **Request Body**:
     ```json
     {
       "name": "John Doe",
       "email": "johndoe@example.com",
       "password": "securePassword123"
     }
     ```
   - **Response**:
     ```json
     {
       "id": 1,
       "name": "John Doe",
       "email": "johndoe@example.com",
       "token": "<JWT Token>"
     }
     ```

2. **Signin**
   - **URL**: `/auth/signin`
   - **Method**: POST
   - **Request Body**:
     ```json
     {
       "email": "johndoe@example.com",
       "password": "securePassword123"
     }
     ```
   - **Response**:
     ```json
     {
       "id": 1,
       "name": "John Doe",
       "email": "johndoe@example.com",
       "token": "<JWT Token>"
     }
     ```

#### Topic Management

1. **Create a Topic**
   - **URL**: `/topics`
   - **Method**: POST
   - **Request Body**:
     ```json
     {
       "title": "New Topic",
       "description": "This is a new discussion topic.",
       "author": 1
     }
     ```

2. **Read Topics**
   - **URL**: `/topics`
   - **Method**: GET

3. **Update a Topic**
   - **URL**: `/topics/{id}`
   - **Method**: PUT
   - **Request Body**:
     ```json
     {
       "title": "Updated Topic",
       "description": "Updated description."
       "status": "closed"
     }
     ```

4. **Delete a Topic**
   - **URL**: `/topics/{id}`
   - **Method**: DELETE

#### Comment Management

1. **Create a Comment**
   - **URL**: `/comments`
   - **Method**: POST
   - **Request Body**:
     ```json
     {
       "message": "This is a comment.",
       "topic": 1,
       "author": 1
     }
     ```

2. **Update a Comment**
   - **URL**: `/comments/{id}`
   - **Method**: PUT
   - **Request Body**:
     ```json
     {
       "message": "Updated comment."
     }
     ```

3. **Delete a Comment**
   - **URL**: `/comments/{id}`
   - **Method**: DELETE

---

### Swagger Documentation
- Access the API documentation at `/swagger-ui/index.html`.

---

## Español

### Resumen
Foro Hub es una API RESTful diseñada para gestionar temas de discusión y comentarios, proporcionando funcionalidades de autenticación y autorización. Está implementada en Java con Spring Boot e incluye documentación Swagger para una exploración sencilla de la API.

---

### Características
- **Gestión de Temas**: Operaciones CRUD completas para temas.
- **Gestión de Comentarios**: Operaciones CRUD completas para comentarios.
- **Autenticación**:
  - Registro de usuarios.
  - Inicio de sesión con autenticación basada en JWT.
- **Documentación API**: Explora los endpoints usando Swagger.

---

### Tecnologías
- **Backend**: Java, Spring Boot.
- **Seguridad**: Spring Security, JWT.
- **Base de Datos**: MySQL.
- **Documentación**: Swagger UI.
- **Herramienta de Construcción**: Maven.

---

### Endpoints

#### Autenticación

1. **Registro**
   - **URL**: `/auth/signup`
   - **Método**: POST
   - **Cuerpo de la Solicitud**:
     ```json
     {
       "name": "Juan Perez",
       "email": "juanperez@example.com",
       "password": "contraseñaSegura123"
     }
     ```
   - **Respuesta**:
     ```json
     {
       "id": 1,
       "name": "Juan Perez",
       "email": "juanperez@example.com",
       "token": "<JWT Token>"
     }
     ```

2. **Inicio de Sesión**
   - **URL**: `/auth/signin`
   - **Método**: POST
   - **Cuerpo de la Solicitud**:
     ```json
     {
       "email": "juanperez@example.com",
       "password": "contraseñaSegura123"
     }
     ```
   - **Respuesta**:
     ```json
     {
       "id": 1,
       "name": "Juan Perez",
       "email": "juanperez@example.com",
       "token": "<JWT Token>"
     }
     ```

#### Gestión de Temas

1. **Crear un Tema**
   - **URL**: `/topics`
   - **Método**: POST
   - **Cuerpo de la Solicitud**:
     ```json
     {
       "title": "Nuevo Tema",
       "description": "Este es un nuevo tema de discusión.",
       "author": 1
     }
     ```

2. **Leer Temas**
   - **URL**: `/topics`
   - **Método**: GET

3. **Actualizar un Tema**
   - **URL**: `/topics/{id}`
   - **Método**: PUT
   - **Cuerpo de la Solicitud**:
     ```json
     {
       "title": "Tema Actualizado",
       "description": "Descripción actualizada."
     }
     ```

4. **Eliminar un Tema**
   - **URL**: `/topics/{id}`
   - **Método**: DELETE

#### Gestión de Comentarios

1. **Crear un Comentario**
   - **URL**: `/comments`
   - **Método**: POST
   - **Cuerpo de la Solicitud**:
     ```json
     {
       "message": "Este es un comentario.",
       "topic": 1,
       "author": 1
     }
     ```

2. **Actualizar un Comentario**
   - **URL**: `/comments/{id}`
   - **Método**: PUT
   - **Cuerpo de la Solicitud**:
     ```json
     {
       "message": "Comentario actualizado."
     }
     ```

3. **Eliminar un Comentario**
   - **URL**: `/comments/{id}`
   - **Método**: DELETE

---

### Documentación Swagger
- Accede a la documentación de la API en `/swagger-ui/index.html`. 

---
