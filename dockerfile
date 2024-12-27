# Utiliza una imagen base de OpenJDK 21
FROM openjdk:21-jdk

# Define el directorio de trabajo en el contenedor
WORKDIR /app

# Copia el archivo pom.xml y el archivo mvnw para manejar dependencias
COPY pom.xml mvnw /app/

# Copia todo el código fuente al contenedor
COPY . /app/

# Da permisos de ejecución al script mvnw
RUN chmod +x ./mvnw

# Ejecuta Maven para descargar dependencias e instalar el proyecto
RUN ./mvnw -DoutputFile=target/mvn-dependency-list.log -B -DskipTests clean install

# Expone el puerto que utilizará la aplicación (si es necesario)
EXPOSE 8080

# Comando para ejecutar la aplicación Spring Boot
CMD ["./mvnw", "spring-boot:run"]


# Define el comando para ejecutar la aplicación
# CMD ["java", "-jar", "target/backendCasuarinas-0.0.1-SNAPSHOT.jar"]
