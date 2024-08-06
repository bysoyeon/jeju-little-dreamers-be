# Build stage
FROM gradle:7.5.1-jdk17 AS build

WORKDIR /app

# Copy all necessary files for the build
COPY gradlew /app/
COPY build.gradle /app/
COPY settings.gradle /app/
COPY gradle /app/gradle
COPY src /app/src

# Build the application
RUN ./gradlew build -x test

# Run stage
FROM openjdk:17-jdk-slim

WORKDIR /app

# Copy the jar file from the build stage
COPY --from=build /app/build/libs/*.jar app.jar

# Expose port 8080
EXPOSE 8080

# Command to run the application
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
