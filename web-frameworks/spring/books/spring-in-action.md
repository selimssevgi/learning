# Spring in Action 4th Edition

# Chapter 1 - Springing into action

- Spring uses the words 'bean' and 'JavaBean' liberally when referring to application components

- Spring components dont have to follow the JavaBeans specification to the letter

- A Spring component can be any type of POJO


* Java simplifies Java development: four key strategies

1. Lightweight and minimally invasive development with POJOs
2. Loose coupling through DI and interface orientation
3. Declarative programming through aspects and common conventions
4. Eliminating boilerplate code with aspects and templates


- POJO: frameworks lock you in by forcing you to extend one of their classes or implement one of their interfaces

- One of the ways Spring empowers POJOs is by assembling them using DI

## Injecting Dependencies

- Traditionally, each object is responsible for obtaining its own references to
  the objects it collaborates with (its dependencies)

- This approach can lead to highly coupled and hard-to-test code


```java
public DamselRescuingKnight() {
   this.quest = new RescueDamselQuest(); // tightly coupled
}
```

- Coupling is a two-headed beast

1. tightly coupled code is diffucult to test, difficult to reuse, and difficult to understand
2. coupling is necessary but should be carefully managed

- With DI, objects are given their dependencies at creation time by some third
  party that coordinates each object in the system


```java
public BraveKnight(Quest quest) {
   this.quest = quest;  // injected
}
```

- BraveKnight is not coupled to any specific implementation of Quest

- The key benefit of DI -- loose coupling

- if an object only knows about its deendencies by their interface (not by their
  implementation or how they're instantiated), then the dependency can be
  swapped out with a different implementation without the depending object
  knowing the difference

- One of the most common ways a dependency is swapped out is with a mock implementation during testing

- The act of creating associations between application components is commonly
  referred to as *wiring*.

### Containing your beans

- In a Spring-based application, your application objects live in Spring container

- the container creates the objects wires, them together, configures them, and
  manages their complete lifecycle from 'new' to 'finalize()'

- The container is at the core of the Spring Framework

- Spring's container uses DI to manage the components that make up an application

- There is no single Spring container, they can be categorized in two:

1. org.springframework.beans.factory.BeanFactory interface (low level, simplest form)
2. org.springframework.context.ApplicationContext interface build on BeanFactory

### Working with an application context

- Spring comes with several flavors of application context

* AnnotationConfigApplicationContext
  - loads a Spring application context from one or more Java-based configuration classes

* AnnotationConfigWebApplicationContext
  - loads a Spring web application context from one or more Java-based configuration classes

* ClassPathXmlApplicationContext
  - loads a context definition from one or more XML files

* FileSystemXmlApplicationContext
  - loads a context definition from one or more XML files in the filesystem

* XmlWebApplicationContext
  - loads context definitions from or more XML files contained in a web application


```java
ApplicationContext context = new
  FileSystemXmlApplicationContext("c:/knight.xml");

ApplicationContext context = new
  ClassPathXmlApplicationContext("knight.xml");

ApplicationContext context = new AnnotationConfigApplicationContext(
  com.springinaction.knights.config.KnightConfig.class);
```

### A bean's life

1. instantiate
2. populate properties
3. BeanNameAware's setBeanName()
4. BeanFactoryAware's setBeanFactory()
5. ApplicationContextAware's setApplicationContext()
6. Pre-initialization BeanPostProcessors
7. InitializingBean's afterPropertiesSet()
8. Call custom init-method
9. Post-initialization BeanPostProcessors

* Bean is ready to use
* Container is shutdown

10. DisposableBean's destroy()
11. Call custom destroy-method

* In more detail:

1. Spring instantiates the bean
2. Spring injects values and bean references into the bean's properties
3. If the bean implements BeanNameAware, Spring passes the bean's ID to the setBeanName() method
4. If the bean implements BeanFactoryAware, Spring calls the setBeanFactory(), passing in the bean factory itself
5. If the bean implements ApplicationContextAware, Spring calls the setApplicationContext()
6. if the bean implements the BeanPostProcessor Spring calls its postProcessBeforeInitialization()
7. If the bean implements InitializingBean, Spring calls its afterPropertiesSet()
8. if the bean implements BeanPostProcessor, Spring call postProcessAfterInitialization()
9. at this point, the bean is ready to be used by the application and remains in
   the application context until the application context is destroyed

10. If bean implements DisposableBean interface, Spring calls it destroy()

## Chapter 2 - Wiring Beans

- a movie is created by many people, on the scene and behind the scene
- a bean by itself it is not useful

### Exploring Spring's configuration options

- Spring container is responsible for:
  - creating the bean in your application
  - coordinating the relationship between those objects via DI

- Developer is responsible for telling: 
  - Spring which beans to create
  - how to wirte them together

- Spring offers three primary wiring mechanisms:

1. Explicit configuration in XML
2. Explicit configuration in Java
3. Implicit bean discovery and automatic wiring

- if possible, automatic bean discovery
- Prefer Java Config over XML when no access to source code, more type-safe

### Automatically wiring beans

- Spring attacks automatic wiring from two angles:

1. Component Scanning
   - automatically discovers beans to be created in the aplication context

2. Autowiring
   - Spring automatically satisfies bean dependencies
