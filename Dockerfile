
FROM openjdk:11.0.13-jdk

RUN mkdir app
WORKDIR /app

COPY ./application/target/application-0.0.1-SNAPSHOT.jar  /app/apiteste.jar

CMD ["java","-Dcom.sun.security.enableAIAcaIssuers=false","-jar", "-Dserver.port=8080", "apiteste.jar"]