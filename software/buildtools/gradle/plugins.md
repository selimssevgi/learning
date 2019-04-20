# Gradle Plugins

## Adding Plugins

- Brings new tasks like building the project, creating JavaDoc, and running tests.

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
