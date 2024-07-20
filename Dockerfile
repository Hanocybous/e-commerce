# syntax=docker/dockerfile:1

FROM eclipse-temurin:17-jdk-jammy


# Provide a description of the image
LABEL "com.hanocybous.e-commerce.vendor"="Hanocybous Inc."
LABEL version="1.0.0"
LABEL architecture="amd64"
LABEL description="This is a docker image for the e-commerce website"
LABEL org.opencontainers.image.description="This is a docker image for the e-commerce website"

# Set the maintainer
MAINTAINER Hanocybous Inc. <

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

# Build the application
RUN ./mvnw package

# Expose the port
EXPOSE 8080

# Provide the default command
CMD ["java", "-jar", "target/ecommerce-0.0.1-SNAPSHOT.jar"]

# Provide the default entrypoint
ENTRYPOINT ["java", "-jar", "target/ecommerce-0.0.1-SNAPSHOT.jar"]
