# war plugin

- extends the java plugin by adding:
  - conventions for web application development
  - support for assembling WAR files

- when you have war plugin, you dont have to apply jar plugin again
  - now gradle build will use "task war" instead of "task jar"

- by applying war, your project becomes aware of a src directory for web app
  files and knows how to assemble a war instead of a jar

```groovy
apply plugin: 'war' // src/main/webapp
```

* the war plugin introduces two new dependency configurations
  - providedCompile
  - runtime

* on build 3 main things happen:

1. webapp content copied as it is
2. compiled classes end up in WEB-INF/classes
3. runtime libraries in WEB-INF/lib
