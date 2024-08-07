# Java App Template

A minimalistic Java application template designed to serve as a starting point for Java applications using Java 17.

## Description

This project provides a basic structure for Java applications with a focus on demonstrating core Java concepts such as:

- Event-driven programming
- Asynchronous operations
- Unit testing
- Configuration management

It includes essential configurations for Maven, JUnit 5, and JavaDoc, making it easy to start developing robust Java
applications with strong typing and code quality tools in place.

## Prerequisites

- Java Development Kit (JDK) 17 or later
- Maven 3.6 or later

## Installation

To get started with this project, follow these steps:

1. Clone the repository:  
   `git clone https://github.com/ikosumi/maven-java-barebone.git`

2. Navigate to the project directory:  
   `cd maven-java-barebone`

3. Build the project:  
   `mvn clean install`

## Usage

After installation, you can run the application using the following command:

java -cp target/java-app-template-1.0-SNAPSHOT.jar com.example.Main

## Project Structure

```markdown
maven-java-barebone/
├── src/
│ ├── main/
│ │ └── java/
│ │ └── com/
│ │ └── example/
│ │ ├── App.java
│ │ ├── AppConfig.java
│ │ ├── AppEventListener.java
│ │ └── Main.java
│ └── test/
│ └── java/
│ └── com/
│ └── example/
│ └── AppTest.java
├── pom.xml
└── README.md
```

## Testing

This project uses JUnit 5 for testing. To run tests:

```shell
mvn test
```

## JavaDoc

To generate JavaDoc for the project:

```shell
mvn javadoc:javadoc
```

The generated documentation will be available in the target/site/apidocs directory.
