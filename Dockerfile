# Etapa 1: Build con Maven + Java 21 (imagen oficial con todo incluido)
FROM maven:3.9-eclipse-temurin-21-alpine AS build
WORKDIR /workspace

# Copia pom.xml primero para cachear dependencias
COPY pom.xml .

# Resuelve dependencias (cachea esta layer si pom.xml no cambia)
RUN mvn dependency:go-offline -B

# Copia el código fuente
COPY src ./src

# Compila y empaqueta (ajusta -DskipTests si no quieres tests)
RUN mvn clean package -B -DskipTests

# Etapa 2
FROM eclipse-temurin:21-jre-alpine
WORKDIR /app

COPY --from=build /workspace/target/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]