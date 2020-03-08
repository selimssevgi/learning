# gradle dependency resolution

- default behavior is to pick the newest version
  - even if a lower version has been declared locally
  - newer version even if pulled transitively wins

- in maven locally defined version will always win

```shell
dependencies {
   compile("org.springframework.data:spring-data-hadoop:2.0.0.RELEASE")
   compile("org.springframework:spring-tx:3.2.3.RELEASE")
   // will select org.springframework:spring-tx:4.0.5.RELEASE
}
```

## conflict

- gradle wont inform you in case of version conflict by default
- we dont want to constantly check dependency report
- change the default resolution strategy to fail the build in case of conflict

```groovy
configurations.cargo.resolutionStrategy {
  failOnVersionConflict()
}
```

## force

* one way would be to use force on the dependency itself:

```shell
dependencies {
  compile("org.springframework.data:spring-data-hadoop:2.0.0.RELEASE")
  compile("org.springframework:spring-tx:3.2.3.RELEASE") {
    force = true
  }
}

configurations.cargo.resolutionStrategy {
  force 'org.project:project:version'
}
```

- this acts similar to maven way


## exclude (all)

- gradle doesnt allow you to exclude only a specific version of a dep, so the
  *version* attribute isnt available

```groovy
dependencies {
  cargo('org.codehaus.cargo:cargo-ant:1.3.1') {
    exclude group: 'xml-apis', module: 'xml-apis'
  }
  cargo 'xml-apis:xml-apis:2.0.2'
}
```

```groovy
dependencies {
  cargo('org.codehaus.cargo:cargo-ant:1.3.1') {
    transitive = false
  }
  // selectively declare required dependencies
}
```

## dynamic version


```groovy
dependencies {
  cargo 'org.codehaus.cargo:cargo-ant:1.+'  
}
```
