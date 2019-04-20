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

### seam types

**Enabling Point:** Every seam has an enabling point, a place where you can make
the decision to use one behavior or another.

#### preprocessing seams

- In C/C++, a macro preprocessor runs before the compiler.

```c
#ifdef TESTING

// replace expensive operation from other libraries

#endif
```

#### link seams

- in many languages, compilation isn't the last step of the build process.

- the compiler produces an intermediate representation of the code

- that representation contains call to code in other files

- linkers combine these representations, they resolve each of the calls so that
  you can have a complete program at runtime

- in C/C++, there is a separate linkes that does that operation

- in Java, the compiler does the linking process behind the scenes

- when java source file contains an import statement, the compiler checks to if
  the imported class has been compiled, if not, compile.

- compiler and JVM find those classes in classpath

- we can create same package structure in different directory and use those
  classes in the classpath

- here the enabling point is the classpath

#### object seams

- the following example is not a seam, does not provide enabling point

```java
public class Spreadsheet {
  public Spreadsheet buildMartSheet() {
    //...
    Cell cell = new FormulaCell(this, "A1", "=A2+A3");
    cell.recalculate();
    //..
  }
}
```

- the following example, we can call method with different cells, it is a enabling point.

```java
public class Spreadsheet {
  public Spreadsheet buildMartSheet(Cell cell) {
    //...
    cell.recalculate();
    //..
  }
}
```

* object seams are the best choice in OO language.
* preprocessing and link seams can be useful at times but they are not as
  explicit as object seams. Test depend upon them can be hard to maintain.
