# gradlew

- provides a specific version of Gradle to the project

- useful for consistent build

- useful for on build server (CI)


```shell
gradlew build
```

### Wrapper Tasks

- standard task, always available

- can customize Wrapper task

```groovy
task wrapper(type: Wrapper) {
  gradleVersion = "2.6"
}
```

### Install Bootstrap Files

- can check in to source repository


```shell
gradle wrapper
```

```shell
project
  gradlew
  gradlew.bat
  gradle/wrapper
    gradle-wrapper.jar
    gradle-wrapper.properties
```
