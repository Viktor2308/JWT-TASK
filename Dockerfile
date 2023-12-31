FROM openjdk:17-alpine
ARG JAR_FILE=target/*.jar
EXPOSE 8088
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]

