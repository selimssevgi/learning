# Graal - A Java JIT Compiler written in Java

- java code -> javac -> byte code
- byte code -> jit -> machine code


- jvm9 compiler provides an interface for plugging jit compilers


```java
interface JVMCICompiler { // jvm compiler interface
  byte[] compileMethod(byte[] bytecode);
}
```
