FROM maven:3.8.3-openjdk-17

WORKDIR /app

COPY . .

RUN mvn clean install

ENTRYPOINT ["java", "-jar", "target/telegram-sender-0.0.1-SNAPSHOT.jar "]
