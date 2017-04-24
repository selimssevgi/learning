# Scala Types

- Scala doesnt have primitive types.
- Any is the parent of everything
- AnyVal is the parent of primitive types
- AnyRef is the same as java.lang.Object in Java
- AnyRef is the parent of all classes written in Java and Scala

- Byte, Short, Int, Long, Char are called *integral types*.
- Float and Double are called *numeric types*.

* Any    : Unknown type
  * AnyRef : Java's Object
  * AnyVal
    * Char
    * Byte   : val b: Byte = 10 
    * Short  : val c: Short = 100
    * Int
    * Long
    * Double
    * Float
    * String
    * Boolean
    * Unit   : (Java's void), only value is ()

*Note:* 'Nothing' is subtype of every class.


* RichXXX : -5.abs

- 10.toDouble
- 10.0.round.toInt
- 3.14.toInt

## RichWrapper

Basic Type | Rich Wrapper
-----------|-----------------------------------------
Byte       | scala.runtime.RichByte
Short      | scala.runtime.RichShort
Int        | scala.runtime.RichInt
Char       | scala.runtime.RichChar
Float      | scala.runtime.RichFloat
Double     | scala.runtime.RichDouble
Boolean    | scala.runtime.RichBoolean
String     | scala.collection.immutable.StringOps

*Corner case with floating literals:* 1.toString -> is integer 1 or floating point 1.?

- 1.toString (Int)
- 1. toString (Float: a space)
- This space is necessary only when method name starts with a letter
- 1.+1 => 2.0

*Using Unicode characters for variables:*

```shell
scala> val \u0061\u006e\u0073 = 42
ans: Int = 42

// this may not be best idea for usual variable names
// but for scientific notation and characters it may improve readability
```
