FROM adoptopenjdk/openjdk14:jre-14.0.2_12-alpine
ARG JAR_FILE
ADD ${JAR_FILE} /app/app.jar
WORKDIR /app
ENTRYPOINT exec java ${JAVA_OPTS} -jar /app/app.jar