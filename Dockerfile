FROM openjdk:11
COPY "./target/feria-virtual-backend.jar" "app.jar"
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]