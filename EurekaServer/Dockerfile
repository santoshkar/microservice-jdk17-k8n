FROM openjdk:17
WORKDIR /eureka-service
VOLUME /tmp
EXPOSE $SPRING_LOCAL_PORT
ARG JAR_FILE=target/EurekaServer-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} EurekaServer-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","EurekaServer-0.0.1-SNAPSHOT.jar"]