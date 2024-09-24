# Gradle Task

- every newly created task is of type org.gradle.api.DefaultTask
  - standard implementation of org.gradle.api.Task

- Task provides two methods to declare a task action:
  - doFirst(Closure)
  - doLast(Closure)

- Has a lifecycle

- Has properties

- Has actions

- Has dependencies (dependend tasks)

### Define a task

### declaring task inputs and outputs

- gradle determines if a task is up to date by comparing a snapshot of a task's
  inputs and outputs between two builds
