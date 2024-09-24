# init.d

- you could apply the plugin to every project individually?

- initialization scripts are run before any of your build script logic has been evaluated and executed

- $GRADLE_HOME/init.d/build-announcements.gradle

- gradle will executes every initialization script it finds under init.d as long
  as the file extension matches .gradle


```groovy
gradle.projectsLoaded { Gradle gradle ->
  gradle.rootProject {
    apply plugin: 'build-announcements'  
  }
 }
```
