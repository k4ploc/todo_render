# Etapa de construcción
FROM gradle:7.3.3-jdk17 AS build
COPY --chown=gradle:gradle . /home/gradle/project
WORKDIR /home/gradle/project
RUN ./gradlew clean build -x test

# Etapa de ejecución
FROM openjdk:17.0.1-jdk-slim
COPY --from=build /home/gradle/project/build/libs/todos_back-0.0.1-SNAPSHOT.jar todos.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","todos.jar"]
