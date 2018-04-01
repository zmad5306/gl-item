FROM openjdk:10-jdk-slim AS build
COPY . /src
RUN cd /src gradlew build

FROM openjdk:10-jre-slim AS production
ARG version
EXPOSE 8080
RUN mkdir -p /app/
COPY --from=build /src/build/libs/gl-item-${version}.jar /app/gl-item.jar
ENTRYPOINT ["java", "-XX:+PrintFlagsFinal", "-XX:+UnlockExperimentalVMOptions", "-XX:+UseCGroupMemoryLimitForHeap", "-jar", "/app/gl-item.jar"]