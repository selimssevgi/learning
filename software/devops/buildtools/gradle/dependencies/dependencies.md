# Dependencies

- dependencies are grouped by configurations
- one of the configurations that the java plugin introduces is *compile*


```shell
# listing dependencies
gradle -q dependencies
```

## Declare Dependencies

- Add a source for 3rd party libraries

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
  testCompile "junit:junit:4.12"
}
```
