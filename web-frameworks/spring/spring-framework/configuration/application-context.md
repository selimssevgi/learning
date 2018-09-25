# Application Context

- an application context loads bean definitions and wires them together

- it is fully responsible for the creation of and wiring of the objects that make up the application

- Spring comes with several implementations of its application context

- each primarily differing only in how it loads its configuration


- ClassPathXmlApplicationContext
- AnnotationConfigApplicationContext


```java
public class KnightMain {
  public static void main(String[] args) throws Exception {
    ClassPathXmlApplicationContext context =
      new ClassPathXmlApplicationContext("META-INF/spring/knight.xml");

    Knight knight = context.getBean(Knight.class);
    knight.embarkOnQuest();
    context.close();
  }
}
```
