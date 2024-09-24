# gradle dependency management

- gradle rolls its own dependency management implementation

- apache ivy used in ant projects
- maven has its own dependency management solution

## api

- every project owns a container of class ConfigurationContainer

- grouping dependencies by configuration is a similar concept to java packages


```groovy
configurations {
  cargo {
    description = 'classpath for Cargo ant tasks'  
    visible = false
  }  
}
```

- every gradle project has an instance of a dependency handler: DependencyHandler
