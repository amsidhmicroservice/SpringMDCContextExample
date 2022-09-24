FROM adoptopenjdk/openjdk11:alpine-slim
VOLUME /tmp
COPY /target/SpringMDCContextExample-*.jar springmdccontextexample.jar
COPY src src
COPY Dockerfile Dockerfile
COPY pom.xml pom.xml
ENTRYPOINT ["java", "-jar", "springmdccontextexample.jar"]