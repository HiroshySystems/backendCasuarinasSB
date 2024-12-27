FROM eclipse-temurin:17-jdk-jammy as build

WORKDIR /workspace/app

# Copiar el proyecto www
COPY . .

# Construir el proyecto
RUN chmod +x mvnw && \
    ./mvnw clean package -DskipTests

# Imagen final
FROM eclipse-temurin:17-jre-jammy

WORKDIR /app

# Copiar el jar
COPY --from=build /workspace/app/target/*.jar app.jar

# Exponer el puerto 8080
EXPOSE 8080

# Define el comando para ejecutar la aplicación
# CMD ["java", "-jar", "target/backendCasuarinas-0.0.1-SNAPSHOT.jar"]
# Ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "app.jar"]
