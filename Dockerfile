FROM maven:3.8.5-openjdk-17 AS build
COPY . .
RUN mvn clean package -DskipTest

FROM openjdk:17.0.1-jdk-slim
COPY --from=build /target/todos_back-0.0.1-SNAPSHOT.jar todos.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","todos.jar"]
