# Functions

- Out-of-box defined functions for general use.
- java.util.function package

##### java.util.function.Predicate

- boolean test(); method and other and, or, negate, isEqual default methods.

##### java.util.function.Consumer

- void accept(); method and andThen() default method.
- Unlike other functions it will have side affects.
- doesnt return anything. printing, persisting etc.

##### java.util.function.Supplier

- T get(); method.
- No default or static methods.

##### java.util.function.Function

- R apply(T t);


#### PrimitiveFunctions

- Boxing can be heavy
- IntPredicate { boolean test(int value); }
- There are other function with also other primitive types.

```java
Function<Integer, Employee>
IntFunction<Employee>

Function<Integer, Double>
DoubleFunction<Integer>
DoubleToIntFunction
```

### Two Argument Functions

- Functions start with Bi.
- BiPredicate
