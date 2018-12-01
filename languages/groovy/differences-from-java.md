# Differences from Java

* Not required syntax:
- Parentheses for method parameters

* Optional semicolons at the end of statement
* Optional return statement
* Optional parentheses for method parameters
* Default access modifier is public(not default like in Java)
* No difference between checked and unchecked exception
* Idiom of no longer using inner classes

* Alternative way of dealing with the concept of equality

```groovy
x == y      // implict equals() called
x.is(y)     // object identity check
x.is(null)
x == null
```
