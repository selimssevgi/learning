# jetty plugin

- extends war plugin

- provides tasks for deploying a web app to the embedded container

- war plugin exposes all the information, it can be accessed at runtiem by jetty plugin

```groovy
apply plugin: 'jetty' // src/main/webapp

jettyRun {
  httpPort = 9090  
  contextPath = 'todo'
}
```
