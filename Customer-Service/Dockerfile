# Use OpenJDK 21 slim image
FROM openjdk:21-jdk-slim

# Set working directory
WORKDIR /app

# Copy the built JAR file into the container
# Use wildcard (*) so it works regardless of JAR version
COPY target/*.jar app.jar

# Expose application port
EXPOSE 8084

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
