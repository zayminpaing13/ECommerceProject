FROM eclipse-temurin:17-jdk-alpine AS build

# Install Maven
RUN apk --no-cache add maven

# Copy the Maven project files and build the application
COPY . .
RUN mvn clean package -DskipTests

FROM openjdk:19
COPY --from=build /target/ECommerce-0.0.1-SNAPSHOT.jar demo.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "demo.jar"]
