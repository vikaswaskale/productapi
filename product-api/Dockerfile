FROM java:8
FROM maven:alpine

WORKDIR /src

COPY . /src

RUN mvn -v
RUN mvn clean install -DskipTests

EXPOSE 8080

ADD ./target/product-api-0.0.1-SNAPSHOT.jar product-api-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","product-api-0.0.1-SNAPSHOT.jar"]