# java.lang.reflect.Proxy

- a proxy, that supports the interface of another object, its 'target', so that
  the proxy can substitute for the target for all practical purposes.

- This class is part of JAva reflection becuase Proxy is Java's nly way of
  approximating method invocation intercession.

- 'Intercession' is any reflective ability that modifies the behavior of a
  program by directly taking control of that behavior.

- Method invocation intercession is the ability to intercept method calls

### Proxy Class

- Each class constructed by Proxy factory methods is a public final subclass of
  Proxy, referred to as a *proxy class*.

- an instance of one of these dynamically constructed proxies referred as a *proxy instance*

- the interfaces that the proxy class implements in this way are called *proxied interfaces*

### Invocation Handlers

- Proxy allows programmers to accomplish the delegation task by providing the
  InvocationHandler interface.

- Are objects that handle each method call for a proxy instance.

#### Handling the methods of Object

- A proxy instance is an objects, and so it responds to the methods declared by java.lang.Object

- hashCode, equals, toString are dispatched to the invoke method in the same
  manner as any other proxied method

- if clone make public, and finalize is overridden, it will be forwarded.

- Method intercession does not take place for other methods declared by Object.
  In other words, a call to 'wait' on a proxy instance waits on the proxy
  instance's lock, rather than being forwarded to an invocation handler.


```java
public class TracingInvocationHandler implements InvocationHandler {

  private final Object target;
  private final PrintWriter out;

  public TracingInvocationHandler(Object target, PrintWriter out) {
    this.target = target;
    this.out = out;
  }
  @Override
  public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
    Object result = null;

    try {
      out.println(method.getName() + "(...) is called");
      result = method.invoke(target, args);
    } catch (InvocationTargetException ite) {
      out.println(method.getName() + " throws " + ite.getCause());
      throw ite.getCause();
    }

    out.println(method.getName() + "(...) returns");
    return result;
  }

  public static Object createProxy(Object obj, PrintWriter out) {
    return Proxy.newProxyInstance(
    obj.getClass().getClassLoader(),
    obj.getClass().getInterfaces(),
    new TracingInvocationHandler(obj, out));
  }
}
```

- abstract factory for traced or non-traced object creation

### Chaining Proxies

- One of the strengths of using proxies is that they can be arranged in a chain,
  with each proxy but the last having another proxy as its target.

- The last target in the chain is the real target object.

- we may need to know in chained proxy operation, if what we have is the target
  object, and not another proxy.


```java
protected static final Object findRealTarget(Object t) {
  if (!Proxy.isProxyClass(t.getClass())) {
    return t;
  }
  InvocationHandler ih = Proxy.getInvocationHandler(t);
  // details investigation
}
```

- chaining example, synchronized-and-traced proxy

```shell
Dog rover = (Dog) SynchronizedIH.createProxy(
  TracingIH.createProxy(new DogImpl()),
  new PrintWriter(System.in)
);
```

### Stubbing interface for unit testing

- The use of Proxy-generated stubs in testing also promotes the practice of programming to interfaces

```java
public class StubInvocationHandler implements InvocationHandler, Stub {

  private ReturnValueStrategy returnValueStrategy;

  private History history;

  public static Object createStub(Class[] interfaces, ReturnValueStrategy rvs, History history) {
    for (Class anInterface : interfaces) {
      if (anInterface == Stub.class
      || anInterface == InvocationHandler.class) {
        throw new RuntimeException("Cannot stub interface: " + anInterface);
      }
    }

    Class[] newInterfaces = new Class[interfaces.length + 1];
    newInterfaces[0] = Stub.class;
    System.arraycopy(interfaces, 0, newInterfaces, 1, interfaces.length);
    return Proxy.newProxyInstance(Stub.class.getClassLoader(),
    newInterfaces,
    new StubInvocationHandler(newInterfaces, rvs, history));
  }

  private StubInvocationHandler(Class[] newInterfaces, ReturnValueStrategy rvs, History history) {
    rvs = Objects.requireNonNullElse(rvs, new DefaultReturnValueStrategy());
    history = Objects.requireNonNullElse(history, new DefaultHistory()); // Null Object Pattern
  }


  @Override
  public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
    if (method.getDeclaringClass() == Stub.class) {
      // for stub methods invoke original methods
      return method.invoke(this, args);
    }

    long id = history.recordMethodCall(proxy, method, args);
    try {
      Object returnValue = returnValueStrategy.getReturnValue(proxy, method, args, history);
      history.recordReturnValue(id, returnValue);
      return returnValue;
    } catch (WrappedException wr) {
      history.recordException(id, wr.getCause());
      throw wr.getCause();
    } catch (Exception e) {
      history.recordException(id, e);
      throw e;
    }
  }

  @Override
  public History getHistory() {
    return history;
  }
}
```

* Proxies can be used generate SOAP remote proxies
