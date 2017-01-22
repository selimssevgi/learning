# Gradle Automation

- Gradle is a build automation tool.
- The ability to create a DSL for builds.
- It is based on a Groovy.

## Benefits
- Loose structure
- Ability to write scripts to build
- Simple two-pass project resolution
- Dependency management
- Remote plugins

*Incremental Build:* It can be configured to build a project only if any
resource has changed in the project. As a result, the overall build execution
time decreases.

## Gradle Wrapper(gradlew)

- Allow the batch file(or shell script) to download the version of Gradle
  specific to each project.

- Which ensures that there's consistency among Gradle versions.
- gradlew is also checked into source code control along with the build artifacts.

* A Gradle script can build one or more projects.
* Each project can have one or more tasks.
* A task can be anything like compiling Java files or building a WAR file.
