# syntax=docker/dockerfile:1

FROM eclipse-temurin:17-jdk-jammy


LABEL org.opencontainers.image.description='A simple Spring Boot E-commerce application that uses Spring Data JPA with a PostgreSQL database.'
LABEL org.opencontainers.image.authors='Hanocybous'

ENV DIRPATH=/path
WORKDIR $DIRPATH/$DIRNAME
RUN pwd

COPY .mvn/ .mvn
COPY mvnw pom.xml ./
RUN chmod +x mvnw

RUN ./mvnw dependency:resolve

COPY src ./src

CMD ["./mvnw", "spring-boot:run"]
