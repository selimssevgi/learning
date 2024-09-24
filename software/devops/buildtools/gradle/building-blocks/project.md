# projects

- when starting the build process:
  - gradle instantiates org.gradle.api.Project based on the configuration in build.gradle
  - and makes it implicitly available through the *project* variable

- not required to use the project variable when accessing properties and methods
  - it is assummed you mean project instance


```groovy
setDescription("myProject")
println "description of the project $name: " + project.description
```
