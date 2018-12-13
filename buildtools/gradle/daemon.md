# Gradle Daemon

### gradle.properties

```shell
vim ~/.gradle/gradle.properties
org.gradle.deamon=true
```

```shell
gradle --no-deamon clean build
```

### GRADLE_OPTS

### With Flag

```shell
gradle --deamon build
gradle --deamon clean
gradle --deamon build
```

- !! Check if is not outdated!

- Each time gradle is invoked, a new process is started.
- Gradle classes and libraries are loaded, and build is executed.
- Loading classes and libraries take time.
- Execution time can be reduced if a JVM, Gradle classes, libraries, are not loaded each time.


- --daemon command-line option starts a new Java process and loads Gradle clases, libs.
- First execution takes time.
- The next execution with --daemon option takes almost no time.


- Configuration for daemon is often put into a GRADLE_OPTS env variable.
- So, the flag is not needed on all calls.
