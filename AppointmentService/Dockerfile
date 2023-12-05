FROM openjdk:17
WORKDIR /appointment-service
VOLUME /tmp
EXPOSE $SPRING_LOCAL_PORT
ARG JAR_FILE=target/AppointmentService-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} AppointmentService-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","AppointmentService-0.0.1-SNAPSHOT.jar"]