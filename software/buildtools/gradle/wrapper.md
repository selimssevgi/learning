# gradlew

- provides a specific version of Gradle to the project

- useful for consistent build

- useful for on build server (CI)

* using the wrapper is considered best practice and should be mandatory for every Gradle project.


```shell
gradlew build
```

### Wrapper Tasks

- standard task, always available

- can customize Wrapper task

- this task definition is needed once to create wrapper files in the project
- but it is a good idea to leave it in build file as a documentation

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
