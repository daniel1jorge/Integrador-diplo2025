# Diplo Backend

Backend desarrollado en **Spring Boot** como parte de la **Diplomatura 2025**.  
El proyecto expone una API REST protegida con **Spring Security**, persistencia con **JPA + MySQL** y documentación automática con **Swagger (OpenAPI)**.

---

## 🚀 Tecnologías

- Java 21
- Spring Boot 3.3.5
- Spring Web
- Spring Data JPA
- Spring Security
- MySQL
- Swagger / OpenAPI (springdoc)
- Maven

---

## ⚙️ Configuración

### 📌 Variables de entorno (opcional)

El proyecto puede configurarse mediante variables de entorno o valores por defecto:

| Variable | Descripción | Default |
|-------|------------|---------|
| `PORT` | Puerto del servidor | `8080` |
| `DB_HOST` | Host MySQL | `localhost` |
| `DB_PORT` | Puerto MySQL | `3306` |
| `DB_NAME` | Nombre de la base de datos | `diplo` |
| `DB_USER` | Usuario DB | `root` |
| `DB_PASS` | Password DB | `secure_pass22` |

---

## 🗄️ Base de datos

- Motor: **MySQL**
- La base de datos se crea automáticamente si no existe
- Hibernate: `ddl-auto=update`

---

## 🔐 Seguridad

Por defecto la aplicación usa **Spring Security (Basic Auth)**.

Usuario configurado de springboot admin:

Usuario: admin
Password: admin123


## 📖 Documentación API (Swagger)

La API está documentada automáticamente con **Swagger UI**.

### 🌐 Acceso

http://localhost:8080/swagger-ui.html

### 📄 OpenAPI JSON

http://localhost:8080/v3/api-docs

Swagger está **habilitado sin autenticación** para facilitar el desarrollo.

---

## ▶️ Ejecución del proyecto Local

### 🔹 Desde Maven
```bash
mvn clean spring-boot:run
```


### 📁 Estructura del proyecto (base)
src
 └── main
     ├── java
     │   └── com.diplo.diplo
     │       ├── controller
     │       ├── service
     │       ├── repository
     │       └── model
     └── resources
         └── application.yml


# comandos para crear la imagen docker y levantar con BD local

```bash
mvn clean package
docker build --no-cache -t diplo .
docker run -p 8080:8080 diplo
         
```

# comandos para levantar todo junnto a travez de docker compose.

```bash
mvn clean package
docker compose build .
docker compose up -d .
         
```
