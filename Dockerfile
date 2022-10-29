FROM openjdk:11

WORKDIR /app

COPY ./target/security-0.0.1-SNAPSHOT.jar .

EXPOSE 9000

ENTRYPOINT ["java", "-jar", "security-0.0.1-SNAPSHOT.jar"]