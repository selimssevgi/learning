# Javassist

- Java Programming Assistant

- Subproject of JBoss

- Object based API

- CtClass: compile time class

- ClassPool: container of CtClass objects (map of className -> CtClass)

- Java Class: fields, constructos, methods

- CtClass: ctfields, ctconstructors, ctmethods

- no need to know anything about byte code

```java
putMethod.insertBefore("System.out.println(\"hello\");");
```

- insertBefore, catchEx, insertAt, insertAfte

** Positives: simplicity, documentation
** Negatives: limited functionality(no byte-code level), slow
