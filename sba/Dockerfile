FROM eclipse-temurin:21-jre-jammy
WORKDIR /app
COPY ns-springadmin-0.0.1-SNAPSHOT.jar app.jar
COPY application.properties .
EXPOSE 8081

ENTRYPOINT ["java", "-jar", "app.jar"]
