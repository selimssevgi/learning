# Gradle Build File

## Adding Plugins 

- Adding java plugin. Brings new tasks like building the project, creating
  JavaDoc, and running tests.


```groovy
appy plugin: 'java'
appy plugin: 'application'

mainClassName = 'hello.HelloWorld'
```

### Runnable
To make the code runnable, use 'application' plugin.

```groovy
appy plugin: 'application'

mainClassName = 'hello.HelloWorld'
```

```shell
$ gradle run
```

## Declare Dependencies

- Add a source for 3rd party libraries:

```groovy
repositories {
  mavenCentral()
}
```

The repositories block indicates that the build should resolve its dependencies
from the Maven Cental repository.

```groovy
dependencies {
  compile "joda-time:joda-time:2.2"  
  testCompile: "junit:junit:4.12"
}
```

## Name JAR artifact
jar block specifies how the JAR file will be named. In the following case, it
will render 'gs-gradle-0.1.0.jar'.

```groovy
jar {
  baseName = 'gs-gradle'
  version = '0.1.0'
}
```
