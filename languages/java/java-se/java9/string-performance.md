# String Performance

- Compact Strings
- String concatenation changes

## Compact Strings

- Lower memory usage

- pre-java 9

```shell
// string were stored in char[]
// characters in java always encoded using UTF-16
// fits each character into 2 bytes
// "java": 0'j' - 0'a' - 0'v' - 0'a'
// this string does not need the second byte
// not using any characters outside of ascii range
// could save space?
```

- with java

```shell
// now the string representation is byte[]
// do not have use UTF-16 for encoding
// "java": 'j''a''v''a'
// how do we know if we should treat byte[] as ascii endoing or UTF-16?
// there is a flag in String class called 'coder'
// coder = 0 means Latin1(only ascii characters)
// coder = 1 means Full Unicode
```

## String concatenation changes

- Change concatenation translation strategy
- Groundwork for future improvements

- pre-java 9
- hard to maintain code related to this in JVM
- compiler is strictly tied to StringBuilder and append
- Could not take advantage of a better way if comes to existince
- Previously compiled code would be problematic, cannot ask to recompile on new compiler

```shell
String s = "a" + "b" + "c";
// compiler translates to, and jvm does its tricks to make it more performant
StringBuilder s = new StringBuilder();
s.append("a");
s.append("b");
s.append("c");
```

- with java 9: invokedynamic bytecode
- late binding to actual implementation (at runtime)
- stable bytecode, future improvements possible
- all code compiled with java 9 or later will benefit from these improvements
