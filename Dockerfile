FROM openjdk:17

COPY target/assn3-0.0.1-SNAPSHOT.jar app.jar

CMD ["java", "-jar", "app.jar"]