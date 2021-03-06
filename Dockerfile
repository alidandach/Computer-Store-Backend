FROM openjdk:11-jdk

RUN mkdir -p /usr/application

COPY target/menu-system-service.jar /usr/application/menu-system-service.jar

RUN mkdir -p /usr/application/config

WORKDIR /usr/application

COPY src/main/resources/application-production.yaml /usr/application/config/application-production.yaml
COPY src/main/resources/log4j2.xml /usr/application/config/log4j2.xml
COPY src/main/resources/configuration/staging/http.yaml /usr/application/config/http.yaml
COPY src/main/resources/configuration/staging/drools.yaml /usr/application/config/drools.yaml
COPY src/main/resources/rules/rbt-core.drl /usr/application/config/rbt-core.drl
COPY src/main/resources/rules/mobile.drl /usr/application/config/mobile.drl

CMD ["java", "-jar", "-Dspring.profiles.active=production", "-Dpath=config", "menu-system-service.jar"]