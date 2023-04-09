FROM eclipse-temurin:17
MAINTAINER whoever
RUN mkdir /opt/app
COPY /target/docker-demo-1.jar /opt/app
EXPOSE 8000
ENTRYPOINT ["java", "-jar", "/opt/app/docker-demo-1.jar"]