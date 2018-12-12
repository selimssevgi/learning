# Class Loading

- (there are notes in jvm directory too)

- Web servers(tomcat) loads and executes new code while running

- outside of java, this kind of flexibility is partially achieved using
  dynamically linked libraries. However, because dynamically linked libraries
  are an operating system primitive, they force you to work outside your
  programming language. This produces applications that are platform dependent.
  In addition, as the name implies, a dynamically linked library has the
  granularity of a library rather than an individual class.

- *Dynamic loading*  is te process by which the JVM create classes from
  bytecodes at runtime.

## Example

- we are going to build an application
- different environment requires different database access code

- CustomerDatabase: it is an facade interface for all db operations
- createDbFacade: is a factory method to create the facade

- we want to have the ability to create different CustomerDatabase
  implementations even after the application is shipped.


```java
public synchronized CustomerDatabase createDbFacade() {
  if (customerDatabase != null) {
    String customerDbImplClass =
    this.props.getProperty("db.class", "ch3.DefaultCd");
    try {
      Class<?> aClass = Class.forName(customerDbImplClass);
      customerDatabase = (CustomerDatabase) aClass.newInstance();
    } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
      e.printStackTrace();
    }
  }
  return customerDatabase;
}
```

- here we can write, compile a different impl of CustomerDatabase and then provide that name through properties.
- however, to change the implementation, we will have to stop and start the application.

### Combining benefits of delegation and reflection

- delegation is useful because it allows an object to change behavior at runtime

- if the delegation is replaced, the behavior is changed as well

- without reflective mechanisms, the number of delegates is limited to only the
  set of classes that are included in the system in compile time.

**NOTE:** Dynamic loading and reflective construction is not the only technique
for dynamically introducing new behavior: see proxies
