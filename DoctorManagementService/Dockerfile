FROM openjdk:17
WORKDIR /doctor-management-service
VOLUME /tmp
EXPOSE 8082
ARG JAR_FILE=target/DoctorManagementService-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} DoctorManagementService-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","DoctorManagementService-0.0.1-SNAPSHOT.jar"]