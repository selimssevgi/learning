# What is an Aspect?

- Aspect implements cross cutting concern

- Get rid of boiler plate code

- Aspect = Pointcut + Advice

- Pointcut: where the Aspect is applied

- Advice: what code is executed

```java
public void doSomething() {
  final String METHOD_NAME = "doSomething"  ;
  log.trace("Entering {}#{}", CLASS_NAME, METHOD_NAME);
  TransactionStatus tx =
    transactionManager.getTransaction(new DefaultTransactionDefinition());

  try {
    // business logic  
  } catch (RuntimeException ex) {
    log.error("exception in {}#{}", CLASS_NAME, METHOD_NAME, ex);
    tx.setRollbackOnly();
    throw ex;
  } finally {
    transactionManager.commit(tx);
    log.trace("exiting {}#{}", CLASS_NAME, METHOD_NAME);
  }
}
```

- The first two lines of the method is about tracing, we can trace all methods
  this way

- Can we move this Aspect into a central place?

```java
@Component
@Aspect
@Slf4j
public class TracingAspect {

  @Before(
    // "execution(void doSomething())" // Point expression for a single method
    // execution(<returnType> <methodName>(<parameters>))
    "execution(* * (..))" // for all methods

  )
  public void entering(JoinPoint joinPoint) {
    log.trace("entering method" +
    joinPoint.getStaticPart().getSignature().toString());
  }
}
```

- Advice: What is executed
- Before Advice: Before the original code
