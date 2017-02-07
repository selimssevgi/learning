# Scala Types

- Scala doesnt have primitive types.
- Any is the parent of everything
- AnyVal is the parent of primitive types
- AnyRed is the same as java.lang.Object in Java
- AnyRef is the parent of all classes written in Java and Scala


* Any    : Unknown type
  * AnyRef : Java's Object
  * AnyVal
    * Char
    * Byte
    * Short
    * Int
    * Long
    * Double
    * Float
    * String
    * Boolean
    * Unit   : (Java's void)

*Note:* 'Nothing' is subtype of every class.


* RichXXX : -5.abs

- 10.toDouble
- 10.0.round.toInt
- 3.14.toInt
