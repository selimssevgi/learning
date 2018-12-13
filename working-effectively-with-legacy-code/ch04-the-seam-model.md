# ch4 - the seam model

- a seam is a place where you can alter behavior in your program without editing in that place.

```java
public ClassToBeTested {

  public void methodToBeTested() {
    //...
    GlobalObject.aFuncWithSideEffect(arg1, arg2);
    //...
  }

}
```

- how we will test above class? We do not want to interact with external system that creates lots of problems.

- extract that part to a method

```java
public ClassToBeTested {

  public void methodToBeTested() {
    //...
    callSomeExternalNonPureSystem(arg1, arg2);
    //...
  }

  public void callSomeExternalNonPureSystem(Par1 par1, Par2 par2) {
    GlobalObject.aFuncWithSideEffect(par1, par2);
  }

}
```

- now extend this class to override the part that we do not want to be effective in our tests

```java
public TestingClassToBeTests extends ClassToBeTested {

  public void callSomeExternalNonPureSystem(Par1 par1, Par2 par2) {
    // no-op
  }

}
```

- Now we can write tests for that code without the nasty side effect.

- this is called 'object seam'

- if we can replace behavior at seams, we call selectively exclude dependencis in our tests.

- this work can help us get just enough tests in place to support more aggressive work.
