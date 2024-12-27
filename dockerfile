# Usar la imagen oficial de Eclipse Temurin JDK 21
FROM eclipse-temurin:21-jdk-jammy as build

# Establecer el directorio de trabajo
WORKDIR /workspace/app

# Copiar el archivo pom.xml y los archivos fuente
COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .
COPY src src

# Dar permisos de ejecución al mvnw y construir el proyecto
RUN chmod +x mvnw
RUN ./mvnw clean package -DskipTests

# Crear la imagen final más ligera
FROM eclipse-temurin:21-jre-jammy

# Información sobre el mantenedor
LABEL maintainer="your-email@example.com"

# Crear un usuario no root para ejecutar la aplicación
RUN addgroup --system javauser && adduser --system --ingroup javauser javauser

# Copiar el jar desde la etapa de construcción
COPY --from=build /workspace/app/target/*.jar app.jar

# Cambiar la propiedad del archivo jar al usuario no root
RUN chown javauser:javauser app.jar

# Cambiar al usuario no root
USER javauser

# Exponer el puerto 8080
EXPOSE 8080

# Comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "/app.jar"]

# Define el comando para ejecutar la aplicación
# CMD ["java", "-jar", "target/backendCasuarinas-0.0.1-SNAPSHOT.jar"]
