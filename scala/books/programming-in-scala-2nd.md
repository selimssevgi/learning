# Programming in Scala, 2nd

!! Read Chapter 9

## Chapter 1

- Scala is an OO language in pure form: every value is an object and every
  operation is a method call.

- Scala is also full-blown functional language.

- FP is guided by two main ideas:
  1. Functions are first-class values.
  2. Operations of a program should map input values to output values rather
     than change data in place.

- There is no other effect of calling replace.(str.replace(';','.')) Methods
  like replace are called *referentially transparent*, which means that for any
  given input the method call could be replaced


```java
// this is Java
boolean nameHasUpperCase = false;
for (int i = 0; i < name.length(); ++i) {
  if (Character.isUpperCase(name.charAt(i))) {
    nameHasUpperCase = true;
    break;
  }
}
```

```scala
val nameHasUpperCase = name.exists(_.isUpper)
```
