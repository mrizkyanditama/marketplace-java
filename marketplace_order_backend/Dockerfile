# Use a base image with JDK and Maven installed
FROM maven:3.8.4-openjdk-17-slim AS build

# Set the working directory
WORKDIR /app

# Copy the Maven project descriptor and POM file
COPY pom.xml .

# Fetch dependencies first to optimize caching
RUN mvn dependency:go-offline

# Copy the entire project
COPY src ./src

# Stage 1: Build the application
RUN mvn package -DskipTests

# Stage 2: Runtime image
FROM openjdk:17-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the built JAR file from the build stage
COPY --from=build /app/target/marketplace_order_backend-0.0.1-SNAPSHOT.jar ./app.jar

# Expose the port that the Spring Boot application uses
EXPOSE 8080

# Specify the command to run on container startup
CMD ["java", "-jar", "app.jar"]