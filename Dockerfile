FROM openjdk:11-jre-slim
COPY build/libs/proxy_mixed-0.0.1-SNAPSHOT.war /app/proxy_mixed-0.0.1-SNAPSHOT.war
CMD ["java", "-jar", "/app/proxy_mixed-0.0.1-SNAPSHOT.war"]