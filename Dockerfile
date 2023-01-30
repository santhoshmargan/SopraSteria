FROM openjdk:11

COPY Fms/target/*.jar .

#WORKDIR /app

#COPY target/template-*.war app.war

#USER 65534

RUN mkdir /test

RUN chmod 0777 /test

CMD ["java", "-jar", "spring-boot-docker.jar"]
EXPOSE 8080
