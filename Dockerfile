FROM openjdk:11-jdk

RUN mkdir -p /usr/application

COPY target/computer-store-backend.jar /usr/application/computer-store-backend.jar

RUN mkdir -p /usr/application/config

WORKDIR /usr/application

COPY src/main/resources/docker.yaml /usr/application/config/application.yaml
COPY src/main/resources/log4j2.xml /usr/application/config/log4j2.xml

CMD ["java", "-jar", "computer-store-backend.jar"]