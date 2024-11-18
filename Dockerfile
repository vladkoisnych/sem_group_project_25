# this is a dockerfile with a link to the latest release jar file
FROM openjdk:latest
COPY ./target/groupProject25.jar /tmp
WORKDIR /tmp
ENTRYPOINT ["java", "-jar", "groupProject25.jar", "db:3306", "10000"]