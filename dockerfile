# Etapa de construcción
FROM maven:3.10-openjdk-21

WORKDIR /app

# Copiar los archivos del proyecto a la carpeta de trabajo
COPY . /app/

# Ejecutar Maven para instalar dependencias y compilar
RUN mvn clean install

# Etapa de ejecución
FROM openjdk:21-jdk-slim

WORKDIR /app

# Copiar los archivos compilados desde la etapa de construcción
COPY --from=build /app/target/backendCasuarinas-0.0.1-SNAPSHOT.jar /app/backendCasuarinas.jar

# Exponer el puerto de la aplicación
EXPOSE 8080

# Comando para ejecutar la aplicación
CMD ["java", "-jar", "backendCasuarinas.jar"]

# Define el comando para ejecutar la aplicación
# CMD ["java", "-jar", "target/backendCasuarinas-0.0.1-SNAPSHOT.jar"]
