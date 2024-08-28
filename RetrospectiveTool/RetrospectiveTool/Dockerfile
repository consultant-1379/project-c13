FROM maven:3.5.4-jdk-8-alpine as maven
COPY ./pom.xml ./pom.xml
COPY ./src ./src
RUN mvn dependency:go-offline -B
RUN mvn package -DskipTests
FROM openjdk:8u171-jre-alpine
WORKDIR /RetrospectiveTool
COPY --from=maven target/RetrospectiveTool-*.jar RetrospectiveTool.jar
ENTRYPOINT ["java", "-jar", "/RetrospectiveTool/RetrospectiveTool.jar"]