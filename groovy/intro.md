# Groovy

- Was invented by James Strachan in 2003
- Java's agile and dynamic friend
- Provides dynamic capabilities to complement the static world of Java
- OO, dynamic, compiled, similar but flexible syntax than Java
- Dynamic: performs its type checking and binding at runtime
- Groovy script is parsed, compiled and generated in memory before execution in JVM
- Sitting in the dynamic layer of polyglot pyramid
- Known for being great for building DSLs
- Aimed at helping to write less boilerplate code
- Easy to call out to existing Java libraries

## Language features that Java doesnt have

- Function literals(called closures in groovy)
- First-class support for collections(support is built into the language syntax)
- First-class support for regex
- First-class support for XML processing

## Groovy Performance

- Is not always best choice for high performance
- Groovy objects extend from GroovyObject(contains invokeMethod(String name, Object args))
- Every method call goes through invokeMethod(), this makes things slower
- Several optimization and invokedynamic bytecode may change this
