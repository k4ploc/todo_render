# Etapa de construcción
FROM gradle:7.6.0-jdk17-alpine AS build
WORKDIR /app

# Copia los archivos necesarios para construir el proyecto
COPY build.gradle settings.gradle gradlew ./
COPY gradle/ ./gradle/
COPY src/ ./src/
RUN chmod +x gradlew

# Ejecuta el build de Gradle para crear el JAR
RUN ./gradlew build -x test

# Etapa de ejecución
FROM openjdk:17-jdk-alpine
WORKDIR /app

# Copia el archivo JAR generado desde la etapa de construcción
COPY --from=build /app/build/libs/todos_back-0.0.1-SNAPSHOT.jar app.jar

# Expone el puerto en el que se ejecutará la aplicación
EXPOSE 8080

# Comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "app.jar"]
