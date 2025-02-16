FROM openjdk:21
MAINTAINER email = "lasya@example.com"
EXPOSE 8090
ADD target/bookapp-0.0.1-SNAPSHOT.jar bookapp.jar
ENTRYPOINT ["java", "-jar", "bookapp.jar"]