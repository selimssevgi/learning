# Modifying behavior with dynamic crosscutting
- Dynamic crosscutting weaving rules consist of two parts:

1. Advice (what to do)
2. Pointcuts (when to apply the advice)

## Advice Classification

- AspectJ offers three kinds of advice:

1. Before advice
2. After advice
   1. After (finally) regardless of the outcome
   2. After returning executes after successfil execution (without an exception)
   3. After throwing executes after failed execution (throwing exception)
3. Around advice (zero or more times), has a return value

### Advice syntax

- Advice declaration -- specifies if the advice will run before, after or around
  the join points

- Pointcut specification -- specifies which join points will be advised

- Advice body -- contains the code to execute upon reaching a selected join point

## Before Advice

- If you throw an exception in the before advice, the advised operation won't execute

- Before advice is typically used for performing operation tasks, such as policy
  enforcement, tracing, and security.

## After Advice

- @AfterReturning: if the advised method throws an exception, the advice doesn't execute

- @AfterReturning: collecs the return type, you can use the collected return
  object in advice. Although the returned object can be modified(remove an
  element from a collection), there is no way to return a new object. see @Around

- @AfterThrowing, unless itself throws an exception, the original exception
  processing continues up the call stack. Specially, after throwing advice can't
  swallow an exception, and the caller of the join point receives the exception
  thrown by the join point.


## Around Advice

- Perform additional logic before and after the advised join point (profiling)

- Bypass the original operation and perform some alternative logic(caching)

- Surround the operation with a try/catch block to perform an exception handling
  policy (transaction management)

- Idempotent operations can safely retried using an Around advice

## Collecting join point context
