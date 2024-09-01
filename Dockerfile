# Usar la imagen oficial de OpenJDK 17 como base
FROM openjdk:17-jdk-slim

# Establecer el directorio de trabajo en /app
WORKDIR /app

# Copiar los archivos de construcción de Gradle y el archivo settings.gradle en /app
COPY build.gradle settings.gradle /app/

# Copiar el directorio gradle y gradlew
COPY gradle /app/gradle
COPY gradlew /app/

# Dar permisos de ejecución a gradlew
RUN chmod +x gradlew

# Copiar el directorio src al directorio de trabajo
COPY src /app/src

# Construir el proyecto usando Gradle
RUN ./gradlew build --no-daemon

# Establecer el puerto en el que se ejecutará la aplicación
EXPOSE 8080

# Especificar el comando para ejecutar la aplicación
CMD ["java", "-jar", "build/libs/todo_back-0.0.1-SNAPSHOT.jar"]
