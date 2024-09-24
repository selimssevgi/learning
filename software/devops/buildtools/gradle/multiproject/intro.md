# multiprojects

- *root project* coordinates building the *subprojects* and can define common or
  specific behavior for them.

## settings.gradle

- the declaration of subprojects in a multiproject build is done via *settings.gradle*

- before gradle assembles the build, it creates an instance of SEttings.

## allprojects or subprojects

- properties defined in a project are automatically inherited by its subprojects

-


































- settings.gradle
  - top level
  - list of all the projects in the build

- build.gradle
  - top level
  - defines project wide build functionality


```groovy
//settings.gradle
include 'repository'
include 'service'
```

```groovy
//build.gradle
allproject {
  apply plugin: 'java'
}

project('repository') {}
project('service') {
  dependencies {
    compile project('repository')
  }
}
```
