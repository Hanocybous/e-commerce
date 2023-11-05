FROM eclipse-temurin:17-jdk-jammy
LABEL authors="charilaoschatz"

WORKDIR /src
COPY .mvn/ .mvn
COPY mvnw pom.xml ./
RUN ./mvnw dependency:go-offline

COPY src ./src

CMD ["./mvnw", "spring-boot:run"]
