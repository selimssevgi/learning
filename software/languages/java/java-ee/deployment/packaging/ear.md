# ear

- java ee module system is based on the ear file

- is the top-level module containing all other java ee modules for deployment

- the file structure of the ear module:

```shell
META-INF/application.xml
project-ejb.jar
project-war.jar
project-client.jar
lib/project-commons.jar # application server class loaders load all of these jars
```

```xml
<application>
  <module>
    <ejb>project-ejb.jar</ejb>
  </module>
  <module>
    <web-uri>project.war</web-uri>
    <context-root>project</context-root>
  </module>
</application>
```
