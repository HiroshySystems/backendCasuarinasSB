FROM maven:3.10.1-openjdk-21

WORKDIR /app

# Copiar los archivos del proyecto
COPY . /app/

# Verificar la versión de Java
RUN java -version

# Instalar dependencias y compilar
RUN mvn clean install

# Exponer el puerto para la aplicación
EXPOSE 8080

# Ejecutar la aplicación
CMD ["java", "-jar", "target/backendCasuarinas-0.0.1-SNAPSHOT.jar"]


# Define el comando para ejecutar la aplicación
# CMD ["java", "-jar", "target/backendCasuarinas-0.0.1-SNAPSHOT.jar"]
