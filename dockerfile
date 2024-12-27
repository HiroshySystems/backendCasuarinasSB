# Usa la imagen base de Eclipse Temurin con JDK 21
FROM eclipse-temurin:21-jdk

# Instala Maven
RUN apt-get update && apt-get install -y maven

# Define el directorio de trabajo dentro del contenedor
WORKDIR /app

# Copia todos los archivos del proyecto al contenedor
COPY . .

# Construye el proyecto (sin ejecutar pruebas)
RUN mvn package -DskipTests

# Expon el puerto de tu aplicación
EXPOSE 8080

# Define el comando para ejecutar la aplicación
CMD ["java", "-jar", "target/backendCasuarinas-0.0.1-SNAPSHOT.jar"]
