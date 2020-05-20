FROM maven:3.6.3-openjdk-8-slim AS builder
WORKDIR /kraken
COPY pom.xml pom.xml
COPY src src
COPY target target
RUN mvn package

FROM openjdk:8-jdk-alpine 
COPY --from=builder /kraken/target/*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]