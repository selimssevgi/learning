# Spring AOP

- Spring's support for AOP comes in four styles:

1. classic Spring proxy-based AOP (bulky and overcomplicated)
2. pure-POJO aspects (requires XML configuration)
3. @AspectJ annotation-driven aspects
4. injected AspectJ aspects (available in all version of Spring)

- Spring AOP is built around dynamic proxies.
- consequently, is limited to method interception.

- All the advice you write in Spring is written in a standard Java class

- AspectJ comes as a language extension to Java (also there is annotation-based support)

### spring advices objects at runtime

- in spring, aspects are woven into Spring-managed beans at runtime by wrapping them with a proxy class

- spring doesn't create a proxied object until that proxied bean is needed by the application

- the proxied objects will be created when it loads all the beans from the BeanFactory

- Spring creates proxies at runtime, you don't need a special compiler to weave
  aspects in Spring's AOP

### spring only support method join points

- multiple join-point models are available through various AOP implementations

- because it is based on dynamic proxies, spring only supports method join points

- some other AOP frameworks, such as AspectJ and JBoss, provide field and
  constructor join-points in addition to method pointcuts

- spring's lack of field pointcuts prevents you from creating very fine-grained
  advice, such as intercepting updates to an object's field. And without
  constructor pointcuts, there is no way to apply advice when a bean is instantiated


### pointcuts

- in spring-aop, pointcuts are defined using AspectJ's pointcut expression language

- spring only supports a subset of the pointcut designators available in
  AspectJ. spring-aop is proxy-based, and certain pointcut expression aren't
  relevant to proxy-based AOP.

```shell
args()      -- type matching
@args()     -- arguments annotated
execution() -- method execution
this()      --
target()
@target()
within()
@within()
@annotation
```

- execution() designator is the only one that actually performs matches
- the other designators are used to limit those matches.

```shell
execution(* concert.Performance.perform(..)))

execution(* concert.Performance.perform(..)) && within(concert.*))

execution(* concert.Performance.perform(..)) and bean('woodstock'))

execution(* concert.Performance.perform(..)) and !bean('woodstock'))
```

### define and use an proxy

```java
@Aspect
public class Audience {
  @Pointcut("execution(** concert.Performance.perform(..))")
  public void performance() {}

  @Before("performance()")
  public void silenceCellPhones() {
    sout("silencing cell phones");
  }
}
```

```java
@Configuration
@EnableAspectJAutoProxy
public class ConcertConfig {
  @Bean
  public Audience audience() {
    return new Audience();
  }
}
```

- it is important to understand that Spring's AspectJ auto-proxying only uses
  @AspectJ annotations as a guide for creating proxy-based aspects.

### handling parameter in advice

```java
@Pointcut("execution(* soundsytem.CompactDisc.playTrack(int) && args(trackNumber))")
public void trackPlayed(int trackNumber){ }

@Before("trackPlayed(trackNumber)")
public  void countTrack(int trackNumber) {
  // logic
}
```

- args(trackNumber) indicates that any int argument that is passed into the
  execution of playTrack() should also be passed into the advice.

- the parameter name, trackNumber, also matches the parameter in the pointcut method signature.
