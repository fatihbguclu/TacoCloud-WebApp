# TacoCloud-WebApp
This Repository contains codes of Taco Cloud Web Application from Spring in Action, 5th edition, Book

# Running Project
Taco Cloud is broken into a Multi-Module Maven project
To build project:
```
% ./mvnw clean package
```
To Running project when built is done:
```
% java -jar tacos/target/TacoCloud-0.0.1-SNAPSHOT.jar
```

# Maven Modules:
* ```api``` The REST API
* ```data``` Spring Data JPA module
* ```domain``` Contains Entities
* ```kitchen``` A listener for receive order from messaging.
* ```messaging-jms``` Messaging module that sends messages using JMS.
* ```messaging-kafka``` Messaging module that sends messages using ArtemisMQ.
* ```messaging-rabbit``` Messaging module that sends messages using RabbitMQ.
* ```web``` The web module contains rendering for View files.
* ```taco``` The main module that pulls the other modules and provide Spring Boot class
