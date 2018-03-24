FROM openjdk:10-jre-slim
ARG version
EXPOSE 8080
RUN mkdir -p /app/
ADD build/libs/gl-item-${version}.jar /app/gl-item.jar
ENTRYPOINT ["java", "-jar", "/app/gl-item.jar"]