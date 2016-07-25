# junit5-springboot-kotlin
JUnit5 testing a SpringBoot application written in Kotlin

## Description
This project is a very simple SpringBoot application written in Kotlin. Tests are written using the new JUnit 5 platform.
Tests can be run one of two ways:

1. If you use IntelliJ IDEA then version 2016.2 added JUnit 5 support and each test can be run within the IDE.
2. You can use `gradle test` from the command line
3. You can run the tests as JUnit 4 tests using the custom JUnit4 Test Suite

## Dependencies
This project uses the excellent [spring-test-junit5](https://github.com/sbrannen/spring-test-junit5). Since it isn't published out to a repository I've bundled the JAR into this project under `/libs`.

## Versions
You'll need versions of Kotlin and Gradle available. I've tested with the specified versions.

Kotlin: 1.0.3

Gradle: 2.14

## License

This code is provided under the terms of the MIT license: basically you're free to do whatever you want with it, but no guarantees are made to its validity, stability, or safety. All works referenced by or utilized by this project are the property of their respective copyright holders and retain licensing that may be more restrictive.