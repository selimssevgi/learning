# testing with gradle

- src/test/[java, resources]

- output directory: build/classes/test

- results: build/test-results

- reports: build/reports/test

- *gradle jar* skips runnning tests


```shell
gradle test -i # shows the failed assertion

gradle -Dtest.single=**/*Spec test
```

- gradle runs tests in a forked JVM process

```groovy
test {
  systemProperty 'items', '20'
  minHeapSize = '128m'
  maxHeapSize = '256m'
  jvmArgs '-XX:MaxPermSize=128m'

  testLogging {
    showStandardStreams = true // sout, serr
    exceptionFormat 'full' // full exception stack trace
  }
}
```
