FROM eclipse-temurin:17-jdk-jammy
LABEL authors="charilaoschatz"

WORKDIR /src
COPY .mvn/ .mvn
COPY mvnw pom.xml ./
RUN ./mvnw dependency:resolve

COPY src ./src
RUN ./mvnw package

CMD ["./mvnw", "spring-boot:run"]
