# how ejb names are assigned

- to make ejb jndi lookup portable across all jee servers, jndi names has been standardized


```shell
java:<namespace>/[app-name]/<module-name>/<bean-name>[!fully-qualified-interface-name]
```

## namespace

- *java:comp* is mostly used prior to jee6

- *java:module* ejb-jar file is a module name, as is a war file

- *java:app* are scoped per application
  - all wars and ejbs deployed from the ear should share this namespace

- *java:global* by all components in all modules in all applications

## [app-name]

- is optional and only present if the ejbs are deployed to the server inside of an of ear

- the default value for [app-name] is the ear file without .ear extension

- application.xml is able to override this default value

## module-name

- is required and always present

- depends on how the modules containing the ejbs are deployed

- default name can be overridden using the module-name element of META-INF/ejb-jar.xml configuraiton

## bean-name

- is required and will always be present

- for ejbs unqualified name of the bean class
