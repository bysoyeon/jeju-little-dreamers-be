# Build stage
FROM krmp-d2hub-idock.9rum.cc/goorm/gradle:7.5.1-jdk17 AS build

WORKDIR /app

RUN echo "systemProp.http.proxyHost=krmp-proxy.9rum.cc\nsystemProp.http.proxyPort=3128\nsystemProp.https.proxyHost=krmp-proxy.9rum.cc\nsystemProp.https.proxyPort=3128" > /root/.gradle/gradle.properties

# Copy all necessary files for the build
#COPY gradlew /app/
#COPY build.gradle /app/
#COPY settings.gradle /app/
#COPY gradle /app/gradle
#COPY src /app/src
COPY . .

RUN gradle wrapper

RUN ./gradlew build -x test
# Expose port 8080
EXPOSE 8080

# Command to run the application
ENTRYPOINT ["java", "-jar", "/app/build/libs/jejuddai-0.0.1-SNAPSHOT.jar"]
