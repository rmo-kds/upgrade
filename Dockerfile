FROM maven:3-jdk-8-slim

COPY . /usr/src/app

WORKDIR /usr/app

RUN mvn package

EXPOSE 8080

CMD [ "java", "-jar", "/usr/src/app/target/apiPrices-0.0.1-SNAPSHOT.jar" ]