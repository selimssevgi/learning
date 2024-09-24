# using and configuring repositories

- RepositoryHandler, *repositories* configuration block

- gradle doesnt prefer any of the repository types, it is up to the project


```groovy
repositories {
  mavenCentral()  
  // or
  mavenLocal()
  // or a custom
  maven {
    name 'custom maven repository'  
    url 'https://url'
  }
}
```

## repository types

- maven repository
  - local, remote, or preconfigured maven central

- ivy repository
  - local or remote

- flat directory repository
  - without metadata support
