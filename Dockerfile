FROM openjdk:11
COPY "./target/security-0.0.1-SNAPSHOT.jar" "app.jar"
EXPOSE 8080
ENTRYPOINT ["java -Duser.timezone=UTC", "-jar", "app.jar"]