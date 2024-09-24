# simple task

```groovy
task Task6 {
  group = "versioning"
  description "This is task 6 description"
  dependsOn Task3
  doLast {
    println "This is doLast for task6"
    logger.quiet "version: $version"
  }
  doFirst {
    println "This is doFirst for task6"
  }
}

Task6.doFirst { println "if task6 was hidden, and wanted to add an action" }
```
