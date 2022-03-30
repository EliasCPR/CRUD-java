FROM openjdk:8-alpine

RUN mkdir -p /opt/app
WORKDIR /opt/app

COPY pom.xml pom.xml
COPY .mvn .mvn
COPY mvnw mvnw

RUN sh mvnw dependency:resolve

COPY src src

RUN sh mvnw install -Dmaven.test.skip=true

WORKDIR /opt/app/target

RUN mkdir xxx; unzip -d xxx cliente-0.0.1-SNAPSHOT.jar; ls -lahF xxx
RUN cat xxx/BOOT-INF/classes/application.properties 

CMD ["java", "-jar", "cliente-0.0.1-SNAPSHOT.jar"]










