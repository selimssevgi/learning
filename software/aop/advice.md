# Advice



## Types of Advices


```shell
> Before Advice: 
METHOD
> After Advice: executed after the original method executed
> After Throwing: only executed if any exception is thrown
> After Returning: only executed if method returns successfuly

> Around Advice: Before & After
```

### Before Advice

- Executed before the original method

- Exception prevents method to be executed

- Exception in Before Advice is propagated to the caller

```java
@Before(
  "execution(void doSomething())"
)
public void entering() {
  log.trace("entering method");
}
```

### After Advice

- Executed after the method is executed

- Exception could have been thrown, or executed successfully

```java
@After(
  "execution(* *(..))"
)
public void entering() {
  log.trace("exiting method");
}
```

### After Throwing

- Executed if method threw an exception

- Exception will be propagated to the caller

- Thrown exception can be accessed (type-safe manner)

```java
@AfterThrowing(
  "execution(* *(..))"
)
public void logException() {
  log.error("Exception");
}

@AfterThrowing(
  pointcut = "execution(* *(..))",
  throwing = "ex"
)
public void logException(RuntimeException ex) {
  log.error("Exception", ex);
}
```

### After Returning

- Executed if the method successfully

```java
// only interested the method that return type is String
@AfterReturning(
  pointcut = "execution(* *(..))",
  returning = "string"
)
public void entering(String string) {
  log.trace("result " + string);
}
```

### Around Method

- Wraps around the method

- Can prevent the original method from being called, without throwing an
  exception like the Before Advice

- Only advice that can catch exceptions
- Only advice that can modify return value

- Current method call is passed to the Advice
- ProcedingJoinPoint
- Can be executed or skipped

- Most powerful advice

- Around is powerful but complex

```java
@Around(
  "execution(* *(..))"
)
public void trace(ProceedingJoinPoint proceedingJP) throws Throwable {
  String methodInformation = 
    proceedingJP.getStaticPart().getSignature().toString();
  logger.trace("Entering " + methodInformation);

  try {
    return proceedingJP.proceed();  
  } catch (Throwable ex) {
     logger.error("Exception in {}", methodInformation, ex);
     throw ex;
  } finally {
    logger.trace("exciting " + methodInformation);
  }
}
```
