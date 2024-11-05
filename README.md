# BankAccountSpring
Simulation project for bank account and money transactions with Spring and Spark

## ⚙️ Requirements

- JDK 17
- Maven 3.9.4

## 📘 Technologies

### Common

| Technology | Purpose |
| ---------- |----------|
|Hexagonal architecture| I tried to follow an hexagonal clean architecture when creating this simple example. You can take a look into the project modules to see how the code was divided into application, domain and infrastructure layers. You can also take a look into the interfaces I'm using as "ports" to avoid layer couplings. |
| [Domain Driven Design](https://en.wikipedia.org/wiki/Domain-driven_design) | I tried to include some DDD patterns into this very simple example, like Entity, ValueObject or RootAggregate. |
| [Lombok](https://projectlombok.org/) | Helper to create builders, setters, getters, etc|
| [MapStruct](https://mapstruct.org/) | Helper to create mappers to pass objects between the different layers |
| [Spring-boot](https://quarkus.io/) | Java framework that helps you to create a REST microservice easily . |
| [rest-assured](https://rest-assured.io/) | REST Assured is a Java DSL for simplifying testing of REST based services |

## 🚀 How to execute the application

Go to the project root directory and execute the following command to compile, test, package and install the different artifacts in your local maven repository.

```shell
mvn clean install
```

Or use the embedded maven wrapper if you don't have a maven installation.

```shell
./mvnw clean install
```

After creating all artifacts you can run the project with the following command:

```shell
mvn spring-boot:run -pl application
```

Or use the embedded maven wrapper if you don't have a maven installation.

```shell
./mvnw spring-boot:run -pl application
```