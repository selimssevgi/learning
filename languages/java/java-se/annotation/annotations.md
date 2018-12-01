# Annotation 

- What are Annotations?
- Annotations Uses
- Using Built-in Annotations
- Creating an Annotation
- Reflection
- Using custom annotation in code

## What are Annotations?

- Metadata: data about the code
- Does not directly affect code

## Annotations in Java

- Data holding class
- Can be applied to: classes, methods, fields
- @SuppressWarnings(value = "deprecation")

```java
public @interface ContractAnnotation {
  String signature();
  String date();
}
```

## Annotations Uses

- *Compiler:* @Override, @SuppressWarnings, @Deprecated
- Given compiler more information about the code, so it can help programmer
  more.

- *Tools:* 
  - Generate Code: Lombok
  - Documentation
  - Testing Framework

- *Runtime:*
  - Serialization
  - IoC
  - ORM(Hibernate)

## Using Built-in Annotations

- @Deprecated
- @Override
- @SuppressWarnings
