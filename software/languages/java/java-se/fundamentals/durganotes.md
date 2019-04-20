# Java Language Fundamentals

- Identifiers
- Reserved Words
- Data Types
- Literals
- Arrays
- Types of Variables
- Var-ags Methods
- Main Method
- Command Line Arguments
- Java Coding Standarts

## Identifiers
A name in Java program is called identifier, which can be used for
identification porpuse. It can be method name, variable name, class name,
label name.

```java
class Test {
  public static void main(String[] args) {
    int x = 0;
  }
}
```

Identifiers: Test, main, String, args, x.

### Rules for Defining Java Identifiers
* The only allowed characters in Java Identifiers are:

  - A to Z
  - a to Z
  - 0 to 9
  - $, _

If we are using any other character, we will get compile time error.

```java
int total_number;  // valid
int total#        // invalid
```

* Identifiers can not start with a digit.


```java
int total123;  // valid
int 123total;  // invalid
```

* Java Identifiers are case-sensitive. Of course Java language itself is treated
  as canse-sensitive programming languge.

```java
int number = 10;
int Number = 20;
int NUMBER = 50;
```
* There is no length limit for Java Identifiers. But it is not recommended to
  take too lengthy identifiers.

* We can not use the reserved words as identifiers.

```java
int x  = 10; //valid
int if = 10; //invalid
```

* All predefined Java class and interface names can be used as identifiers.

```java
// all valid
int String = 888;
System.out.println(String);
int Runnable = 999;
System.out.println(Runnable);
```
Even though it is valid, it is not a good programming practice. Because it
reduces readability and creates confusion.

#### Question
Which of the followings are valid java identifiers?


```java
int total_number;        // valid
int total#;              // invalid
int 123total;            // invalid
int total123;            // valid
int ca$h;                // valid
int _$_$_$_;             // valid
int java2share;          // valid
int all@hands;           // invalid
int Integer;             // valid
int Int;                 // valid
int int;                 // invalid
```


## Reserved Words
In Java, some words are reserved to present some meaning or functionality. Such
type words are called reserved words.

- Reserved Words(53)
  - Reserved Literals(3: true, false, null)
  - Keywords(50)
    - Unused keywords(2: goto, const)
    - Used keywords(48)


### Keywords for Data Types(8)
byte, short, int, long, float, double, boolean, char


### Keywords for Flow Control(11)
if, else, switch, case, default, while, do, for, break, continue, return

### Keywords for Modifiers(11)
public, private, protected, (default), static, final, abstract, synchronized,
native, strictfp(V1.2), transient, volatile.

#### strictfp (Strict Floating Point)
Ensures that you will get the same result on every platform. The precision may
differ from platform to platform that is why java has provided the strictfp
keyword. So, now you have better control over the floating-point arithmetic.

```java
strictfp class A {} // applied on class
strictfp interface A {} // applied on interface
strictfp void m() {} // applied on method

// not valid!
strictfp abstract void m();
strictfp int data = 10;
class B {
  strictfp B() {};
}
```

### Keywords for Exception Handling(6)
try, catch, finally, throw, throws, assert(V1.4)

### Class Related Keywords(6)
class, interface, extends, implements, package, import.

### Object Related Keywords(4)
new, instanceof, super, this.

### Void return type keyword(1)
In Java, return type is mandatory. If a method wont return anything, then we
have to declare that method with void return type.But in C language, return type
is optional, and default return type is int.

### Unused Keywords(2)
- goto: Usage of goto created several problems in old languages, and hence Sun
  people banned this keyword in Java.

- const: Use final instead of const.

**NOT:** goto and const are unused keywords, if we are trying to use, we will
get compile time error.

### Reserved Literals(3)
- true, false are values for boolean data type.

- null: default value for object reference.

### enum Keyword(V1.5)
We can use enum to define a group of named constants.

```java
enum Months {
  JAN, FEB, MARCH, APR, DEC;
}
```

#### Conclusions
- All 53 reserved words in Java contains only lower case alphabetical symbols.

- In Java, we have only new keyword, and there is no delete keyword. Because of
  destruction of useless object is responsible of Garbage Collector.

- The following are new keywords in Java.
  - strictfp -> version 1.2
  - assert   -> version 1.4
  - enum     -> version 1.5


##### Question
* Which of the following only contains Java keywords?
  - new, delete                       // no delete
  - goto, constant                    // no constant
  - break, continue, return, exit     // no exit
  - final, finally, finalize          // no finalize
  - throw, throws, thrown             // no thrown
  - notify, notifyAll                 // there are methods in Object class
  - implements, extends, imports      // not imports, should be import
  - sizeof, instanceof                // no sizeof
  - instanceOf, strictFp              // should be all lower case
  - byte, short, Int                  // no Int, is int
  - None of the above                 // yes!

* Which of the followings are java reserved words?
  - public
  - static
  - void
  - main      // not reserved
  - String    // not reserved, but predefined class name
  - args      // not reserved

## Data Types
- In Java, every variable and every expression has a some type.

- Each and every data type is clearly defined.

- Every assignment should be checked by compiler for type compatibility.

- Because of above reasons, we can conclude java language **strongly typed**
  programming language.

Java is not considered as a pure object oriented language, because several group
of features are not satisfied in Java.(Operator overloading, multiple
inheretence etc). Moreover, we are depending on primitive data types which are not Objects.

### Primitive Data Types(8)
  - Numeric Data Types
    - Integral Data Types
      - byte, short, int, long
    - Floating-point Data Types
      - float, double
  - Non-Numeric Data Types
    - char
    - boolean

Except boolean and char, the remaining data types are considered as **signed data
types**. Because we can represent both positive and negative numbers.

#### byte
- 1 byte = 8 bits
- the most left bit  is most significant bit, which is also signed bit.
  - 0 -> positive
  - 1 -> negative
- max value = 01111111 = +127
- min value = 11111111 = -128 (2's complement)
- range = -128 to +127

Positive numbers are represented in directly in memory, negative numbers are
represented in two's complement form.

```java
byte b = 10;
byte b = 127;
byte b = 128; // CE: possible loss of precision. found: int required: byte
byte b = 1.5; // CE: possible loss of precision. found: double required: byte
byte b = true;// CE: incompatible types. found: boolean required: byte
```

Byte is the best choice if we want to handle data in terms of streams either
from the file or network. (File and network supported form is byte.)

#### short
- 2 bytes = 16 bits
- range = -2pow15 to 2pow15-1

It is the most reraly used data type in Java.

It is best suitable for 16bit processors like 8085/6, but these processors are
completely outdated. Hence corresponding short data type is outdated data type.

#### int
Is most commonly used data type.

- 4 bytes = 32 bits
- range = -2pow31 to +2pow31-1 ( one bit for sign )

```java
int x = 2147483647;
int x = 2147483648; // CE: integer number too large
int x = 2147483648L;// CE: possible loss of precision, found: long required: int
int x = true;    // CE: incompatible types, found: boolean, required: int
```

#### long
Sometimes int may not be enough to hold big values, then we should go for long
type.

ex: the amount of distance travelled by light in thousand day, to hold this
value int may not be enough, we should go for long data type.

ex: the number of characters representing in a file may exceed the range of int,
hence the return type of length is long.

```java
long l = f.length();
```

- 8 bytes = 64 bits
- range = -2pow63 to 2pow63 - 1

**NOT:** All the above data types (byte, short, int, long) meant for
representing integral values. If we want to represent floating-point values,
then we should go floating-point data types.

### Floating-Point Data Types

- Accurecy
  - If we want  5 to  6 decimal places of accurecy then we should go for float.
  - if we want 14 to 15 decimal places of accurecy then we should go for double.

- Float follows single precision, double follows double precision.

- Size
  - Float : 4 bytes
  - Double: 8 bytes

- Range
  - Float : -3.4e38 to 3.4e38
  - Double: -1.7e308 to 1.7e308

### boolean Data Type
- size : not applicable. [VM dependent]
- range: not applicable, but allowed values are true and false.

### char Data Type
Old languages(C/C++) are ASCII code based, and number of allowed different ASCII
characters are <= 256. To represent these 256 characters 8 bits are enough.
Hence the size of char in old languages is 1 byte.

Java is Unicode based, and the number of different Unicode characters are >256
and <= 65536. To represent these many characters 8 bits may not enough,
compalsory we should go for 16 bits. Hence the size of char in Java is 2 bytes.

- size: 2 bytes (Unicode), older languages(C/C++) using ASCII.
- range: 0 to 65535

##### Summary of Primitive Data Types

Data Type | Size | Range | Wrapper Class | Default Value
--------- | ---- | ----- | ------------- | ------------
byte| 1 byte| -2pow7 to 2pow7-1 | Byte | 0
short| 2 bytes| -2pow15 to 2pow15-1 | Short | 0
int| 4 bytes| -2pow31 to 2pow31-1 | Integer | 0
long| 8 bytes| -2pow63 to 2pow63-1 | Long | 0
float| 4 bytes| -3.4e38 to 3.4e38 | Float | 0.0
double| 8 bytes| -1.7e308 to 1.7e308 | Double | 0.0
boolean| NA | NA | Boolean | false
char| 2 bytes | 0 to 65535 | Character | 0 (Space character)

**NOT:** null is default value for object references, and we cannot apply for
primitives. If we are trying to use for primitive, then we will get compile time
error.

## Literals
A constant value which can be assigned to a variable is called literal.

```java
int x = 10;
// int -> data type | keyword
// x   -> name of variable | identifier
// 10  -> constant value | literal
```

### Integral Literals
For integral data types(byte,short,int,long) we can specify literal value in the
following ways:

```java
int x = 10;     // decimal form
int x = 010;    // octal form, prefix with 0
int x = 0x10;   // hexa decimal form, prefix with 0x
int x = 0xfF;   // we can use both lower and upper case characters
int x = 0X11;
// this is one of few areas where Java is not case-sensitive
```

These are only possible ways to specify literal value for integral data types.

```java
int x = 10;     // valid
int x = 078;    // octal form, 0-7 are allowed. not valid
int x = 0777;   // valid
int x = 0XFace; // valid
int x = 0XBeef; // valid
int x = 0XBeer; // not valid. 0-9 and a-f
```

Programmer has option to define them in different forms, but JVM will print them
out in decimal form.

```java
class Test {
  public static void main(String[] args) {
    int x = 10;
    int y = 010;
    int z = 0x10;

    System.out.println(x + "..." + y + "..." + z); // 10...8...16
  }
}
```

By default every integral literal is of int type. But we can specify explicitly
as a long type by suffixing with small l or capital L.

```java
int x  = 10;    // valid
long l = 10L;   // valid
int x  = 10L;   // CE: possible loss of precision, f: long required: int
long l = 10;    // valid
```

There is no direct way to specify byte or short literal explicitly. But
indirectly we can specify. Whenever we are assignning integral literal to byte
variable and the value is in the range of byte, then compiler treats it
automatically as byte literal. Similary, short literal also.

### Floating-Point Literals
By default every floating-point literal is of double type. Hence we cannot
assign directly to a float variable. But we can specify floating-point literal
as float type by suffixing with small f or capital F.

```java
float f  = 123.456;  // CE: possible loss of precision
float f  = 123.456F;
double d = 123.456;
double d = 123.456D; // compiles. but D not required. is double by default.
float  f = 123.456d; // CE: possible loss of precision. f: double r: float
```

We can specify floating-point literals only in decimal form, and we  cannot
specify in octal and hexadecimal forms.

```java
double d = 123.456;
double d = 0123.456;    // valid. 0 doesnt have any effect.
double d = 0X123.456;   // CE: malformed floating-point literal
```
We can assign integral literals directly to floating-point variable, and that
integral literal can be specified either in decimal, octal, hex forms.

```java
double d = 0678;    // integral literal. octal form. 8 is not allowed. not valid
double d = 0XFace;  // integral literal. hex form. valid.
double d = 0678.0;  // floating-point literal. VALID
double d = 0X123.0; // floating-point literal. INVALID
double d = 10;      // decimal form. valid. 10.0
double d = 0777;    // octal form integral literal. valid
```

We can not assign floating-point literals to integral types.

```java
double d = 10;   // valid
int    x = 10.0; // CE: possible loss of precision. f: double r:int
```

We can specify floating-point literal even in exponential form(secintific
notation).

```java
double d = 1.2e3;   // valid. 12000.0
float  f = 1.2e3;   // CE: possible loss of precision. f: double r:float
float  f = 1.2e3F;  // valid
```

### boolean Literals
The only allowed values for boolean data type are true or false.

```java
boolean b = true;    // valid
boolean b = 0;       // CE: incompatible type. f: int required: boolean
boolean b = True;    // CE: Cannot find symbol variable True.
boolean b = "true";  // CE: incompatible type. f: j.l.String required: boolean

// if(1) or while(1) are invalid in Java, even though they are valid in C
// CE: incompatible type: fount: int required: boolean
```


### char Literals
We can speficy char literal as signle character within single quotes.

```java
char ch = 'a';
char ch =  a;   // CE: cannot find symbol. variable a
char ch = "a";  // CE: incompactible types. found: j.l.String, required: char
char ch = 'ab'; // CE: unclosed char literal(expects signle quote after a)
```

We can specify char literal as integral literal which represents unicode value
of the character. And that integral literal can be specify either decimal, octal
or hexadecimal forms. But allowed range is 0 to 65536.

```java
char ch = 97; // same as char ch = 'a';
char ch = 0XFace; // valid
char ch = 0777;   // valid
char ch = 65535;  // valid
char ch 65536; // CE: possible loss of precision. found: int required: char
```

We can represent char literal in unicode representation, which is nothing but
'\uxxxx', 4 digits hexadecimal number.

```java
char ch = '\u0061'; // a
```

Every escape character is a valid char literal.

```java
char ch = '\n'; // new line
char ch = '\t'; // tab
char ch = '\m'; // CE: illegal escape character
```

#### Escape Characters
Escape Character | Description
---------------- | -----------
\n | new line
\t | horizantol tab
\r | carriage return
\b | back space
\f | form feed
\\' | single quote
\\" | double quote
\\\ | backslash

##### Question
Which of the following is valid?


```java
char ch = 65356;   // invalid, out of range
char ch = 0XBeer;  // invalid
char ch = \uface;  // invalid, need single quotes
char ch = '\ubeef';// valid
char ch = '\m';    // invalid, illegal escape character
char ch = '\iface';// invalid
```

### String Literal
Any sequences of characters within double quotes is treated as string literal.

```java
String s = "durga";
```

#### Java 7 enhancement with the respected to literals

##### Binary Literals
For integral data types until 1.6 version, we can specify literals in the
following ways:
  - Decimal form
  - Octal form
  - Hexadecimal form

But from 1.7 version onwards, we can specify literal value even in binary form
also. Allowed digits are 0 and 1. Literal value should be prefixed with the 0b
or 0B.

```java
int x = 0b1111; // 15
int x = 0B1110; // 14
```

##### Usage of UnderScore Symbol in Numeric Literals
From 1.7 version onwards, we can use underscore symbol between digits of numeric
literal.

```java
double d = 123456.789;
double d = 1_23_456.7_8_9;
double d = 123_456.7_8_9;
```

The main advantage of this approach is that readability of code will be improved.

At the time of complitation these underscore symbols will be removed
automatically. Underscore are just for .java files

We can use more than one underscore symbols between digits..

```java
double d = 1___23__456.7_8_9;
double d = 123___456.7__8_9;
```

**NOT:** We can use underscore symbol only between the digits, if we are using
anywhere else, we will get compile time error.

```java
double d = _123_456.7_8_9; // not valid. at the beginning
double d = 123_456_.7_8_9; // not valid. should be between digits
double d = 123_456.7_8_9_; // not valid. at the end
```

## Data Type Conversion
byte(1byte) --> short(2byte)
                            \
                             ---> int(4b) --> long(8b) --> float(4b) --> double(8b)
                           /
char(2byte)  -------------/

**NOT:** 8 byte long value can be assigned to 4 byte float value, because both are
following different memory representation internally.

- 1 room, 100 chairs , 1 person for each chair, 100 people
- 1 room,  50 chairs , 2 person for each chair, 100 people

```java
float f = 10l; // 10.0
```

**NOT:** char and short are both 2 bytes, but maynot be converted to each other.
Because short is signed data type, while char is unsigned data type.

## Arrays
  - Array Introduction
  - Array Declaretion
  - Array Creation
  - Array Initialization
  - Array DCI in a single line
  - length vs length()
  - Anonymous Arrays
  - Array element assignments
  - Array variable assigments

### Array Introduction
An array is an indexed collection of fixed number of homogenous data elements.

The main advantage of arrays is that we can represnt huge numbers of values by
using single variable. So that the readability of the code will be improved.

The main disadvantage of arrays is fixed in size, that is once an array is
created, no change of increasing or decreasing of size based on requirements.

Hence to use array concept compalsory we should know the size in advance, which
may not be possible always.

### Array Declaration

#### One Dimensional Array Declarition

```java
// all three ways are valid
int[] x; // recommended way
int []x;
int x[];
```

At the time of declaretion the size cannot be specified, otherwise there will be
compile time error.

```java
int[6] x; // invalid
int[]  x; // valid
```

#### Two Dimensional Array Declarition

```java
// all are valid
int[][] x; // recommended way
int [][]x;
int x[][];
int[] []x;
int[] x[];
int []x[];
```

```java
int[] a,b;        // a->1, b->1
int[] a[],b;      // a->2, b->1
int[] a[],b[];    // a->2, b->2
int[] []a,b;      // a->2, b->2 : space is ignored by compiler
int[] []a,b[];    // a->2, b->3
int[] []a,[]b;    // CE:  is not legal for the second one.
```

If we want to specify dimension before the variable, that facility is applicable
only for first variable in the declarition. If we are trying to apply for the
remaining variables, we will get compile time error.

### Array Creation
Every array in Java is object only, hence we can create arrays by using new
operator.

```java
int[] x = new int[3];
System.out.println(x.getClass().getName()); // [I
```

For every type correspending classes are available, and these classes are part
of java language and not available to the programmer level.

Array Type | Correspending Class Name
---------- | ------------------------
int[] | [I
int[][] | [[I
double[] | [D
short[] | [S
byte[] | [B
boolean[] | [Z


At the time of array creation compalsry we should specify the size, otherwise we
will get compiler time error.

```java
int[] x = new int[];   // invalid. CE
int[] x = new int[3];  // valid.
int[] x = new int[0];  // valid. main(String[] args) : running program w/o args
int[] x = new int[-3]; // compiles. RE: negativeArraySizeException
int[] x = new int['a'];// size=97. can accept byte, short, char and int.
int[] x = new int[10l];// CE: possible loss of precision, f:long r:int
int max = Integer.MAX_VALUE;
int[] x = new int[max]; // maximum number of size of an array
int[] x = new int[max]; // max x 4 bytes: outofMemoryError, depends on machine
int[] x = new int[2147483648]; // CE: integer value too large
```

### Multi-Dimensional Array Creation
In Java 2D array is not implemented matrix style. Sun people followed array of
arrays approach for multi-dimensional array creation. The main advantage of this
approach is memory utilization will be improved by default.

```java
int[][] x = new int[2][];
int[0] = new int[2];
int[1] = new int[3];
```

```java
int[][][] x = new int[2][][];
int[0] = new int[3][];
int[0][0] = new int[1];
int[0][1] = new int[2];
int[0][2] = new int[3];
int[1] = new int[2][2];
```

##### Question
Which of the following lines are valid?

```java
int[] a = new int[ ];             // invalid. need size
int[] a = new int[3];             // valid
int[][] a = new int[ ][ ];        // invalid. need at least base size
int[][] a = new int[3][ ];        // valid
int[][] a = new int[ ][4];        // invalid. need at least base size
int[][] a = new int[3][4];        // valid
int[][][] a = new int[3][4][5];   // valid
int[][][] a = new int[3][4][ ];   // valid
int[][][] a = new int[3][ ][5];   // invalid
int[][][] a = new int[ ][4][5];   // invalid
```

### Array Initialization
Once an array is created, every array element is by default initialized
with the default value.

```java
int[] x = new int[3];
System.out.println(x); // [I@3e2a5 : class name @ hashcode
System.out.println(x[0]); // 0
```

**NOT:** Whenever we try to print any reference variable, internally two String method
will be called, which is implemented by default to return the string in the
following form:

className@hashcode_inhexadecimalform


```java
int[][] x = new int[3][2];
System.out.println(x);       // [[I@somehashcode
System.out.println(x[0]);    // [I@somehashcode
System.out.println(x[0][0]); // 0
```

```java
int[][] x = new int[3][0];
System.out.println(x);       // [[I@somehashcode
System.out.println(x[0]);    // null
System.out.println(x[0][0]); // RE: NullPointerException
```

**NOT:** If we are trying to perform any operation on null, then we will get runtime
exception saying: NullPointerException.

Once we create an array, every array element by default is initialized with the
default values. If we are not satisfied with the default values, then we can
override these values with our costumized values.

```java
int[] x = new int[3];
int[0] = 10;
int[1] = 20;
int[2] = 30;
int[3]  = 40; // RE: ArrayIndexOutOfBoundException
int[-3] = 40; // RE: ArrayIndexOutOfBoundException
int[2.5] = 40; // CE: possible loss of precision, f: double r:int
```

If we are trying to access array element with out of range index(either positive
value or negative value) then we will get runtime exception saying:
ArrayIndexOutOfBoundException.

### Array Dec, Crea, and Initialization in a Single Line

```java
int[] x;         // declaretion
x = new int[3];  // creatation
x[0] = 1;        // initialization
x[1] = 2;
x[2] = 3;

// in a single line
int[]    x = {1, 2, 3};
char[]  ch = {'a', 'b', 'c'};
String[] s = {"durga", "soft"};

// multi-dimensional
int[][] x = { {10, 20}, {30, 40, 50} };
```

```java
int x = 10;
// could be
int x;
x = 10;

int[] x = {1,2,3};
// cannot be
int[] x;
x = {1,2,3}; // CE: illegal start of expression
```

## length vs length()

### length
Is a final variable, and applicable for arrays. length variable represents the
size of the array.

```java
int[] x = new int[6];
System.out.println(x.length()); // CE: cannot find symbol s: method length, l:
class int[]

System.out.println(x.length); // 6
```

### length()
Is a final method(in a final class), and applicable for String objects. length
method  returns the number of characters represent in the string.

```java
String s = "durga";
System.out.println(s.length); // CE: cannot find symbol s: variable length, l:
j.l.String

System.out.println(s.length()); // 5
```

#### Question


```java
String[] s = {"A", "AA", "AAA"};

System.out.println(s.length);     // 3
System.out.println(s.length());   // CE: cannot find symbol: method length
System.out.println(s[0].length);  // CE: cannot find symbol: variable length
System.out.println(s[0].length());// 1
```
**NOT:** In multi-dimensional arrays, length variable represents only base size, but not
total size.

```java
int[][] x = new int[6][3];
System.out.println(x.length); // 6
System.out.println(x[0].length); // 3
```

There is no way direct way to find the total length of multi-dimensional array.
But indirectly we can find it as follows:

a[0].length + a[1].length + ...

## Anonymous Arrays
Sometimes we can declare an array without a name, such a type nameless arrays are
called anonymous arrays. The main purpose of anonymous array is  just for
instant use(one time usage).

```java
class Test {
  public static void main(String[] args) {
    sum(int[]{10, 20, 30, 40});   // anonymous array
  }

  public static void sum(int[] x) {
    int total = 0;
    for(int num : x) {
      total += num;
    }

    System.out.println("The sum :" + total);
  }
}
```

While creating anon arrays, we cannot specify the size. Otherwise we will get
compile time error.

```java
new int[3]{1,2,3}; // invalid
new int[ ]{1,2,3}; // valid

new int[][]{ {1,2}, {1,2,3} }; // valid

```

Based on our requirement, we can give a name to the anon array, then it is no
longer anonymous.

```java
int[] x = new int[]{1,2,3};
```

## Array Element Assignments

#### Case 1
In the case of primitive type arrays, we can provide any type which can be
promoted to declared type.


```java
int[] x = new int[5];
x[0] = 10;
x[1] = 'a'; // 97
byte b = 5;
x[2] = b;
short s = 10;
x[3] = s;
x[4] = 10L; // CE: possible loss of precision
```

In the case of float type arrays, the allowed data types are byte, short, char,
int, long, float.

#### Case 2
In the case of object type arrays, as array elements we can provide either the
declared type object or its child class object.


```java
Object[] a = new Object[10];
a[0] = new Object();
a[1] = new String("durga");
a[2] = new Integer(10);


Number[] n = new Number[10]; // abstract class
n[0] = new Integer(10);
n[1] = new Double(10.5);
n[2] = new String("durga"); // CE: incompatible type found: String r: j.l.Number
```

#### Case 3
For interface types arrays, as array elements its implementation classes is
allowed.

```java
Runnable[] r = new Runnable[10];
r[0] = new Thread();
r[1] = new String("durga"); // CE: incompatible types. f: String r: Runnable
```

##### Summary
Array Type | Allowed Element Types
---------- | ---------------------
Primitive arrays | any type which can be implicitly promoted to declared type
Object arrays | either declared type or its child class objects
Abstract class arrays | its child class objectS
interface type arrays | its implementation class objectS


##### Case 1:
Element Level Promotions are not applicable at array level. For example char
element can be promoted to int type whereas char array can not be promoted to
int array.

```java
int[]   x = {10, 20, 30, 40};
char[] ch = {'a', 'b', 'c', 'd'};

int[] b = x; // valid
int[] c = ch; // CE: incompatible types. found: char[] , required: int[]
```

#### Question
Which of following promotion will be performed automatically?



```
char     --> int           // valid
char[]   --> int[]         // invalid
int      --> double        // valid
int[]    --> double[]      // invalid
float    --> int           // invalid
float[]  --> int[]         // invalid
String   --> Object        // valid
String[] --> Object[]      // valid
```

**NOT:** In the case of object type arrays, child class type array can be
promoted to parent class type array.

```java
String[] s = {"A", "B", "C"};
Object[] o = s; // valid. parent <- child
```

#### Case 2
Whenever we are assigning one array to another array, internal elements will not
be copied. Just the references will be reassigned.

```java
int[] a = {10, 20, 30, 40};
int[] b = {10, 20};

a = b; // valid
b = a; // valid

```

#### Case 3
Whenever we are assigning one array to another array, the dimensions must be
matched. For example, in place of one dimensional array, we should provide 1D
array only. If we are trying to provide any other dimensional array, we will get
compile time error.

```java
int[][] a = new int[3][];
a[0] = new int[4][3]; // CE: incompatible types. f: int[][] r: int[]
a[0] = 10;            // CE: incompatible types. f: int r: int[]
a[0] = int[2]; // valid
```

**NOT:** Whenever we are assigning one array to another array, both dimensions
and types must be matched but sizes are not required to match.


##### Questions
```java
public class Test {
  public static void main(String[] args) {
    for (int i=0; i <= args.length ; i++ ) {
     System.out.println(args[i]);
    }
  }
}

// java Test A B C -> A B C RE: AIOOBE
// java Test A B   -> A B RE: AIOOBE
// java Test       -> RE: AIOOBE
// should be i < args.length
```

```java
public class Test {
  public static void main(String[] args) {
    String[] argh = {"x", "y", "z"};
    args = argh;

    for (String s : args) {
      System.out.println(s);
    }
  }
}

// java Test A B C -> x y z
// java Test A B   -> x y z
// java Test       -> x y z
// always reassigning args array reference
```

```java
int[][] a = new int[4][3]; // 5 objects
a[0] = new int[4];         // 1 more object -> 1 object hanging
a[1] = new int[2];         // 1 more object -> 1 object hanging
a = new int[3][2];         // 4 objects -> 5 objects hanging

// total how many objects created? 11

// total how many objects are eligible for GC? 7
```

## Types of Variables

### Division One
Based on type of value represented by the variable all variables are divided
into two types:

- Primitive Values, can be used to represent
  - int x = 10;

- Reference variables can be used to refer objects.
  - Student s = new Student();

### Division Two
Based on position of declaration and the behaviour, all variables are divided
into three types.
  1. Instance Variables
  2. Static Variables
  3. Local Variables

#### Instance Variables
If the value of variable is varied from object to object, such type variables
are called instance variables.
For every object a separate copy of instance variable will be created.

Instance variables should be declared within the class directly but outside of
any method, block or constructor.

Instance variable will be created at the time of object creation, and destroyed
at the time of object destruction. Hence the scope of instance variable is
exactly same as the scope of object.

Instance variables will be stored in the heap memory as the part of object.

```java
public class Student {
  String name;
  int rollNo;
}
```

We cannot access instance variables directly from static area but we can access
by using object reference. We can access instance variables directly from
instance area.

```java
public class Test {
  int x = 10;
  public static void main(String[] args) {
    System.out.println(x); // CE: non-static var x cannot be referenced from a
    static context

    Test t = new Test();
    System.out.println(t.x); // valid
  }

  public void method() {
    System.out.println(x); // valid
  }
}
```

For instance variables JVM will always provide default values, and we are not
required to perform initialization explicitly.

```java
public class Test {
  int x;
  double d;
  boolean b;
  String s;

  public static void main(String[] args) {
    Test t = new Test();
    System.out.println(t.x); // 0
    System.out.println(t.d); // 0.0
    System.out.println(t.b); // false
    System.out.println(t.s); // null
  }
}
```

**NOT:** Instance variables are also known as object level variables or attributes.

#### Static Variables
If the value of a variable is not varied from object to object, then it is not
recommended to declare variable as instance variable. We have to declare such
type variables at class level by using static modifier.

In the case of instance variables for every object a separate copy will be
created, but in the case of static variables a single copy will be created at
the class level, and share by every object of class.

Static variables should be declared within the class directly but outside of
any method, block or constructor.

```java
public class Student {
  String name;
  int rollno;
  static String school; // is same for all students in this case
}
```

Static variables will be created at the time of class loading, and destroy at
the time of class unloading. Hence, the scope of static variable is exactly same
as the scope of that class file.

```shell
$ java Test
```

- Start JVM
- create and start main Thread
- Locate Test.class file (if not, class not found exception)
- Load Test.class (Static variables creation)
- Execute main() method
- Unload Test.class (static variables destruction)
- Terminate main Thread
- Shutdown JVM

Static variables will be stored in method area.

We can access static variables either by class name or objecr reference but
recommended to use class name. Within the same class it is not required to class
name and we can access directly.

We can access static variable directly from both instance and static areas.
```java
public class Test {
  static int x = 10;

  public static void main(String[] args) {
    Test t = new Test();
    System.out.println(t.x);   // valid. not recommended
    System.out.println(Test.x); // increase readability
    System.out.println(x); // static area
  }

  public void method() {
    System.out.println(x);  // instance area
  }
}
```
For static variable JVM will provide default values, we are not required to
perform initialization explicitly.

```java
public class Test {
  static int x;
  static double d;
  static String s;

  public static void main(String[] args) {
    System.out.println(x); // 0
    System.out.println(d); // 0.0
    System.out.println(s); // null
  }

}
```

**NOT:** Static variables are also known as class level variables and fields.

```java
public class Test {
  static int x = 10;
  int y = 20;

  public static void main(String[] args) {
    Test t1 = new Test();
    t1.x = 888;
    t1.y = 999;
    Test t2 = new Test(); // gets its own instance variable y = 20
    System.out.println(t2.x + "..." + t2.y); // 888...20
  }

}
```

### Local Variables
Sometimes to meet temporary requirements of progremmer we can declare variables
inside a method, block or constructor. Such type variables are called local
variables, temporary variables, stack variables, automatic variables.

```java
public void method() {
  int x = 10; // local variable  in method
}

static {
  int x = 10; // local variable in block
}

public Test() {
  int x = 10; // local variable in constructor
}

for (int i=0; i<10 ; i++) {
 System.out.println(i);  // local variable in loop
}
```

Local variables will be stored inside stack memory.

Local variables will be created while executing a block in which we declared
it. Once a block execution completes local variable will be destroyed. The scope
of local variable is the block on which we declared it.

Local variables are thread-safe because for each thread a different local
variable is maintained.

```java
public class Test {
  public static void main(String[] args) {
    int i = 0;
    for (int j=0; j < 3; j++) {
     i = i + j;
    }

    System.out.println(i + "..." + j); // cannot access j. out of scope
  }

}
```

For local variables JVM will NOT provide default values, compalsary we should
perform initialization explicity before using that variable. If we are not using
then it is not required to perform initialization.


```java
public class Test {
  public static void main(String[] args) {
    int x; // local variable

    System.out.println(x); // CE: variable x might not have been initialized
  }
}
```

```java
public class Test {
  public static void main(String[] args) {
    // int x = 0;
    int x; // local variable
    if (args.length > 0) {
     x = 10;
    }
    System.out.println(x); // CE: variable x might not have been initialized
  }
}
```

It is not recommended to perform initialization for local variables inside
logical blocks. Because there is no guarantee for the execution of this block
always at the run time.

It is highly recommended to perform initialization for local variables at the
time of declaration at least with default values.

The only applicable modifier for local variables is final. By mistake if we are
trying to apply any other other modifier, then we will get compile time error.

```java
public class Test {
  public static void main(String[] args) {
    public    int x = 10; // CE: illegal start of expression
    private   int x = 10; // CE: illegal start of expression
    protected int x = 10; // CE: illegal start of expression
    default   int x = 10; // CE: illegal start of expression
    static    int x = 10; // CE: illegal start of expression
    transient int x = 10; // CE: illegal start of expression
    volatile  int x = 10; // CE: illegal start of expression
    final     int x = 10; // only valid modifier
  }
}
```

If we are declaring with any modefier then by default it is default. But this
rule is applicable only for instance and static variables but not for local
variables.

#### Conclusions
1. For instance and static variables JVM will provide default values and we are
   not required to perform initialization explicitly. But for local variables
   JVM wont provide default values, compalsary we should perform initialization
   explicitly before using that variable.

2. Instance and static variables can be accessed by multiple threads
   simultaneously, hence they are not thread-safe. In case of local variables
   for every thread separate copy will be created. Hence local variables are
     thread-safe.

Type of Variable | is Thread-Safe?
---------------- | ---------------
Instance Variable | NO
Static Variable | NO
Local Variable | YES

3. Every variable in Java should either instance,static or local. Every variable
   in Java should be either primitive or reference. Hence various possible
   combinations of variables in Java are:
    - Instace - Primitive
    - Instace - Reference
    - Static  - Primitive
    - Static  - Reference
    - Local   - Primitive
    - Local   - Reference

```java
public class Test {
  int x = 10; // instance primitive
  static String s = "durga"; // static reference
  public static void main(String[] args) {
    int[] y = new int[3]; // local reference
  }
}
```

##### Uninitialization Array

##### Instance Level

```java
public class Test {
  int[] x;

  public static void main(String[] args) {
    Test t = new Test();
    System.out.println(t.x); // reference default value: null
    System.out.println(t.x[0]); // RE: NPE
  }
}
```

```java
public class Test {
  int[] x = new int[3];

  public static void main(String[] args) {
    Test t = new Test();
    System.out.println(t.x); // [I@somehashcode
    System.out.println(t.x[0]); // 0
  }
}
```

##### Static Level

```java
public class Test {
  static int[] x;

  public static void main(String[] args) {
    Test t = new Test();
    System.out.println(t.x); // reference default value: null
    System.out.println(t.x[0]); // RE: NPE
  }
}
```

```java
public class Test {
  static int[] x = new int[3];

  public static void main(String[] args) {
    Test t = new Test();
    System.out.println(t.x); // [I@somehashcode
    System.out.println(t.x[0]); // 0
  }
}
```

##### Local Level

```java
public class Test {
  public static void main(String[] args) {
    int[] x;
    System.out.println(x); // CE: variable x might not have been initialized
    System.out.println(x[0]); // CE: variable x might not have been initialized
  }
}
```

```java
public class Test {
  public static void main(String[] args) {
    int[] x = new int[3];
    System.out.println(x); // [I@somehashcode
    System.out.println(x[0]); // 0
  }
}
```

**NOT:** Once we creates an array, every array element by default initialized with
default values respective of whether it is Instance, static or local array.

## Var-arg Methods
Variable number of argument methods. Came with Java version 1.5

Until 1.4 version we can not declare a method with the variable number of
arguments. If there is a change in number of arguments, compalsary we should go
for new method. It increases the length of the code and reduces readability. To
overcome this problem, Sun people introduced var-arg methods in 1.5V.
According to this, we can declare a method which can take variable number of
arguments, such type methods are called var-arg methods.

```java
public class Test {
  public static void main(String[] args) {
    sum(10,20);
    sum(10,20,30);
    sum(10,20,30,40);
    sum(10,20,30,40,50);
    sum(10,20,30,40,50,60);
    // how long this can go?
  }

  public static void sum(int a, int b) {
   System.out.println(a + b);
  }

  public static void sum(int a, int b, int c) {
   System.out.println(a + b + c);
  }
}
```

We can declare a var-arg method as follows:
We can call this method by passing any number of values including zero number.

```java
public class Test {
  public static void main(String[] args) {
    sum();
    sum(10,20);
    sum(10,20,30);
    sum(10,20,30,40);
    sum(10,20,30,40,50);
    sum(10,20,30,40,50,60);
  }

  public static void sum(int.. a) {
   int sum = 0;
   for (int number : a) {
     sum += number;
   }
   System.out.println(sum);
  }
}
```

Internally var-arg parameter will be converted into one-dimensional array, hence
within the var-arg method we can differentionate values by using index.

#### Case 1
Which of the followings are valid var-arg method declaritions?


```java
m1(int... x); // valid
m1(int ...x); // valid, space is ignored by compiler
m1(int...x);  // valid
m1(int x...); // invalid
m1(int. ..x); // invalid. three dots are best friends, cannot be separated
m1(int .x..); // invalid
```

#### Case 2
We can mix var-arg parameter with the normal parameter.

```java
m1(int x, int... y); // valid, at least one integer
m1(String s, double... y); // valid
```

#### Case 3
If we mix normal parameter with var-arg parameter, then var-arg parameter should
be last parameter.

```java
m1(double... x, String s); // invalid
m1(char ch, String... s); // valid
```

#### Case 4
Inside var-arg method we can take only one var-arg parameter, and we can not
take more than one var-arg parameter.

```java
m1(int... a, double... x); // invalid
```

#### Case 5
Inside a class we cannot declare var-arg method and correspending 1D array
simultaneously, otherwise we will get compile time error.

```java
public class Test {
  public static void method(int... x) {
    System.out.println("int...");
  }

  public static void method(int[] x) {
    System.out.println("int[]");
  }
}

// CE: cannot declare both method(int...) and method(int[]) in Test
```

#### Case 6
In general, var-arg method will get least priority, that is if no other method
matches, then only var-arg method will get the chance. It is exactly same as
default case inside switch.

```java
public class Test {
  public static void method(int... x) {
    System.out.println("var-arg method...");
  }

  public static void method(int x) {
    System.out.println("normal method");
  }

  public static void main(String[] args) {
    method(); // var-arg method being called
    method(10,20); // var-arg method being called
    method(10); // normal method, old concept always wins. backward compatibility
  }
}
```

##### Equivalance between var-arg parameter and 1D array

m1(int[] x) | m1(int... x)
----------- | ------------
m1(new int[]{1}) | valid
m1(new int[]{1,2}) | valid
m1(new int[]{1,2,3}) | valid
invalid | m1()
invalid | m1(1)
invalid | m1(1,2)

##### Case 1
Whereever 1D presents, we can replace with var-arg parameter.

m1(int[] x) ==> m1(int... x)

main(String[] args) ==> main(String... args)

###### Case 2
Whenever var-arg presents, we cannot replace with 1D array.

m1(int... x) ==> m1(int[] x) // INVALID


**NOT:**
- m1(int... x) can be called by passing int values, and x will become 1D array.

- m1(int[]... x) can be called by passing a group of 1D int array, and x will
  become 2D int array.

```java
public class Test {
  public static void main(String[] args) {
    int[] a = {10, 20, 30};
    int[] b = {40, 50, 60};
    m1(a, b);
  }

  public static void m1(int[]... x) {
    for (int[] x1 : x) {
      System.out.println(x1[0]); // 10, 40
    }
  }
}
```

## main Method

### Case 1
Whether class contains main method or not, and whether main method is declared
according to requirement or not, these things will not be checked by compiler.
At runtime JVM is responsible to check these things. If JVM is unable to find
main method, then we will get runtime exception: NoSuchMethodError:main.

```java
public class Test {

}
```

```shell
$ javac Test.java // compiles without a problem
$ java Test
Exception in thread "main" java.lang.NoSuchMethodError: main
```

### Case 2
At runtime JVM alywas search for main method with the following prototype:

- public static void main(String[] args)

* public: to call by JVM from anywhere
* static: without existing object also, JVM has to call this method
* void  : main method wont return anything to JVM
* main  : is the name configured inside JVM
* String[] args: command line arguments

The above syntax very strict and if we perform any change, then we will get
runtime exception saying: NoSuchMethodError:main.

Following changes are accepted:
  - static public (order of modifiers is not important)
  - main(String []args) (String args[])
  - main(String[] durga)
  - main(String... args)

### Case 3
We can declare main method with the following modifiers:
  - final
  - synchronized
  - strictfp

```java
static final synchronized strictfp public void main(String[] args) {
  System.out.println("Valid main method!");
}
```

#### Question
1. Which of the following main method declaritions are valid?

```java
public static void main(String args)  // invalid, should be String[]
public static void Main(String[] args)// invalid, no capital M
public void main(String[] args) // should be static
public static int main(String[] args) // should be void
final synchronized strictfp public void main(String[] args) // where is static?
final synchronized strictfp public static void main(String[] args) // valid
public static void main(String... args) // valid
```

2. In which of above cases we will get compile time error?
We wont get compile time error anywhere, but except last two cases in remaining
we will get runtime exception saying NoSuchMethodError:main.

### Case 4
Overloading of main method is possible. But JVM will always call String[]
argument main method only. The other overloaded method has be called explicitly
like a normal method call.

```java
public class Test {
  public static void main(String[] args) {
    System.out.println("String[]");
  }

  public static void main(int[] args) {
    System.out.println("int[]");
  }
}

// prints String[]
```

### Case 5
Inheritence concept is applicable for main method, hence while executing child
class if the child doesnt contain main method, then parent class main method
will be executed.

```java
class P {
  public static void main(String[] args) {
    System.out.println("Parent main");
  }
}

public class C extends P{
 public static void main(String[] args) {

 }
}
```

```shell
$ javac P.java // generates P.class and C.class
$ java P
Parent main
$ java C
Parent main
```


```java
class P {
  public static void main(String[] args) {
    System.out.println("Parent main");
  }
}

public class C extends P {
  // it is method hiding, not method overriding
  public static void main(String[] args) {
    System.out.println("Child main");
  }
}
```

```shell
$ javac P.java // generates P.class and C.class
$ java P
Parent main
$ java C
Child main
```

It seems overriding concept applicable for main method, but it is not overriding
and it is method hiding.

**NOT:** For main method, Inheritence and overloading concepts are applicable,
but overriding concept is not applicable. Instead of overriding, method hiding
is applicable.

### Java 7: main method enhancement
Until 1.6 version, if the class doesnt contain method main then we will get
runtime exception saying NoSuchMethodError:main. But from 1.7V onwards, instead
of that error, we will get more elaborated error information:

```java
public class Test {

}
```

```shell
// 1.6 version
$ javac Test.java
$ java Test
RE: NoSuchMethodError: main


// 1.7 version
$ javac Test.java
$ java Test
Error: Main method not found in class Test, please define the main method as:
public static void main(String[] args)
```

From 1.7V onwards, main method mandorty to start the program execution. Even
though class contains static block, it wont be executed if the class doesnt
contain main method.

```java
public class Test {
  static {
    System.out.println("static block");
  }
}
```

```shell
// 1.6 version
$ javac Test.java
$ java Test
static block
RE: NoSuchMethodError: main


// 1.7 version
$ javac Test.java
$ java Test # requires to have main method
Error: Main method not found in class Test, please define the main method as:
public static void main(String[] args)
```

```java
public class Test {
  static {
    System.out.println("static block");
    System.exit(0); // shut down JVM
  }
}
```

```shell
// 1.6 version
$ javac Test.java
$ java Test
static block # normal exit


// 1.7 version
$ javac Test.java
$ java Test # requires to have main method
Error: Main method not found in class Test, please define the main method as:
public static void main(String[] args)
```

```java
public class Test {
  static {
    System.out.println("static block");
  }

  public static void main(String[] args) {
    System.out.println("main method");
  }
}
```

The flow of program doesnt check, Java 7 just becomes sure of existing main
method.

```shell
// 1.6 version
$ javac Test.java
$ java Test
static block
main method


// 1.7 version
$ javac Test.java
$ java Test # requires to have main method
static block
main method
```

#### Java 1.6 Flow
- Identification of static members
- Execute static block, static variables assigments
- Check for main()
  - Execute main method
  - if not, RE: NoSuchMethodError:main

#### Java 1.7 Flow
- Check for main method
- if it is avaiable
  - identification of static members
  - execution static of variables assignments and static blocks
  - execute main method
- If not RE: Error

##### Question
Without writing main method, is it possible to print some statements to the
console?

Yes by using static block, but this rule is applicable until 1.6V. From Java 7
onwards it is impossible to print some statements to the console.

## Command Line Arguments
The arguments which are passing from command prompt are called command line
arguments. With these command line arguments JVM will create an array and by
passing that array as argument JVM will call main method.

```shell
$ java Test A B C

// arg[0] => A
// arg[1] => B
// arg[2] => C
```

The main objective of command line arguments is we can costumize the behaviour
of the main method.

##### Case 1
Within main method command line arguments are available in string form.

```java
public class Test {
  public static void main(String[] args) { // java Test 10 20
    System.out.println(args[0] + args[1]); // 1020
  }
}
```

##### Case 2
Usually space itself is the separator between command line arguments, if our
command line argument itself contains a space, then we have to enclose that
command line argument within double quotes.

```java
public class Test {
  public static void main(String[] args) { // java Test "note book"
    System.out.println(args[0]); // note book
  }
}
```

## Java Coding Standarts
Whenever we are writing java code, it is highly recommended to follow the coding
standarts. Whenever we are writing any component, its name should reflect the
purpose of that component(functionality). The main advantage of this approach is
readability and maintainalibility will be improved.

##### Bad 

```java
class A {
  public int m1(int x, int y) {
    return x + y;  
  }
}
```

##### Good 
- always define in a package
- it is not required any instance variable, define as static
- use class modifiers
- use meaningful names for class, methods and variables

```java
package com.selimssevgi.fundamentals;

public class Calculator {
  public static int add(int number1, int number2) {
    return number1 + number2;     
  }
}
```

### Coding Standarts for Class Names
Usually class names are nouns, should start with upper case characters and if it
contains multiple words, any inner word should start with upper case character.

```java
String
StringBuffer
Account
```

### Coding Standarts for Interface Names
Usually interfaces names are adjectives, should start with upper case character
and if it containes multiple words, any inner word should start with upper case
character.

```java
Runnable
Serializable
Comparable
```

### Coding Standarts for Method Names
Usually method names are either verbs or verb+name combination, should start
with lower case character and if it contains multiple words, any inner word
should start with upper case character(camel case convention).

```java
print()
sleep()
run()
start()

getName()
setSalary()
```

### Coding Standarts for Variable Names
Usually variable names are nouns, should start with lower case character and
if it contains multiple words, any inner word should start with upper case 
character(camel case convention).

```java
name
age
salary
mobileNumber
```

### Coding Standarts for Constants
Usually constant names are nouns, should contain only upper case characters and
if it contains multiple words, these words are separated with underscore symbol.

```java
MAX_VALUE
MAX_PRIORITY
NORM_PRIORITY
PI
```

**NOT:** Usually we can declare constant with public, static and final modifiers.

#### Java Bean Coding Standarts
A Java Bean is a simple class with private properties and public getter and
setter methods. 

Class name ending with Bean is not an official convention from Sun.

```java
public class StudentBean {
  private String name;

  public void setName(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }
}
```

#### Syntax for Setter Method
- It should be public
- Return type should be void
- Method name should prefix with 'set'
- Should take some argument, it should not be no argument method

#### Syntax for Getter Method
- It should be public
- Return type should not be void
- Method name should prefix with 'get'
- Should not take any argument

**NOT:** For boolean properties, getter method name can be prefix with either
get or is, but recommended to use 'is'.

```java
private boolean empty;

// valid
public boolean getEmpty() {
  return empty;  
}

// valid. more meaningful
public boolean isEmpty() {
  return empty;  
}
```

#### Coding Standarts for Listeners

##### Case 1: Register a Listener
Method name should be prefixed with 'add'.

```java
public void addMyActionListener(myActionListener l)  // valid
public void registerMyActionListener(myActionListener l) // invalid
public void addMyActionListener(ActionListener l) // invalid
```

##### Case 1: UnRegister a Listener
Method name should be prefixed with 'remove'.

```java
//TODO: myActionListener should start with upper case?
public void removeMyActionListener(myActionListener l)  // valid
public void unregisterMyActionListener(myActionListener l) // invalid
public void removeMyActionListener(ActionListener l) // invalid
public void deleteMyActionListener(myActionListener l) // invalid
```
