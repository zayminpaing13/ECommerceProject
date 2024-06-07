FROM eclipse-temurin:17-jdk-alpine AS build
COPY . .
RUN mvn clean package -DskipTests

FROM openjdk:19
COPY --from=build /target/ECommerce-0.0.1-SNAPSHOT.jar demo.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "demo.jar"]