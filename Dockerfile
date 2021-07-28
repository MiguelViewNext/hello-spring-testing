# Build stage
FROM openjdk:11 AS base
WORKDIR /opt/hello-spring
COPY ./ ./
RUN ./gradlew assemble \
  && rm -rf /root/.gradle
#CMD java -jar build/libs/demo-0.0.1-SNAPSHOT.jar

# Runtime stage
# FROM adoptopenjdk:11-jre-hotspot
#FROM openjdk:11.0.12-jre-slim-buster
FROM openjdk:11.0-jre-slim
WORKDIR /opt/hello-spring
COPY --from=base /opt/hello-spring/build/libs/hello-spring-0.0.1-SNAPSHOT.jar ./
CMD java -jar hello-spring-0.0.1-SNAPSHOT.jar