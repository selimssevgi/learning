# java plugin

- provides six configurations:
  - compile, runtime
  - testCompile, testRuntime
  - archives, default

```groovy
apply plugin: 'java'

version = 0.1 // now instead of app.jar, it will be app-0.1.jar
sourceCompativility = 1.6

jar {
  manifest {
    attributes 'Main-Class'  : 'com.selimssevgi.App'
  }  
}
```
