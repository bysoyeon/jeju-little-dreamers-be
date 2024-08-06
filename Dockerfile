# Build stage
FROM krmp-d2hub-idock.9rum.cc/goorm/gradle:7.5.1-jdk17 AS build

WORKDIR /app

RUN echo "systemProp.http.proxyHost=krmp-proxy.9rum.cc\nsystemProp.http.proxyPort=3128\nsystemProp.https.proxyHost=krmp-proxy.9rum.cc\nsystemProp.https.proxyPort=3128" > /root/.gradle/gradle.properties

# Copy all necessary files for the build
COPY . .

# Build the application
RUN ./gradlew build -x test


# Run stage
FROM krmp-d2hub-idock.9rum.cc/goorm/openjdk:17-jdk-slim

WORKDIR /app

# Copy the jar file from the build stage
COPY --from=build /app/build/libs/*.jar app.jar

# Expose port 8080
EXPOSE 8080

# Command to run the application
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
