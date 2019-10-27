# multi projects

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
