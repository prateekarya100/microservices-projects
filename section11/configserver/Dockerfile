FROM openjdk:17-jdk-slim
LABEL authors="Prateek Arya"
EXPOSE 8071
COPY target/configserver-0.0.1-SNAPSHOT.jar configserver-0.0.1-SNAPSHOT.jar
RUN mkdir -p /app/libs
COPY opentelemetry-javaagent-1.27.0.jar /app/libs/opentelemetry-javaagent-1.27.0.jar
ENTRYPOINT ["java", "-jar","/configserver-0.0.1-SNAPSHOT.jar"]