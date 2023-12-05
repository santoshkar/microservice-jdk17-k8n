FROM openjdk:17
WORKDIR /notification-service
VOLUME /tmp
EXPOSE 8081
ARG JAR_FILE=target/NotificationService-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} NotificationService-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","NotificationService-0.0.1-SNAPSHOT.jar"]