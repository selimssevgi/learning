# interceptors

- *concern:* what you want to do
- *advice:* actual code to handle the concern
- *pointcut:* where to run/apply the code
- *aspect:* combination of advice and pointcut

- ejb3 interceptor is an around-invoke advice

- interceptors can be applied to session and mdb

### definition

```java
@Interceptor
public class SayHelloInterceptor {

    @AroundInvoke
    public Object sayHello(InvocationContext context) throws Exception {
        System.out.println("Hello Interceptor!");
        return context.proceed();
    }
}
```

### usage

```java
@Stateless
@Interceptors(SayHelloInterceptor.class) // apply to all methods
public StatelessService {}

```java
@Stateless
public StatelessService {
  @Interceptors(SayHelloInterceptor.class) // apply to a certain  method
  public void serviceMethod() {}  
}
```

- we need ejb-jar.xml cus annotation is not enough for the following cases:
  - if we need to apply an interceptor to whole ejb module beans
  - if we need to apply ordering to our interceptors

### disable interceptors

- @ExcludeDefaultInterceptors
- @ExcludeClassInterceptors
