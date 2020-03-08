# publishing


```shell
mkdir project-name
cd $_
gradle init --type java-library
```


```groovy
// build.gradle

id: 'maven-publish'

group: 'com.selimssevgi'
version: "0.0.1"
sourceCompatibility = "1.8"
targetCompatibility = "1.8"
```

```shell
# com.selimssevgi:project-name:0.0.1-SNAPSHOT
gradle publishToMavenLocal
```

- find the installed artifact at *$HOME/.m2/repository/*
