# syntax=docker/dockerfile:1

FROM eclipse-temurin:17-jdk-jammy


# Provide a description of the image
LABEL "com.hanocybous.e-commerce.vendor"="Hanocybous Inc."
LABEL version="1.0.0"
LABEL architecture="amd64"
LABEL description="This is a docker image for the e-commerce website"
LABEL org.opencontainers.image.description description

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
