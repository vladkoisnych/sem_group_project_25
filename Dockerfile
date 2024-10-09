# this is a dockerfile with a link to the latest release jar file
FROM openjdk:latest
COPY ./target/group_project_25-0.1.0.2-jar-with-dependencies.jar /tmp
WORKDIR /tmp
ENTRYPOINT ["java", "-jar", "group_project_25-0.1.0.2-jar-with-dependencies.jar"]