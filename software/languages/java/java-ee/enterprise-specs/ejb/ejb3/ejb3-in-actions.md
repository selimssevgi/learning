# ejb3 in action

- ejb recognizes two specific types of components:
  - session beans
    - stateless
    - stateful
    - singleton
  - message-driven beans

- mdb is different in one important way:
  - clients never invoke mdb methods directly
  - mdb is triggered by messages sent to a messaging server

- ejb has two closely related specifications:
  - jpa
  - cdi

- jpa is not just a solution for server-side applications

- persistence is a problem that even a standalone desktop app has to solve
  - this drove the decision to make jpa 2 a cleanly separated api in its own
    right that can be run outside an ejb3 container

- much like jdbc, jpa is intended to be a general-purpose persistence solution for any java app

- to run a simple java class, you need a JVM(manages memory)
- to execute session beans and mdbs you need an ejb container(provides services)

- the task of putting an ejb3 component inside a container is called *deployment*

- ejb3.2 lite does is remove support for ejb2 backward compatibility

- ejb3.2 lite also doesnt support for mdbs and remoting


```java
@Stateless
public class HelloEjb {
  public String sayHello(String name) {
    return "Hello " + name + "welcome to ejb 3.1";
  }
}
```

- pojo + @annotations = ejb

- intelligent defaults:
  - thread-safe
  - pooled
  - transactional

- explicit configuration:
  - scheduling
  - async processing
  - remote
  - web service

### DI vs JNDI lookup

- ejb3 was reengineered from group up for DI
- you can inject ejbs into other jee components
- inject jee components into ejbs

- @EJB transparently "injects" the ejb into the annotated variable
- @EJB reads the type and name of ejb and looks it up from JNDI under the hood

- all ejb components are automatically registered with JNDI while being deployed

```java
// DI
@EJB
private HelloComponent helloComponent;
```

```java
void lookUpJndi() throws NamingException {
  Context context = new InitialContext();
  HelloComponent helloComponent =
    ((HelloComponent)
     context.lookup("java:module/HelloComponent"));
  helloComponent.sayHello("Selim");
}
```

### cdi vs ejb injection

- ejb-style injection predates cdi

- cdi can be used to inject almost anything
- ejb injection can only be used with objects stored in jndi(ejb, ejb context)

- cdi is far more type-safe than ejb
- cdi is superset of ejb injection

- cdi can retrieve an ejb by type, it doesnt work with remote ejbs
