# Gradle Task

- Code that Gradle executes

- Has a lifecycle

- Has properties

- Has actions

- Has dependencies (dependend tasks)

### Define a task

- gradle tasks --all

```groovy
task Task6 {
  description "This is task 6 description"
  dependsOn Task3
  doLast {
    println "This is doLast for task6"
  }
  doFirst {
    println "This is doFirst for task6"
  }
}
```

### Run a task

- gradle MyTask

## Task Phases

- initialization phase -- used to configure multi project builds

- configuration phase -- executes code in the task that's not the action

- execution phase -- execute the task actions (doLast, doFirst)
