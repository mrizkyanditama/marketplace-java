# Start with a base image containing Maven and OpenJDK 17
FROM maven:3.8.4-openjdk-17-slim AS build

# Set the working directory
WORKDIR /app

# Copy the Maven project descriptor and POM file
COPY pom.xml .

# Copy the entire project and build it
COPY src ./src
RUN mvn clean package -DskipTests

# Create a separate stage for the runtime image
FROM openjdk:17-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the JAR file from the previous stage
COPY --from=build /app/target/marketplace_order_backend-0.0.1-SNAPSHOT.jar ./app.jar

# Expose the port that the Spring Boot application uses
EXPOSE 8080

# Specify the command to run on container startup
CMD ["java", "-jar", "app.jar"]