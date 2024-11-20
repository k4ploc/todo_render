# Usa una imagen base de OpenJDK 17
FROM openjdk:17-jdk-alpine

# Establece el directorio de trabajo dentro del contenedor
WORKDIR /app

# Copia el archivo Gradle Wrapper y los archivos de construcción
COPY gradlew .
COPY gradle/ gradle/
COPY build.gradle .
COPY settings.gradle .

# Copia el resto de los archivos del proyecto
COPY src/ src/

# Da permisos de ejecución al Gradle Wrapper
RUN chmod +x gradlew

# Ejecuta el build de Gradle para crear el JAR, saltando los tests
RUN ./gradlew build -x test

# Copia el archivo JAR generado al contenedor
COPY build/libs/todos_back-0.0.1-SNAPSHOT.jar app.jar

# Expone el puerto en el que se ejecutará la aplicación
EXPOSE 8080

# Comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "app.jar"]
