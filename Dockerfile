FROM openjdk:17-jdk-alpine

ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} app.jar

# 포트 설정
EXPOSE 8080

# 애플리케이션 실행 명령어
ENTRYPOINT ["java", "-jar", "/app.jar"]
