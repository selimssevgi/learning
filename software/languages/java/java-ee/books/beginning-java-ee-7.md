# Beginning Java EE 7

* Enterprise layer
  - CDI 1.1
  - Bean Validation 1.1
  - EJB 3.2
  - JPA 2.1

* Web tier
  - Servlet 3.1
  - JSF 2.2
  - Expression Language 3.0

* Interoperability
  - JAX-WS 2.3
  - JAX-RS 2.0

## Chapter 1 - Java EE7 at a Glance

- Just as Java SE provides an API to handle collections, Java EE provides a
  standard way to handle transactions with JTA, JMS, JPA...

- Java EE is a set of specifications implemented by different containers

- Containers are Java EE runtime environments that provide certain services to
  the components they host such as life-cycle management, DI, concurrency etc

### Components

- Java EE runtime environment defines four types of components:

1. "Applets" are GUI apps that are executed in a browser

2. "Applications" are programs that are executed on a client

3. "Web applications" (made of servlets, servlet filters, web event listeners,
   JSP, JSF pages) are executed in a web container and respond to HTTP request from web clients

4. "Enterprise applications" (made of EJB, JMS, JTA, async calls, timer service)
   are executed in an EJB container

### Containers

- Containers hide technical complexity and enhance portability

1. "Applet container"

2. "Application client container(ACC)"

3. "Web container"

4. "EJB container"

### Services

- JTA, JPA, Validation, JMS
- Java Naming and Directory Interface (JNDI)
- JavaMail
- Java Authentication and Authorization Service (JAAS)
- Web services
- DI
- Java Management Extensions (JMX)

### Network Protocals

- HTTP, HTTPs
- RMI-IIOP: RMI with CORBA

### Packagin

- JAR: application client module, contains Java classes ando other resources

- WAR: Web Archive

- EAR: an enterprise module can contain zero or more web application modules,
  zero or more EJB modules, and other common or external libs

### Annotations and Deployment Descriptors

- Annotations can be used since Java EE5
- XML files are used for deployment descriptors
- Annotations are easy but require recompiling in case of change in source code
- XML takes precedence over annotations

*NOTE:* In today's development annotations are preferred over deployment
descriptors in Java EE. That is because there is a trend to replace a dual
language programming (Java + XML) with only one (Java). This is also true
because it's easy to analyze and prototype an application, when everytinh is in one place.

- Java EE uses the notion of Programming by Exception (a.k.a Convention over
  Configuration) so that most of the common behavior doesn't need to be declared with metadata

- Programming metadata is the exception, the container takes care of the defaults

### Standards

- Java EE is called an 'umbrella specification', bundles together a number of other specification

- use open source that implements standard and be portable

## Chapter 2 - Context and Dependency Injection

- Java SE has JavaBeans
- Java EE has Enterprise JavaBeans

- JavaBeans are just POJOs that follow certain patterns (naming convention)

- Managed Beans are container-managed objects that support only a small set of
  basic services: resource injection, life-cycle management, and interception

- Enterprise JB can be seen as a Managed Bean with extra services
- A servlet can also be seen as a Managed Bean with exxhtra services

### Life-Cycle Management

- POJO: being created by using 'new' keyword, freed by GC

- It is not allowed to use 'new' to create CDI Bean inside container
- Container is responsible for managing the life cycle of the bean

### Scopes and Context

- CDI Beans may be stateful and are contexual
- They live in a well-defined scope
- CDI comes with predefined scopes: request, session, application, and conversation scopes

- Client does not control the life cycle of the instance by explicitly creating
  and destroying it; the container does it according to the scope


### Loose Coupling and Strong Typing

- Interceptors are a very powerful way to decouple technical concerns from business logic
- CDI never relies on String-based identifiers to determine how objects fit together
- CDI uses strongly typed annotations (qualifiers, stereotypes, and interceptor bindings) to wire beans together


* The aim of CDI was to fill all the gaps:

1. Give more cohesion to the platform
2. Knit together the web tier and the transactional tier
3. Turn DI into a first-class citizen
4. Have the ability to add new extension easily

### Injection Points

- The @Inject defines an injection point that is injected during bean instantiation

- Injection can occur via three different mechanisms: property, setter, or constructor

```java
@Inject
private NumberGenerator numberGenerator;
```
- Notice that it isn't necessary to create a getter and a setter method on an attribute to use injection.

- CDI can access an injected field directly(even if it's private)


```java
@Inject
public BookService(NumberGenerator numberGenerator) {
   this.numberGenerator = numberGenerator;
}
```

- the rule is that you cna only have one constructor injection point

- there is only one bean constructor allowed so that the container can do its
  work and inject the right references

### Default Injection

- if there is only one implementation, CDI will then be able to inject it simply
  by using @Inject on its own

- This is termed 'default injection'

- Sometimes you have to choose between several implementation, that's when you
  need to use qualifiers

### Qualifiers

- At system initialization time, the container must validate that exactly one
  bean satisfying each injection point exists

- No implementation available: "unsatisfied dependency"
- One implementation available: works using the @Default qualifier
- More than one available: "ambigous dependency"

### Qualifiers with Members

- Each time you need to choose between implementations, you create a qualifier
  annotation, @TwoDigits, @EightDigits, @TenDigits, @ThirteenDigits

- One way to avoid the multiplication of annotations is to use members
