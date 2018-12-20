FROM openjdk:11.0.1-jre

COPY build/libs/polyglot-0.0.1-SNAPSHOT.jar app.jar

HEALTHCHECK --interval=1s --timeout=3s --retries=5 --start-period=30s \
		CMD curl -LI http://localhost:8080/actuator/health -o /dev/null -w '%{http_code}\n' -s | xargs -I {} test '200' = {}

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom", "-jar","/app.jar"]
