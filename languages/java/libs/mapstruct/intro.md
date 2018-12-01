# Mapstruct

- It is one of the object-to-object mapping framework

- It is annotation-preprocessor to generate java code at compile time

- The generated source code can be found under target/generated-sources/

- It is best used in case you need to carry entity data through dto
  - lots of fields to write setters/getters manually

- It is combined of two jars

1. Client side annotations: the ones used in the source code

2. Annotation-preprocessor: to generate java code from used annotations

- Use second option wiht maven-compiler-plugin

