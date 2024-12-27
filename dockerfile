FROM eclipse-temurin:21.0.1_12-jdk-jammy AS build

# Establecer variables de entorno
ENV JAVA_HOME=/opt/java/openjdk
ENV PATH="${JAVA_HOME}/bin:${PATH}"
ENV MAVEN_HOME=/usr/share/maven

# Instalar Maven
RUN apt-get update && \
    apt-get install -y maven

WORKDIR /workspace/app

# Copiar el proyecto
COPY . .

# Verificar versiones
RUN java -version && \
    mvn -version

# Construir el proyecto
RUN mvn clean package -DskipTests

# Imagen final
FROM eclipse-temurin:21-jre-jammy

WORKDIR /app

# Copiar el jar desde la etapa de construcción
COPY --from=build /workspace/app/target/*.jar app.jar

# Exponer el puerto 8080
EXPOSE 8080

# Ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "app.jar"]

# Define el comando para ejecutar la aplicación
# CMD ["java", "-jar", "target/backendCasuarinas-0.0.1-SNAPSHOT.jar"]
