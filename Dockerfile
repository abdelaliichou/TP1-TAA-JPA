# Use Maven + Java image to build and run the app
FROM maven:3.9.4-eclipse-temurin-17

# Set working directory
WORKDIR /app

# Copy project files
COPY pom.xml .
COPY src ./src

# Pre-download dependencies for faster container start
RUN mvn dependency:go-offline

# Expose ports (Jetty default 8080)
EXPOSE 8080

# Run the app using Maven Spring Boot/Jetty plugin
CMD ["mvn", "jetty:run"]
