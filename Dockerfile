# Use OpenJDK 21 as base image
FROM eclipse-temurin:21-jdk-alpine

# Set working directory inside container
WORKDIR /app

# Copy the JAR built by Jenkins
COPY target/*.jar app.jar

# Expose the port your Spring Boot app runs on
EXPOSE 8989

# Command to run the Spring Boot application
ENTRYPOINT ["java", "-jar", "app.jar"]
