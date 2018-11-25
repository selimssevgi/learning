# Classpath

- this is where jvm looks for classes

```shell
java classes/com.selimssevgi.Main.class
Error: Could not find or load main class
```

* Set it globally

```shell
set CLASSPATH=classes
java classes/com.selimssevgi.Main.class
it works
```

- settings classpath globally is not a good idea

* Set it when running java application

```shell
java --classpath classes:otherclasses com.selimssevgi.Main.class
it works
```
