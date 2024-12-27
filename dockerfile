# Usa una imagen base con JDK 21
FROM eclipse-temurin:21-jdk AS build

# Configura el directorio de trabajo dentro del contenedor
WORKDIR /app

# Copia todos los archivos del proyecto al contenedor
COPY . .

# Da permisos de ejecución al script Maven Wrapper
RUN chmod +x mvnw

# Construye el proyecto sin ejecutar pruebas
RUN ./mvnw clean package -DskipTests

# Fase de ejecución
FROM eclipse-temurin:21-jdk

# Configura el directorio de trabajo para la ejecución
WORKDIR /app

# Copia el JAR generado desde la fase de build
COPY --from=build /app/target/*.jar app.jar

# Expone el puerto 8080
EXPOSE 8080

# Define el comando para ejecutar la aplicación
CMD ["java", "-jar", "target/backendCasuarinas-0.0.1-SNAPSHOT.jar"]
