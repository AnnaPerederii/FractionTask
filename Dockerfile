FROM maven:3.3-jdk-8-alpine
WORKDIR "/app"
VOLUME /tmp
COPY . ./
RUN mvn clean install && mvn package
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app/target/com.calculation.fraction-1.0-SNAPSHOT.jar"]