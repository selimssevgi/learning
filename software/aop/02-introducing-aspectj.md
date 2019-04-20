# Introducing AspectJ

- An aspect is a unit of modularization in AOP, much like a class is a unit of
  modularization in OOP.

- A pointcut selects interesting points of execution in a system, called 'join
  points'.

- And advice defines the code to execute upon reaching join points selected by
  the associated pointcut.

- AspectJ offers two syntax choices: traditional and @AspectJ

## Common crosscutting constructs

- Aspectj supports a few common constructs consisting of the join point, the
  pointcut, and the aspect.

** Join Point

- Join points are the places where the crosscutting actions take place.

** Pointcut

- A pointcut is a program construct that selects join points and collects
  context at those points.

```shell
# any public method in the system
execution(public * *.*(..))
```

### Dynamic crosscutting construct: advice

- AspectJ's dynamic crosscutting support comes in the form of advice.

- Advice is the code executed at a join point selected by a pointcut.

### Static crosscutting constructs

- Static crosscutting comes in the form of inter-type and weave-time declarations.
** Inter-type declarations

- ITD is a static crosscutting construct that alters the static structure of the
  classes, interfaces, and aspects in the system.

- For example, you can add a method or field to a class, or declare a type to
  implement an interface.

** Weave-time declaration

- Allows you to add weave-time warnings and errors when detecting certain usage
  patterns.

- Often, weaving is performed during compilation; therefore, these warnings and
  errors are issued when you compile the classes.

## AspectJ Alternative Syntax

- The traditional syntax requires the use of special ajc compiler early in the
  development process to compile aspects.

- The alternative @AspectJ syntax extends the language using new annotation
  facility in Java 5. The main advantage of this syntax style is that you can
  compile your code using a plain Java compiler.

- The disadvantage of @AspectJ is its verbosity in expressing the same
  constructs and its limitations in expressing certain constructs, especially in
  the static crosscutting category.


```java
@Aspect
public class SecurityAspect {
  private Authenticator authenticator = new Authenticator();

  @Pointcut("execution(* aopia.ch1.MessageCommunicator.deliver(..))")
  public void secureAccess() {}

  @Before("secureAccess()")
  public void secure() {
    System.out.println("Checking and authenticating user...");
    authenticator.authenticate();
  }
}
```

## Weaving mechanisms

- A weaver needs to weave together classes and aspects so that advice gets
  executed, ITD affect the static structure, and weave-time declarations produce
  warnings and errors.

- AspectJ offers three weaving methods:

1. Source weaving
2. Binary weaving
3. Load-time weaving

- Regardless of the weaving model used, the resulting execution of the system is
  identical. The weaving mechanism is also orthogonal to the AspectJ syntax
  used; any combination of weaving mechanism and AspectJ syntax will produce
  identical results.

### Source Weaving

- The weaver is part of the compiler.

- The input to the weaver consists of classes and aspects in source-code form.

- The weaver, which works in a manner similar to a compiler, processes the
  source and produces woven byte code.

- Essentially, when used in this manner, ajc replaces javac.

- Unlike javac, ajc requires all sources be presented together if you want woven
  byte code.

- If you present sources separately, the resulting byte code can be used as
  input for binary weaving or load-time weaving.

### Binary weaving

- Input to the weaver is in byte-code form.

- The input byte code is compiled separately using javac or ajc.

- Binary weaver is more like a linker. A linker takes object files and libraries
  compiled using a compiler as input to produce an executable or another
  library, the weaver takes files containing byte code as input and produces
  wowen byte code.

```shell
# STEP 1: compile java class
javac -d classes MessageCommunicator.java
# when executing class output, no sign of aspects

# STEP 2: compile aspect
ajc -d aspects SecurityAspect.java

java -classpath classes:aspects Main
# no sign of aspect

# STEP 3: weaving the aspect
ajc -inpath classes:aspect -aspectpath aspects -d woven
```

- Can weave already compiled jar files.

### Load-time weaving

-  Weaver takes input in the form of binary classes and aspects, as well as
   aspects and configuration defined in XML format.

- A load-time agent can take many forms: JVM Tools Interface agent, a
  classloader, a VM and application server-specific class preprocessor, which
  weaves the classes as they're loaded into the VM.

```shell
# an aop.xml configuration file
java -cp classes:aspects -javaagent:$ASPECTJ_HOME/lib/aspectjweaver.jar Main
```


** Spring-driven LTW

Spring 2.5 introduces Spring-driven LTW, an alternative way to configure AspectJ
LTW for Spring applications. With it, for certain application and web servers,
you can avoid modifying the launch script (-javaagent); instead, you modify the
application context to express the desire to use LTW, and Spring handles the rest.

## Spring AspectJ integration

- It uses the proxy design pattern to intercept the execution of methods on the
  target object. Due to the use proxies, it exposes method execution join points
  only for objects created by the Spring container (beans). But it is a
  pragmatic solution for its target applications.

- You can use the aspects written using @AspectJ in a Spring application without
  needing the AspectJ weaver.
