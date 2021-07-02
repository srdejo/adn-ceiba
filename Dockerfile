FROM openjdk:8-jre-alpine
EXPOSE 8081
ARG JAR_FILE=microservicio/build/libs/domi-api-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} ./opt/app.jar
ENTRYPOINT ["java","-jar","/opt/app.jar"]