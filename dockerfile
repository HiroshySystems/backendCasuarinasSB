FROM eclipse-temurin:17-jdk-focal as build

WORKDIR /app

# Copiar los archivos del proyecto
COPY .mvn/ .mvn
COPY mvnw pom.xml ./
COPY src src/

# Dar permisos de ejecución y construir
RUN chmod +x mvnw && \
    ./mvnw clean package -DskipTests

FROM eclipse-temurin:17-jre-focal

WORKDIR /app

# Copiar el jar desde la etapa de build
COPY --from=build /app/target/*.jar app.jar

# Puerto por defecto para Spring Boot
EXPOSE 8080

# Comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "app.jar"]

# Define el comando para ejecutar la aplicación
# CMD ["java", "-jar", "target/backendCasuarinas-0.0.1-SNAPSHOT.jar"]

