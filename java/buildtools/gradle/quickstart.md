# Quick Start with Gradle

## Installation 

```shell
$ sdk install gradle
$ gradle
```

## Usage in Intellij IDEA

- Create new project
- Select Gradle
- Use auto-import 
- Create directories for empty content roots automatically
- Use local gradle distibution - Gradle home: ~/.sdkman/candidates/gradle/current

## Gradle 

- Gradle version 

```shell
$ gradle
```

- Gradle tasks 

```shell
$ gradle tasks
```

### Gradle Build
build task compiles, tests, and assembles the code into a JAR file.

```shell
$ gradle build
```

It creates a build directory in the root of the project.

- **classes:** The project's compiles .class files.
- **reports:** Reports produced by build(such as test reports)
- **libs   :** Assembled project libraries(usually JAR and/or WAR files)
- **dependency_cache:** Project's library dependencies
