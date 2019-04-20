# Annotation Preprocessing

- http://hannesdorfmann.com/annotation-processing/annotationprocessing101
- https://www.youtube.com/watch?v=DEV90S146lU 
- What?
- Why?
- How?

- Dagger, MapStruct, Retrofit, Lombok

## What

- Developer loves writing code. Noone

- Developer loves complex tasks.

- Reflection and runtime code generation everywhere!
  - Spring, Hibernate, GSON, Jersy, Dozer, Guice, Weld, etc...

- Reflection - Slow? Performance Overhead

* Because reflection involves types that are dynamically resolved, certain JVM
  optimization cannot be performed. Consequently, reflective operations have
  slower performance than their non-reflective counterparts, and should be
  avoided in section of code which are called frequently in
  performance-sensitive applications. (JavaDocs)

- Code Generation
  - generating java bytecode at runtime
  - not always ok

- Annotation Preprocessing

* A tool build in javac for scanning and processing annotations at compile time


- Reflection at runtime
- Annotation preprocessing at compile

- An annotation processor for a certain annotation takes Java code(or compile
  byte code) as input and generate files (usually .java files) as output.

- You can generate Java code, the generated java code is in a generated .java
  file. So you cannot manipulate an existing java class for instance adding a method.

- The generated java file will be compiled by javac as any other hand written
  java source file.

- The annotation processor run in it's own JVM

## How

```java
public class MyProcessor extends AbstractProcessor {
   
   @Override
   public synchronized void init(ProcessingEnvironment env) {}

   @Override
   public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment env) {}

   @Override
   public Set<String> getSupportedAnnotationTypes() {}

   @Override
   public SourceVersion getSupportedSourceVersion() {}
}
```
