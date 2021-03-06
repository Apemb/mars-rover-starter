# Mars Rover Starter - Java

The Mars Rover implementation in Java.

## Tools
- Testing framework: junit
- Assertion library: assertj
- For spies, stubs and mocks: mockito

## Getting Started

### Install dependencies

Before starting to code, don't forget to install all dependencies. Go to the root directory  and run:

```shell
mvn install
```

### Writing code

When you'll write some code, you must place source code files in the main package `com.rover` and test files in the test package also named `com.rover`. 

### Running tests

Run all tests once:

```shell
mvn test
```

## Run the programm

To run the program, you must first generate the .jar package with the following command: 
```shell
mvn package
``` 

Then to launch it, you can type the command:

```shell
java -jar target/rover-1.0-jar-with-dependencies.jar -x 1 -y 2 -d N -c f l
```
(here with a start at x: 1, y: 2, direction: North, commands: forward then left)


