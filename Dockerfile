# syntax=docker/dockerfile:1

FROM eclipse-temurin:17-jdk-jammy


# Provide a description of the image
LABEL maintainer="
    name: Hanocybous
    email: harrychatz5@gmail.com
    github: github.com/Hanocybous
    description: This is a docker image for the Spring Boot E-commerce application hosted on github.com/Hanocybous/ecommerce
"

# Set the working directory
ARG DIRNAME=ecommerce
ARG DIRPATH=/path
WORKDIR ${DIRPATH}/${DIRNAME}
RUN mkdir -p ${DIRPATH}/${DIRNAME}

# Copy the files
COPY .mvn/ .mvn
COPY mvnw pom.xml ./
RUN chmod +x mvnw

# Resolve the dependencies
RUN ./mvnw dependency:resolve

COPY src ./src

CMD ["./mvnw", "spring-boot:run"]
