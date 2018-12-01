# Operators and Assignments

- Increment and Decrement Operators
- Arithmetic Operators
- String concatenation Operator
- Relational Operators
- Equality Operators
- instanceof Operator
- Bitwise Operators
- Short Circuit Operators
- Type Cast Operator
- Assignment Operators
- Conditional Operators
- new Operator
- [] Operator
- Operator Precendence
- Evaluation order of Operands
- new vs newInstance()
- instanceof vs isIntance()
- ClassNotFoundException vs NoClassDefFoundError

## Increment and Decrement Operators
Pre-increment(++x), Post-increment(x++)

Expression | initial value of x | value of y | final value of x
---------- | ------------------ | ---------- | ----------------
y = ++x;   | 10                 | 11         | 11
y = x++;   | 10                 | 10         | 11
y = --x;   | 10                 | 09         | 09
y = x--;   | 10                 | 10         | 09

We can apply increment and Decrement operators only for variables, but not for
constant values. If we are trying to apply for constant values, then we will get
compile time error.

```java
int x = 10;
int y = ++x;
System.out.println(y); // 11

int x = 10;
int y = ++ 10;
System.out.println(y); // CE: unexpected type. found: value, required: variable
```

Listing of increment and Decrement operators is not allowed. 

```java
int x = 10;
int y = ++ (++x); // ++11
System.out.println(y); // CE: unexpected type. found: value, required: variable
```

For final variables we cannot apply increment and Decrement operators.

```java
final int x = 10;
x++; // CE: cannot assign a value to a final variable
```

We can apply increment and Decrement operators for every primitive type except
boolean.


```java
int x = 10;
System.out.println(++x);   // 11

char ch = 'a';
System.out.println(++ch);  // b

long l = 100L;
System.out.println(++l);   // 101

double d = 10.5;
System.out.println(++d);   // 11.5

float f = 10.5f;
System.out.println(++f);   // 11.5

boolean b = false;
System.out.println(++b);   // CE: operator ++ cannot be applied to boolean
```

### Difference between b++ and b = b + 1
If we apply any Arithmetic operator between two variables a and b, the result
type is always max(int, type of a, type of b).


```java
byte a = 10;
byte b = 20;
byte c = a + b; // max(int, byte, byte), CE: possible loss of precision

byte c = (byte) a + b;
```

```java
byte a = 10;
b = b + 1; // CE: PLP. f: int r: byte. max(int, byte, int)
b = (byte) b + 1;
System.out.println(b); // 11
```
But in the case of increment and Decrement operators, internal type casting will
be performed automatically.

```java
byte a = 10;
b++; // b = (type of b) b + 1; // b = (byte) b + 1;
System.out.println(b); // 11
```

## Arithmetic Operators (+, -, \*, /, %)
If we apply any Arithmetic operators between two variables a and b, the result
type is always max(int, type of a, type of b).

- byte + byte = int
- byte + short = int
- short + short = int
- byte + long = long
- long + double = double
- float + long = float
- char + char = int
- char + double = double


```java
System.out.println('a' + 'b'); // 195
System.out.println('a' + 0.89); // 97.89
```

#### Infinity
In integral Arithmetic(byte,short,int,long) there is no way to represent
Infinity. Hence, if Infinity is the result, we will get ArithmeticException in
integral Arithmetic. 

```java
System.out.println(10 / 0); // RE: ArithmeticException : / by zero
```

But in floating-point arithmetic(float,double) there is a way to represent a way
to represent infinity. For this Float and Double classes contains the following
two constants. Hence, even though the result is infinity, we wont get any
ArithmeticException in the floating-point arithmetic.

```java
// in Double.class
public static final Double POSITIVE_INFINITY = 1.0 / 0.0;
public static final Double NEGATIVE_INFINITY = -1.0 / 0.0;
```

```java
System.out.println(10 / 0.0); // infinity
System.out.println(-10 / 0.0); // negative infinity
```

### NaN (Not-a-Number)
In integral arithmetic(byte,short,int,long) there is no way to represent
undefined results. Hence, if the result is undefined, we will get 
ArithmeticException in integral Arithmetic. 

```java
System.out.println(0 / 0); // RE: ArithmeticException : / by zero
```

But in floating-point arithmetic(float,double) there is a way to represent a way
to represent undefined results. For this Float and Double classes contains NaN
constant. Hence, even though the result is undefined, we wont get any
ArithmeticException in the floating-point arithmetic.

```java
// in Double.class
public static final Double NaN = 0.0d / 0.0;

System.out.println(0.0 / 0); // NaN
System.out.println(-0 / 0.0); // NaN
```

**NOTE:** For any x value including NaN the following expressions returns false.

```java
System.out.println(x <  Float.NaN); // false
System.out.println(x <= Float.NaN); // false
System.out.println(x >  Float.NaN); // false
System.out.println(x >= Float.NaN); // false
System.out.println(x == Float.NaN); // false
System.out.println(Float.NaN == Float.NaN); // false
```

For any x value including NaN the following expression returns true.

```java
System.out.println(x !=  Float.NaN); // true
System.out.println(10 !=  Float.NaN); // true
System.out.println(Float.NaN !=  Float.NaN); // true
```

### ArithmeticException 
- It is runtime exception, but not compile time exception.
- It is possible only in integral arithmetic, but not in floating-point arith.
- Only operators which cause AE are / and %.

## String Concatenation Operator(+)
The only overloaded operator in Java is + operator. Sometimes it acts as
arithmetic addition operator, and sometimes it acts as string concatenation
operator.

```java
10 + 30 = 40 // arithmetic operator
"ab" + "cd" = "abcd" // concatenation operator
```

If at least one argument is String type, then + operator acts as concatenation
operator. And if both arguments are number type, then + operator acts arithmetic
addition operator.

```java
String a = "durga";
int b = 10;
int c = 20;
int d = 30;

// left to right
System.out.println(a + b + c + d); // durga102030
// "durga" + 10 = durga10
// "durga10" + 20 = durga1020
// "durga1020" + 30 = durga102030
System.out.println(b + c + d + a); // 60durga
System.out.println(b + c + a + d); // 30durga30
System.out.println(b + a + c + d); // 10durga2030
```

```java
String a = "durga";
int b = 10;
int c = 20;
int d = 30;

a = b + c + d; // a = 60; CE: incompatible types. f:int r:j.l.String
a = a + b + c; // a = "durga1020"; valid
b = a + c + d; // b = "durga2030"; CE: incompatible type: f:j.l.String r: int
b = b + c + d; // b = 60; // valid
```

## Relational Operators ( <, <=, >, >= )
We can apply relational operators for every primitive type except boolean.

```java
System.out.println(10 < 20);     // true
System.out.println('a' < 10);    // promotion. 97 < 10, false
System.out.println('a' < 97.6);  // promotion. 97.0 < 97.6, true
System.out.println('a' > 'A');   // 97 > 65, true
System.out.println(false > true);// CE: operator > cannot be applied to bl, bl

```

We cannot apply relational operators for object types.

```java
System.out.println("durga1" > "durga"); // CE: operator > cannot be applied to
j.l.String, j.l.String
```

Listing of operator operators is not allowed. Otherwise we will get CE.

```java
System.out.println(10 < 20 < 30); // true < 30. CE: to applied to boolean, int
j.l.String, j.l.String
```

## Equality Operators( ==, != )
We can apply Equality operators for every primitive type including boolean type
also. 

```java
System.out.println(10 == 20); // false
System.out.println('a' == 'b'); // false
System.out.println('a' == 97.0); // promotion. true
System.out.println(false == false); // true
```

We can apply equality operators for object type also. For object references
r1 == r2 returns true if and only if both references pointing to the same
object.(reference comparision or address comparision)

```java
Thread t1 = new Thread(); // a new variable, a new object
Thread t2 = new Thread(); // a new variable, a new object
Thread t3 = t1; // a new variable, pointing to existing object
System.out.println(t1 == t2); // false
System.out.println(t1 == t3); // true
```

If we apply equality operators for object types, then compalsry there should be
some relation between argument types.(either child to parent or parent to child
or same type). Otherwise we will get CE: incompatible types.

```java
Thread t = new Thread(); 
Object o = new Object();
String s =  new String();
System.out.println(t == o); // false
System.out.println(0 == s); // false
System.out.println(t == s); // CE: incompatible types: j.l.Thread and j.l.String
```

#### Difference b/w == operator and .equals() method
In general we can use == operator for reference comparision(address comparision)
and .equals() method for content comparision.


```java
String s1 = new String("durga");
String s2 = new String("durga");
System.out.println(s1 == s2); // false, different objects
System.out.println(s1.equals(s2)); // true, same content
```

**NOTE:** For any object reference r, r == null is always false.
But null == null is always true.

```java
String s = new String("durga");
System.out.println(s == null); // false

String s = null;
System.out.println(s == null); // true

System.out.println(null == null); // true
```

## instanceof Operator
We can use instanceof operator to check whether the given object is of a
particular type or not.

```java
Object o = l.get(0);

if (o instanceof Student) {
  Student s = (Student) o;
  // perform Student specific functionality
} else if (o instanceof customer) {
  Customer c = (Customer) o;
  // perform Customer specific functionality
}
```

#### Syntax of instanceof

- r instanceof x
  r -> object reference
  x -> a class or interface name

```java
Thread t = new Thread();

System.out.println(t instanceof Thread); // true
System.out.println(t instanceof Object); // true
System.out.println(t instanceof Runnable); // true
```

To use instaceof operator compalsry there should be some relation between
argument types(c to p, p to c, or same type). Otherwise we will get
CE: inconvertable type.

```java
Thread t = new Thread();

System.out.println(t instanceof String); // CE: inconvertable types. f:Thread r:
String
```

**NOTE:** For any class or interface x, (null instanceof x) is always false.

```java
System.out.println(null instanceof String);  // false
System.out.println(null instanceof Thread);  // false
System.out.println(null instanceof Object); // false
```

## Bitwise Operators ( &, |, ^ )
& (AND) -> Returns true if both arguments are true
| (OR)  -> Returns true if at least one argument is true
^ (XOR) -> Returns true if both arguments are different

```java
System.out.println(true & true);  // true
System.out.println(true | false);  // true
System.out.println(true ^ false); // true
```
We can apply these operators for integral types(byte, short, int, long) also.

```java
System.out.println(4 & 5);  // 4 -> 100
                            // 5 -> 101
                            // & -> 100 // 4
System.out.println(4 | 5);  // 101 -> 5
System.out.println(4 ^ 5);  // 001 -> 1
```

### Bitwise Complement Operator( ~ )
We can apply this operator only for integral types but not for boolean type. If
we are trying to apply for boolean type, then we will get compile time error.

```java
System.out.println(~true);  // CE: operator ~ cannot be applied to boolean
```

```java
System.out.println(~4); // 4 -> 100

// 4 is integer
// 32 bit in the memory
// 000000...0100
// most left/significant bit is sign bit: positive
// ~ negate the bit
// 111111...1011
// now most significant bit is 1, which means negative
// two find the real value, we have to apply two's complement
// 000000...0100 (negate all bit)
//             1 (add one)
// -------------
// 000000...0101 => 5, and it is negative
// -5
```

The most significant bit acts as sign bit. 0 means positive, 1 means negative
number. Positive numbers will be represented directly in the memory. Negative
numbers will be repsented indirectly in the memory in two's complement form.

### Boolean Complement Operator( ! )
We can apply this operator only for boolean types, but not for integral types.

```java
System.out.println(!4);  // CE: operator ~ cannot be applied to int
System.out.println(!false); // true
```

&, |, ^ -> applicable for both boolean and integral types
~ -> applicable only for integral types
! -> applicable only for boolean type

### Short-Circuit Operators(&&, ||)
These are exactly same as bitwise operators(&, |) except the following
differences:

- Bitwise Operators
  - Both arguments should be evaluated always.
  - Relatively performance is low.
  - Applicable for both boolean and integral types.

- Short-Circuit Operators
  - Second argument evaluation is optional.
  - Relatively performance is high.
  - Applicable only for boolean, but not for integral types.

**NOTE:**
- (x && y): y will be evaluated if only if x is true. That is if x is
false, then y wont be evaluated.

- (x || y): y will be evaluated if and only if x is false. That is if x is true,
then y wont be evaluated.

```java
int x = 10;
int y = 15;

if (+xx < 10 & ++y > 15) { // both sides will be evaluated x = 11, y = 16 false & true
if (+xx < 10 | ++y > 15) { // both sides will be evaluated x = 11, y = 16 false | true
if (+xx < 10 && ++y > 15) { // x = 11 false, second part wont be evaluated
if (+xx < 10 || ++y > 15) { // x = 11 false, y = 16 true : false || true
  x++;
} else {
  y++;
}
```

If we replace && with &, then RE: ArithmeticException : / by zero

```java
int x = 10;

if (++x < 10 && (x/0 > 10)) { // first part is false, second part wont be evaluated
  System.out.println("hello");
} else {
  System.out.println("hi"); // will be executed
}
```

## Type-Cast Operator
There are two types of type casting. 
  - Implicit Type-Casting
  - Explicit Type-Casting

### Implicit Type-Casting
1. Compiler is responsible to perform Implicit type-casting.
2. Whenever we are assigning smaller data type variable to bigger data type
   variable Implicit type-casting will be performed.
3. It is also known as widening or upcasting.
4. There is no loss of information in this type-casting.
5. The following are various possible conversion where Implicit type-casting
   will be performed.

   byte --> short
                 \
                  \
                   --> int --> long --> float --> double
                 /
                /
          char /

```java
int x = 'a'; // internally compiler converts char to int by Implicit type-cast
System.out.println(x); // 97

double d = 10; // int -> double by compiler
System.out.println(d); // 10.0

```

### Explicit Type-Casting
1. Programmer is responsible to perform explicit type-casting.
2. Whenever we are assigning a bigger data type value to smaller data type, then
   explicit type-casting is required.
3. It is also known as narrowing or downcasting.
4. There may be a change of loss of information in this type-casting.
5. The following are various possible conversion where Implicit type-casting
   will be performed.

   byte <-- short
                 \
                  \
                   <-- int <-- long <-- float <-- double
                 /
                /
          char /

```java
int x = 130;
byte b = x; // CE: possible loss of precision, f: int required: byte
byte b = (byte) x;
System.out.println(b); // -126

// 0000....010000010 : 130 : int : 32 bit:
// downcasting to byte, least significant 8 bits will be taken
// 10000010 : 8 bit: 1 is negative sign
// find real value by taking 2' complement
// 0000010 (taken 7 bits as value)
// 1111101 (negate)
//       1 (add one)
// --------
// 1111110 126 : -126
```

Whenever we are assigning a bigger data type value to smaller data type by
explicit type-casting. The most significant bits will be lost. We have to
consider ony LSB(least significant bits).

```java
int x = 150;
short s = (short) x;
// 0000....010010110 : 150 : int : 32 bit:
// take 16 bits
// 00000..010010110 : sign bit is 0 : positive : 150
System.out.println(s); // 150

byte b = (byte) x;
// 0000....010010110 : 150 : int : 32 bit:
// downcasting to byte, least significant 8 bits will be taken
// 10000010 : 8 bit: 1 is negative sign
// find real value by taking 2' complement
// 0010110 (taken 7 bits as value)
// 1101001 (negate)
//       1 (add one)
// --------
// 1101011 106 : -106
System.out.println(b); // -106 (150 - 128 = 22 : 128 - 22 = 106)
```

If we assign float-point values to the integral types by explicit type-casting,
the digits after decimal point will be lost.

```java
double d = 130.456;
int x = (int) d;
System.out.println(x); // 130

byte b = (byte) d;
System.out.println(b); // -126
```

## Assignment Operators
There are three types of assignment operators. 

1. Simple Assignment
   - int x = 10;

2. Chained Assignment

```java
int a, b, c, d;
a = b = c = d = 20;
System.out.println(a + ".." + b + ".." + c+ ".." + d); // 20..20..20..20
```

We cannot perform chained assigment directly at the time of declarition.

```java
int a = b = c = d = 20; // CE: cannot find symbol. symbol variable b

int c, d, d;
int a = b = c = d = 20; // valid
```

3. Compound Assignment
Sometimes assigned operator is mixed with some other assignments, such type
assignment operators called compound assignment. 

```java
int a = 10;
a += 20;
System.out.println(a); // 30

// +=, -=, *=, /=
// &=, |=, ^=
// >>=
// <<=
// Unsigned shift operator: fill with 0 : >>>=
// no such operator : <<<=
```

In the case of compound assignment operators, internall type-casting will be
performed automatically.

```java
byte b = 10;
b = b + 1; // CE: possible loss of precision, f:int r:byte

byte b = 10;
b++; // internal type-casting
System.out.println(b); // 1

byte b = 10;
b += 1; // b = (byte) b + 1; internall type-casting performed
System.out.println(b); // 11

byte b = 127;
b += 3; // b = (byte) (b + 3); internall type-casting performed
System.out.println(b); // -126
```

```java
int a, b, c, d;
a = b = c = d = 20;

a += b -= c *= d /= 2; // valid. from right to left
// a += b -= c *= 10; // d = 10
// a += b -= 200;     // c = 200
// a += -180;         // b = -180
// a = -160;         // a = -160
```

## Conditional Operator(?:)
The only possible ternary operator in Java is conditional operator.

#### Syntax

```java
int x = (10 < 20) ? 30 : 40;
System.out.println(x); // 30
```


We can perform nesting of conditional operator also.

```java
int x = (10 > 20) ? 30 : ((40 > 50) ? 60 : 70);
System.out.println(x); // 70
```

## new Operator
We can use new operator to create object.

```java
Test t = new Test();
```

**NOTE:** After creating an object, constructor will be executed to perform
initialization of the object. Hence constructor is not for creation of object.
And it is for initialization of an object.

**NOTE:** In java we have only new keywords, but not delete keywords. Because 
destruction of useless object is responsibility of GC.

## [] Operator
We can use this operator to declare and create arrays.

```java
int[] x = new int[10];
```

## Java Operator Precedence
1. Unary Operators
   - [], x++, x--
   - +xx, --x, ~, !
   - new, <type>

2. Arithmetic Operators
   - \*, /, %
   - +, -

3. Shift Operators
   - >>, >>>, <<

4. Comparison Operators
   - <, <=, >, >=, instanceof

5. Equality Operators
   - ==, !=

6. Bitwise Operators
   - &
   - ^
   - |

7. Short-Circuit Operators
   - &&
   - ||

8. Conditional Operators
   - ?:

9. Assignment Operators
   - =, +=, -= ... 

## Evaluation Order of Java Operands
In Java we have only operator precedence, but not operand precedence. Before
applying any operator, all operands will be evaluated from left to right.

```java
public class Test {
  public static void main(String[] args) {
    System.out.println(m1(1) + m1(2) * m1(3) / m1(4) + m1(5) * m1(6));
    // first evaluate all operand
    // 1 + 2 * 3 / 4 + 5 * 6
    // 1 + 6 / 4 + 5 * 6
    // 1 + 1 + 5 * 6 // integral division
    // 1 + 1 + 30 = 32
    // program output:
    // 1
    // 2
    // 3
    // 4
    // 5
    // 6
    // 32
  } 

  public static int m1(int i) {
    System.out.println(i);  
    return i;
  }
}
```

## new vs newInstance()
We can use new operator to create an object if we know the class name at the
beginning.

```java
Test t = new Test();
Student s = new Student();
```

newInstance() is a method present in Class class. We can use newInstance()
method to create an object if we do not know the class name at the beginning and
it is available dynamically at the runtime.

```java
class Student {}
class Customer {}

class Test {
  public static void main(String[] args) throws Exception {
    Object o = Class.forName(args[0]).newInstance();
    System.out.println("Object created for : " + o.getClass.getName());
  }  
}

// java Test Customer
// Object created for : Customer
// java Test java.lang.String
// Object created for : java.lang.String
```

In the case of new operator, based on our requirement we can invoke any
constructor.

```java
Test t = new Test();
Test t = new Test(10);
Test t = new Test("durga");
```

But newInstance() method internally calls no-arg constructor, hence to use
newInstance() method compalsry corresponding class should contain no-args
constructor. Otherwise we will get RE: InstantiationException

While using new operator, at runtime if the corresponding .class file not
available then we will get RE: NoClassDefFoundError

```java
Test t = new Test();
// RE: NoClassDefFoundError: Test
```

While using newInstance() method, at runtime if the corresponding .class file is
not available then we will get RE: ClassNotFoundException.

```java
Object o = Class.forName(args[0]).newInstace();
// java Test Test112233 // if Test112233 not available at runtime
// RE: ClassNotFoundException : Test112233 
```

### Differences Between new and .newInstance()

- new
  - It is operator in Java
  - Can be used to create an object if we know class name at the beginning
  - Class not required to contain no-arg constructor.
  - RE: NoClassDefFoundError

- .newInstance()
  - It is a method present in java.lang.Class
  - Can be used to create an object if we dont know class name at the beginning
    and it is available at runtime
  - Compalsary class should contain no-arg constructor.
  - RE: ClassNotFoundException


## Difference Between ClassNotFoundException and NoClassDefFoundError
For hard-coded class names, at runtime if the corresponding .class file is not
available, then we will get runtime exception saying NoClassDefFoundError. Which
is unchecked.

At runtime if the Test.class is not available, then we will get RE:
NoClassDefFoundError : Test.

```java
Test t = new Test();
// RE: NoClassDefFoundError: Test
```

For dynamically provided class names, at runtime if the corresponding .class
file is not available, then we will get runtime exception saying
ClassNotFoundException. Which is checked exception.

```java
Object o = Class.forName(args[0]).newInstace();
// java Test Test112233 // if Test112233 not available at runtime
// RE: ClassNotFoundException : Test112233 
```

At the runtime if Test112233.class file is not available, then we will get
runtime exception saying ClassNotFoundException : Test112233.

## instanceof vs isIntance()
instanceof is an operator in Java, we can use instanceof to check whether the
given object is of particular type or not. And we know that type at the
beginning.

```java
Thread t = new Thread();
System.out.println(t instanceof Runnable); // true
System.out.println(t instanceof Object); // true
```

isIntance() is a method present java.lang.Class. WE can use isIntance() method
to check whether the given Object is of particular type or not. And we dont know
the type at the beginning, it is available dynamically at runtime.

```java
public class Test {
  public static void main(String[] args) throws {
    Thread t = new Thread();
    System.out.println(Class.forName(args[0]).isIntance(t));
  }
}

// java Test java.lang.Runnable
// true
// java Test java.lang.String
// false
```

isIntance() method is method equvalient of instanceof operator.
