# jndi properties

- another way to do the configuration

- put the file in your CLASSPATH

- same value pairs of Properties object into *jndi.properties*


```java
// when you have jndi.properties file
Context context = new InitialContext();
```

- most application servers will make a default jndi.properties automatically
  available in the CLASSPATH

## common ones

```properties
# the name of the factory class that will be used to create the context
java.naming.factory.initial = "full-class-name"

java.naming.provider.url = "url for he jndi service provider"

java.naming.security.principal = "username"
java.naming.security.credentials = "password"
```
