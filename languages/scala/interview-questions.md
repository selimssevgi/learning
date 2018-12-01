# Scala Interview Questions

- 23, 25, 26
- advanced: 2

## Basic
1. *What is Scala? Who is the father of Scala?*
Scala stands for SCAlable LAnguage. Martin Odersky is the father of Scala.

2. *Is it a Language or Platform? Does it support OOP or FP?*
Scala is a Multi-Paradigm Programming Language, which supports both OO and FP
concepts. It is designed and developed by Martin Odersky.

Scala is a Type-Safe Object-Functional Programming JVM Language.

Scala is a Hybrid Functional (Object-Oriented and Functional) Programming JVM Language.
Scala has a Strong and Statically Type System.
In Scala, all types are checked at compile-time.

3. *Is Scala statically-typed language?*
Yes.

4. *What is Statically-Typed Language and What is Dynamically-Typed Language?
   What is the difference between statically typed and dynamically typed languages?*
Statically-Typed Language means that type checking is done at compile-time by compiler, not at run-time.
The main Advantage of these kinds of Languages is: As a Developer,
we should care about writing right code to avoid all compile-time errors.
As Compiler checks many of the errors at compile-time, we don’t get much issues or bugs at run-time.

Examples:- Java, Scala, C, C++, Haskell etc.

Dynamically-Typed Language means that type checking is done at run-time, not at compile-time by compiler.
As a compiler won’t check any type checking at compile-time, we can expect more run-time issues or bugs.

Example:- Groovy, JavaScript, Ruby, Python, Smalltalk etc.

5. *Is Scala a Pure OOP Language? Is Java a Pure OOP Language?*
Pure Object-Oriented Programming Language means that everything should be an Object.

Java is not a Pure Object-Oriented Programming (OOP) Language,
because it supports the following two Non-OOP concepts:

- Java supports primitive data types. They are not objects.
- Java supports Static members. They are not related to objects.

Yes, Scala is a Pure Object-Oriented Programming Language because in Scala,
everything is an Object and everything is a value. Functions are values and values are Objects.

Scala does not have primitive data types and also does not have static members.

6. *Does Scala support all Functional Programming concepts?
   Does Java 8 support all Functional Programming concepts?*

Yes, Scala supports all Functional Programming (FP) concepts.
Java 8 has introduced some Functional Programming constructs,
but it does NOT support all Functional Programming concepts.

For instance, Java 8 does not support Pattern Matching, Function Currying, Implicits etc.

7. *What are the major advantages of Scala Language? Are there any drawbacks of Scala Language?*

Advantages of Scala Language:-

- Simple and concise code
- Very expressive code
- More readable code
- %100 type-safe language
- Immutability and no side-effects
- More reusable code
- More modularity
- Do more with less code
- Very flexible syntax
- Supports all OOP features
- Supports all FP features
- Less error prone code
- Better parallel and concurrency programming
- Highly scalable and maintainable code
- Highly productivity
- Distributed Applications
- Full java interoperability
- Powerful Scala DSL available
- REPL to learn Scala basics

Drawbacks of Scala:

- Less readable code
- Bit tough to understand the code for beginners
- Complex syntax to learn
- Less backward compatibility

NOTE:- We can write Scala Code either more readable or less readable way.

8. *What is the Main drawback of Scala Language?*
Apart from many benefits of Scala, it has one major Drawback: Backward Compatibility Issue.
If we want to upgrade to latest version of Scala,
then we need to take care of changing some package names, class names, method or function names etc.

For instance, If you are using old Scala version and your project is using BeanProperty annotation.
It was available in “scala.reflect” like “scala.reflect.BeanProperty” in old versions.
If we want to upgrade to new Scala versions, then we need to change this package from “scala.reflect” to “scala.beans”.

9. *What is the main motto of Scala Language?*
Like Java’s Motto “Write Once Run Anywhere”, Scala has “Do More With Less” or “Do More With Less Code” Motto.
“Do More With Less” means that we can develop more complex program or logic with less code.

10. *What are the popular JVM Languages available now?*
Java, Scala, Groovy and Closure are most popular JVM (Java Virtual Machine) languages.

Scala, Groovy and Closure JVM languages supports both OOP and FP concepts.

Java SE 8 supports all Object-Oriented Programming Features.
However, it supports very few Functional Programming Features like Lambda Expressions, Functions, Type Inference, Higher-Order Functions.

11. *Like Java’s java.lang.Object class, what is the super class of all classes in Scala?*
As we know in Java, the super class of all classes is java.lang.Object.
In the same way in Scala, the super class of all classes or traits is “Any” class.

Any class is defined in scala package like “scala.Any”.

12. *What is default access modifier in Scala? Does Scala have “public” keyword?*
If we don’t mention any access modifier to a method, function,trait,object, class,
the default access modifier is “public”. Even for Fields also, “public” is the default access modifier.

Because of this default feature, Scala does not have “public” keyword.

13. *What is “Type Inference” in Scala?*
Types can be inferred by the Scala Compiler at compile-time. It is known as “Type Inference”.
Types means Data type or Result type. We use Types at many places in Scala 
programs like Variable types, Object types, Method/Function Parameter types, Method/Function return types etc.

In simple words, determining the type of a variable or expression or object
etc at compile-time by compiler is known as “Type Inference”.

14. *What are the similarities and differences between Scala’s Int and Java’s java.lang.Integer?*

Similarities between Scala’s Int and Java’s java.lang.Integer:

- Both are classes.
- Both are used to represent integer numbers.
- Both are 32-bit signed integers.

Differences between Scala’s Int and Java’s java.lang.Integer:

- Scala’s Int class does not implement Comparable interface.
- Java’s java.lang.Integer class implements Comparable interface.

15. *What is the relationship between Int and RichInt in Scala?*
Java’s Integer is something similar to Scala’s Int and RichInt.
RichInt is a final class defined in scala.runtime package like “scala.runtime.RichInt”.

The Relationship between Int and RichInt is that when we use Int in a Scala program,
it will automatically convert into RichInt to utilize all methods available in that Class.
RichInt is an Implicit class of Int.

16. *What is Nothing in Scala? What is Nil in Scala? What is the relationship between Nothing and Nil in Scala?*
Nothing is a type (final class).
It is defined at the bottom of the Scala Type System that means it is a subtype of anything.
There are no instances of Nothing.

Use cases of Nothing:

- Nil is defined using Nothing
- None is defined using Nothing, [object None extends Option[Nothing]]
- We can use Nothing as return type of methods which never return.
- We can use Nothing as return type of methods which terminates abnormally.

Nil is an object, which is used to represent an empty list.
It is defined in “scala.collection.immutable” package as shown below:

- object Nil extends List[Nothing]

17. *What is Null in Scala? What is null in Scala? What is difference between Null and null in Scala?*
- Null is a type(final class).
- Null type is available in scala.Null
- It has one and only one instance that is null.
- In Scala, null is an instance of type scala.Null type.

- val myNullRef: Null = null
- We cannot assign other values to Null type references, it accepts only 'null'
- Null is a subtype of all reference types.
- Null is at the bottom of scala type system.
- As it is not a subtype of value types.
- val myInt: Int = null //ERROR

18. *What is Unit in Scala? What is the difference between Java’s void and Scala’s Unit?*
- Unit is used to represent 'no value' or 'no useful value'.
- Unit is a final class defined in scala.Unit
- Unit is something similar to Java's void. But there are few differences:
  - Java's void doesnt have any value. It is nothing.
  - Scala's Unit has one value: ()
  - () is one and only one value of type Unit.
  - Java's void is a keywords, Scala's Unit is a class.

19. *How do we implement loops functionally? What is the difference between OOP and FP style loops?*
We know how to implement loops in Object-Oriented style:
using mutable temporary variables, update the variable value and use loop constructs.
It is very tedious and unsafe approach. It is not Thread-Safe.

Object-Oriented style uses the following constructs to implement Loops:

- Loop Constructs
- Mutability
- Side Effects

We can implement same loops differently in Functional way. It is Thread-Safe.
We can use the following two techniques to implement the loops in functional style:

- Recursion
- Tail-Recursion
- Immutability
- No Side-Effects

20. *What is “Application” in Scala or What is Scala Application? What is “App” in Scala? What is the use of Scala’s App?*
Scala Application:
In Scala, App is a trait defined in scala package like “scala.App”.
It defines main method. If an Object or a Class extends this trait,
then they will become as Scala Executable programs automatically because
they will inherit main method from Application.

The main advantage of using App is that we don’t need to write main method.
The main drawback of using App is that we should use same name “args” to refer
command line argument because scala.App’s main() method uses this name.

Before Scala 2.9, we have scala.Application trait. But it is deprecated by scala.App since Scala 2.9 version.

```scala
object MyApp {
  def main(args: Array[String]) { println("Hello") }
}
```

```scala
object MyApp extends App {
  println("Hello")
}
```

21. *Does Scala support Operator Overloading? Does Java support Operator Overloading?*
Java does not support Operator Overloading. Scala supports Operator Overloading.

The reason is that Java does not want to support some misleading method names like “+-/”.
Scala has given this flexibility to Developer to decide which methods/functions name should use.

When we call 2 + 3 that means ‘+’ is not an operator,
it is a method available in Int class (or it’s implicit type).
Internally, this call is converted into “2.+(3)“.

22. *Is Scala an Expression-Based Language or Statement-Based Language? Is Java an Expression-Based Language or Statement-Based Language?*
In Scala, everything is a value. All Expressions or Statements evaluates to a Value.
We can assign Expression, Function, Closure, Object etc. to a Variable.
So Scala is an Expression-Oriented Language.

In Java, Statements are not Expressions or Values.
We cannot assign them to a Variable. So Java is not an Expression-Oriented Language.
It is a Statement-Based Language.

23. *Tell me some features which are supported by Java, but not by Scala and Vice versa?*
- Java does not support Operator Overloading, but Scala supports it.
- Java supports ++ and — operators , but Scala does not support them.
- Java has Checked and Unchecked Exceptions, but Scala does not have Checked Exceptions.
- Scala does not support break and continue statements, but Java uses them.
- Scala does not have explicit Type casting, but Java supports this feature.
- Scala supports Pattern Matching, but Java does not.
- Java uses Primitive Data types, but Scala does not have.
- Java supports static members, but Scala does not have static members concept.
- Scala supports Implicits and Traits, Java does not support them.
- Java lets at-most one public class/interface in a source file, in Scala no limit

24. *Like Java, what are the default imports in Scala Language?*
java.lang is the default package imported.We don’t need to import this package explicitly.

In the same way, the following are the default imports available in all Scala Programs:

- java.lang package
- scala package
- scala.PreDef

25. *How many operators are there in Scala and Why?*
- Unlike Java and like C++, Scala supports Operator Overloading. 
- Scala has one and only operator that is “=” (equalto) operator.
- Other than this all are methods only.

For instance 2 + 3, here “+” is not an Operator in Scala.
“+” is method available in Int class.
Scala Compiler observes 2 and 3 are Integers and tries to find that “+” method in Int class.
So Scala Compiler converts “2 + 3” expression into “2.+(3)” and make a call to
“+” method on integer object “2” and pass integer object “3” as parameter to “+” method.

Both “2 + 3” and “2.+(3)” are equal. It’s just Scala’s syntactic sugar to write programs in Functional style.

26. *Mention Some keywords which are used by Java and not required in Scala? Why Scala does not require them?*
Java uses the following keywords extensively:

- ‘public’ keyword – to define classes, interfaces, variables etc.
- ‘static’ keyword – to define static members.

Scala does not required these two keywords. Scala does not have ‘public’ and ‘static’ keywords.

Default A.M is ‘public’ for classes,traits, methods/functions, fields etc.
That’s why, ‘public’ keyword is not required.
To support OOP principles, Scala team has avoided ‘static’ keyword.
That’s why Scala is a Pure-OOP Langauge. It is very tough to deal static members in concurrency applications.

27. *What is PreDef in Scala? What is the main purpose of PreDef in Scala?*
- PreDef is an object defined in scala package as “scala.PreDef”.
- It is an utility object.

It defines many utility methods as shown below:

- Console IO (print,println etc)
- Collection utility methods
- String utility methods
- Implicit conversion methods
- Assertion utility methods etc.

For instance, print, println, readLine, readInt, require etc methods are defined in PreDef object.

PreDef is available to use its methods without importing in all Scala Programs
because Scala Compiler imports this object into all compilation units like Class, Object, Trait etc. automatically.

## Intermediate

 1. *What is Primary Constructor? What is Secondary or Auxiliary Constructor in Scala?*
 2. *What is the use of Auxiliary Constructors? Explain rules in defining them?*
 3. *What are the differences between Array and ArrayBuffer in Scala?*
 4. *What is case class? What is case object? What are the advantages of case class?*
 5. *What is the difference between Case Object and Object(Normal Object)?*
 6. *When compare to Normal Class, What are the major advantages or benefits of a Case-class?*
 7. *What is the usage of isInstanceOf and asInstanceOf methods in Scala? Is there anything similar concept available in Java?*
 8. *How do you prove that by default, case object is serializable and normal object is not?*
 9. *Difference between Array and List in Scala?*
10. *What is the difference between “val” and “lazy val” in Scala? What is Eager Evaluation? What is Lazy Evaluation?*
11. *What is the relationship between equals method and == in Scala? Differentiate Scala’s == and Java’s == operator?*
12. *Difference between Scala’s Inner class and Java’s Inner class?*
13. *What is Diamond Problem? How Scala solves Diamond Problem?*
14. *Why Scala does NOT have “static” keyword? What is the main reason for this decision?*
15. *What is the use of “object” keyword in Scala? How to create Singleton objects in Scala?*
16. *How to define factory methods using object keyword in Scala? What is the use of defining factory methods in object?*
17. *What is apply method in Scala? What is unapply method in Scala? What is the difference between apply and unapply methods in Scala?*
18. *How does it work under-the-hood, when we create an instance of a Class without using ‘new’ keyword in Scala? When do we go for this approach?*
19. *How do we declare a private Primary Constructor in Scala? How do we make a call to a private Primary Constructor in Scala?*
20. *Does a companion object access private members of it’s companion class in Scala?*
21. *What is the main design decision about two separate keywords: class and object in Scala? How do we define Instance members and Static members in Scala?*
22. *What is object in Scala? Is it a singleton object or instance of a class?*
23. *What is a Companion Object in Scala? What is a Companion Class in Scala? What is the use of Companion Object in Scala?*
24. *How to implement interfaces in Scala?*
25. *What is Range in Scala? How to create a Range in Scala?*
26. *How many values of type Nothing have in Scala?*
27. *How many values of type Unit have in Scala?*
28. *What is a pure function?*
29. *In FP, what is the difference between a function and a procedure?*
30. *What are the major differences between Scala’s Auxiliary constructors and Java’s constructors?*
31. *What is the use of ‘yield’ keyword in Scala’s for-comprehension construct?*
32. *What is guard in Scala’s for-comprehension construct?*
33. *How Scala solves Inheritance Diamond Problem automatically and easily than Java 8?*
34. *In Scala, Pattern Matching follows which Design Pattern? In Java, ‘isinstanceof’ operator follows which Design Pattern?*

1. *What is Primary Constructor? What is Secondary or Auxiliary Constructor in Scala?*
Scala has two kinds of constructors.
- Primary constructors
- Auxiliary constructors

**Primary Constructor:**
- It is defined with the class definition itself.
- Each class must have one primary constructor.
- Either parameter constructor or parameterless constructor.

```scala
class Person // no-parameter/parameterless/zero-parameter primary constructor
```

```scala
class Person(firstName: String, lastName: String) // two-parameters primary cons
```

**Auxiliary Constructor:**
- Also known as Secondary constructor.
- Can be declared using 'def' and 'this' keywords.

```scala
class Person(fn: String, mn: String, ln: String) {
  def this(fn: String, ln: String) = this(fn, "", ln)
}
```

2. *What is the use of Auxiliary Constructors? Explain rules in defining them?*
The main purpose of Auxiliary Constructors is to overload constructors.
Like Java, We can provide various kinds of constructors so that user can choose the right one based on his requirement.

**Auxiliary Constructor Rules:**

- They are like methods only. We should use 'def' keyword to define them.
- We should use same name 'this' for all auxiliary constructors.
- Each A.C should start with a call to another previusly defined A.C or P.C. Otherwise, compile-time error.
- Each A.C should differ with their parameters list: may be by number or by type
- A.C cannot cannot call a super class constructor. They should call them through P.M only.
- All A.Cs call their P.C directly or indirectly through other A.Cs.

3. *What are the differences between Array and ArrayBuffer in Scala?*

- Array is fixed size array. Its size cannot be changed once it is created.
- ArrayBuffer is variable size-array. It can increase or decrease its size dynamically.
- Array       is something similar to Java's primitive arrays.
- ArrayBuffer is something similar to Java's ArrayList.

4. *What is case class? What is case object? What are the advantages of case class?*
- Case class is a class which is defined with “case class” keywords.
- Case object is an object which is defined with “case object” keywords.
- Because of this “case” keyword, we will get some benefits to avoid boilerplate code.
- We can create case class objects without using “new” keyword.
- By default, Scala compiler prefixes “val” for all constructor parameters.
- That’s why without using val or var, Case class’s constructor parameters will become class members, it is not possible for normal classes.

**Advantages of case class:**
- By default, Scalac adds toString, hashCode, and equals methods.
- By default, Scalac adds companion object with un/apply methods.
- By default, Scalac adds copy method too.
- Case classes can be used in pattern matching.
- By default, case classes and case objects are serializable.

5. *What is the difference between Case Object and Object(Normal Object)?*
Normal object is created using “object” keyword. By default, It’s a singleton object.
- object MyNormalObject
Case Object is created using “case object” keywords.By default, It’s also a singleton object
- case object MyCaseObject

By Default, Case Object gets toString and hashCode methods. But normal object cannot.
By Default, Case Object is Serializable. But normal object is not.

6. *When compare to normal class, what are the major advantages or benefits of a case-class?*
- Avoids lots of boiler-plate code by adding some useful methods automatically.
- By default, supports Immutability because it’s parameters are ‘val’
- Easy to use in Pattern Matching.
- No need to use ‘new’ keyword to create instance of Case Class.
- By default, supports Serialization and Deserialization.

7. *What is the usage of isInstanceOf and asInstanceOf methods in Scala? Is there anything similar concept available in Java?*

- Both isInstanceOf and asInstanceOf methods are defined in scala.Any class.

- isInstanceOf is used to test whether the object is of given type or not.
- str.isInstanceOf[String]

- asInstanceOf is used to cast the object to the given type, or ClassCastException
- str.asInstanceOf[String]

- In Java, isinstanceof keyword -> isInstanceOf method in Scala
- In Java, (int) 5.4 -> 5.4.asInstanceOf[Int] in Scala

8. *How do you prove that by default, case object is serializable and normal object is not?*
By Default, case object is serializable. But normal object is not.

We can prove this by using isInstanaceOf method as shown below:

```shell
scala> object MyNormalObject
defined object MyNormalObject
 
scala> MyNormalObject.isInstanceOf[Serializable]
res0: Boolean = false
 
scala> case object MyCaseObject
defined object MyCaseObject
 
scala> MyCaseObject.isInstanceOf[Serializable]
res1: Boolean = true
```

9. *Difference between Array and List in Scala?*

- Arrays are always Mutable where as List is always immutable.
- Array values can be changed, List Object cannot be changed.
- Arrays are fixed-size, Lists are implemented as linkedlist.
- Arrays are invariants, whereas lists are variants.

10. *What is the difference between “val” and “lazy val” in Scala? What is Eager Evaluation? What is Lazy Evaluation?*
There are two kinds of program evaluations:

- Eager Evaluation
- Lazy Evaluation

Eager Evaluation means evaluating program at compile-time or program deployment-time
irrespective of clients are using that program or not.

Lazy Evaluation means evaluating program at run-time on-demand
that means when clients access the program then only its evaluated.

The difference between “val” and “lazy val” is that
“val” is used to define variables which are evaluated eagerly and
“lazy val” is also used to define variables but they are evaluated lazily.

11. *What is the relationship between equals method and == in Scala? Differentiate Scala’s == and Java’s == operator?*
In Scala, we do NOT need to call equals() method to compare two instances or objects.
When we compare two instances with ==, Scala calls that object’s equals() method automatically.

Java’s == operator is used to check References Equality that is whether two 
references are pointing to the same object or not. Scala’s == is used to check
Instances Equality that is whether two instances are equal or not.

12. *Difference between Scala’s inner class and Java’s inner class?*
In Java, Inner class is associated with Outer class that is Inner class a member of the Outer class.

Unlike Java, Scala treats the relationship between Outer class and Inner class differently.
Scala’s Inner class is associated with Outer class object.

13. *What is Diamond Problem? How Scala solves Diamond Problem?*
A Diamond Problem is a Multiple Inheritance problem. Some people calls this problem as Deadly Diamond Problem.

In Scala, it occurs when a Class extends more than one Traits which have same method definition.

Unlike Java 8, Scala solves this diamond problem automatically by following some rules defined in Language.
Those rules are called “Class Linearization”.

```scala
trait A{
  def display(){ println("From A.display")  }
}
trait B extends A{
  override def display() { println("From B.display") }
}
trait C extends A{
  override def display() { println("From C.display") }
}
class D extends B with C{ }

object ScalaDiamonProblemTest extends App {
  val d = new D
  d display       // From C.display
}
```
Here output is “From C.display” form trait C. Scala Compiler reads “extends B
with C” from right to left and takes “display” method definition from right-most
trait that is C.

14. *Why Scala does NOT have “static” keyword? What is the main reason for this decision?*
Scala does NOT have “static” keyword at all. This is the design decision done by Scala Team.

The main reason to take this decision is to make Scala as a Pure Object-Oriented
Language. “static” keyword means that we can access that class members without
creating an object or without using an object. This is completely against with
OOP principles.

If a language supports “static” keyword, then that Language is not a Pure
Object-Oriented Language. For instance, as Java supports “static” keyword, it is
NOT a Pure Object-Oriented Language. But Scala is a Pure Object-Oriented
Language.

15. *What is the use of “object” keyword in Scala? How to create Singleton objects in Scala?*

- It is used to create signleton objects. (object Test {})
- It is used to create executable scala applications. (object Test {def main})
- It is used to create static members(variables, methods) w/out using static keyword.
- It is used to define factory methods.

16. *How to define factory methods using object keyword in Scala? What is the use of defining factory methods in object?*
In Scala, we use ‘object’ keyword to define Factory methods. The main purpose of
these Factory methods in Scala is to avoid using ‘new’ keyword. Without using
‘new’ keyword we can create objects.

**To definen factory methods:**


```scala
class Person(fn: String, mn: String, ln: String) {
  def this(fn: String, ln: String) = this(fn, "", ln)
}

object Person {
  def apply(fn: String, mn: String, ln: String) = new Person(fn, mn, ln)
  def apply(fn: String, ln: String) = new Person(fn, ln)
}
```

- We can create new person object with or without using 'new' keywords.

```scala
val p1 = new Person("Scala","Java")
// or
val p1 = Person("Scala","Java")  // Person.apply(...)
```

17. *What is apply method in Scala? What is unapply method in Scala? What is the difference between apply and unapply methods in Scala?*
In Scala, apply and unapply methods play very important role. They are also very
useful in Play Framework in mapping and unmapping data between Form data and
Model data.

- apply   method: to compose or assemble an object from its components
- unapply method: to decompose or disassemble an object into its components.

**unapply Method:**

```scala
class Person(val firstName: String, val lastName: String)

object Person{
  def apply(firstName: String, lastName: String)
        = new Person(firstName, lastName)

  def unapply(p: Person): (String,String)
        = (p.firstName, p.lastName)
}
```

18. *How does it work under-the-hood, when we create an instance of a class without using ‘new’ keyword in Scala? When do we go for this approach?*
Internally it make a call to appropriate apply method available in Companion object.
Here appropriate apply method means that matched with parameters.

When do we choose this option: When we need to provide private private constructor
and we need to avoid using ‘new’ keyword, we can implement only apply method with
same set of parameters and allow our class users to create it without new keyword.

19. *How do we declare a private Primary Constructor in Scala? How do we make a call to a private Primary Constructor in Scala?*
add ‘private’ just after class name and before parameter list as shown below:

```scala
class Person private (name: String)
object Person {
  def apply(name: String) = new Person(name)
}
```
As it’s a private constructor, we cannot call it from outside.
We should provide a factory method (that is apply method) as shown above and use that constructor indirectly.

20. *Does a companion object access private members of it’s companion class in Scala?*
Generally, private members means accessible only within that class.
However Scala’s Companion class and Companion Object has provided another feature.

In Scala, a Companion object can access private members of it’s Companion class
and Companion class can access it’s Companion object’s private members.

21. *What is the main design decision about two separate keywords: class and object in Scala? How do we define Instance members and Static members in Scala?*
In Scala, we use class keyword to define instance members and object keyword to define static members.
Scala does not have static keyword, but still we can define them by using object keyword.

The main design decision about this is that the clear separation between instance and static members.
Loosely coupling between them. And other major reason is to avoid static keyword so that Scala will become a Pure-OOP Language.

22. *What is object in Scala? Is it a singleton object or instance of a class?*
Unlike Java, Scala has two meanings about ‘object’.
In Java, we have only one meaning for object that is “an instance of a class”.

- Like Java, the first meaning of object is “an instance of a class”.
- Second meaning is that object is a keyword in Scala. It is used to define
  executable programs, companion, singleton objects etc.

23. *What is a Companion Object in Scala? What is a Companion Class in Scala? What is the use of Companion Object in Scala?*
If a Scala class and object shares the same name and defined in the same source file,
then that class is known as “Companion Class” and that object is known as “Companion Object”.

[Not completely true:]The main purpose of Companion Object is to define apply
methods and avoid using new keyword in creating an instance of that Companion class object.

24. *How to implement interfaces in Scala?*
As we know from Java background, we use interface to define contact.

However, there is no interface concept in Scala. Even, Scala doesn’t have interface keyword.
Scala has a more powerful and flexible concept i.e. trait for this purpose.

25. *What is Range in Scala? How to create a Range in Scala?*
- Range is a lazy collection in scala.
- It is defined as scala.Range class.
- It is used to represent a sequence of integer values.
- It is an ordered sequence of integers.
- 1 to 10, 1 until 10

26. *How many values of type Nothing have in Scala?*
- In Scala, Nothing type have no values that is zero.
- It does not have any values.
- It is a subtype of all value classes and reference classes.

27. *How many values of type Unit have in Scala?*
- In Scala, Unit is something similar to Java’s void keyword.
- It is used to represent “no value exists”.
- It has one and only one value that is: ()

28. *What is a pure function?*
A pure function is a function without any observable side-effects.
That means it returns always same results irrespective how many times we call it with same inputs.

A pure function always gives same output for the same inputs.

“+” is a pure function available in Int class.
It gives same result 30 for same inputs 10 and 20, irrespective how many times we call it.

29. *In FP, what is the difference between a function and a procedure?*
Both are used to perform computation, however they have one major difference in FP world.

A function is a computation unit without side-effect where as a Procedure is also a computation unit with side-effects.

30. *What are the major differences between Scala’s Auxiliary constructors and Java’s constructors?*

- The auxiliary constructors are called using 'this' keyword.
- All A.Cs are defined with the same name 'this', in Java class name is used.
- Each A.Cs must start with a call to previously defined A.C or primary constructor.
- A.Cs are defined by using 'def' like normal method/functions. But in java, constructor and normal method definitions are different. 

31. *What is the use of ‘yield’ keyword in Scala’s for-comprehension construct?*
We can use ‘yield’ keyword in Scala’s for-comprehension construct.
‘for/yield’ is used to iterate a collection of elements and **generates new collection of same type**.
It does not change the original collection. It generates new collection of same type as original collection type.

32. *What is guard in Scala’s for-comprehension construct?*
In Scala, for-comprehension construct has an if clause which is used to write a condition
to filter some elements and generate new collection. This if clause is also known as “Guard”.

If that guard is true, then add that element to new collection.
Otherwise, it does not add that element to original collection.

```scala
for(l <- list if l > 5) yield l
```

33. *How Scala solves Inheritance Diamond Problem automatically and easily than Java 8?*
If we use Java 8’s Interface with Default methods, we will get Inheritance Diamond Problem.
Developer has to solve it manually in Java 8. It does not provide default or automatic resolution for this problem.

In Scala, we will get same problem with Traits but Scala is very clever and
solves Inheritance Diamond Problem automatically using Class Linearization concept.

34. *In Scala, Pattern Matching follows which Design Pattern? In Java, ‘isinstanceof’ operator follows which Design Pattern?*
In Scala, Pattern Matching follows Visitor Design Pattern.
In the same way, Java’s ‘isinstanceof’ operator also follows Visitor Design Pattern.

## Advance

 1. *What is the current latest version of Scala?What is the major change or update in Scala 2.12?*
 2. *What is Option in Scala? What are Some and None? What is Option/Some/None Design Pattern in Scala?*
 3. *What is Either in Scala? What are Left and Right in Scala? Explain Either/Left/Right Design Pattern in Scala?*
 4. *What is the equivalent construct of Scala’s Option in Java SE 8? What is the use of Option in Scala?*
 5. *What are the advantages of FP or advantages of pure functions?*
 6. *What are the popular Scala-based frameworks to develop RESTful web services or rest api?*
 7. *What is the best framework to generate REST API documentation for Scala-based applications?*
 8. *Like Hibernate for Java-based applications, What are the Popular ORM Frameworks available to use in Play/Scala based applications?*
 9. *What is the best tool to develop Play/Scala applications to persist data in MongoDB NoSQL data store?*
10. *Popular clients who are using Play and Scala to develop their applications?*
11. *What is the best language to use with Play framework: Scala or Java?*
12. *How Scala supports both Highly Scalable and Highly Performance applications?*
13. *What are the available Build Tools to develop Play and Scala based Applications?*
14. *What is SBT? What is the best Build Tool to develop Play and Scala Applications?*
15. *What are the available Unit Testing, Functional Testing and/or BDD Frameworks for Play and Scala Based applications?*
16. *What is the best code-coverage tool available for Play and Scala based applications?*
17. *What is the best Scala style checker tool available for Play and Scala based applications?*
18. *Which IDEs support Play and Scala-Based Applications Development and how?*
19. *What is the default Unit and Functional Testing Framework for Play? What is the default Build Tool for Play? What is the Default Template Engine for Play? What is the built-in Web Server available in Play Framework?*
20. *Why Scala is better than Java? What are the advantages of Scala over Java (Java 8)? Compare to Java What are the major advantages or benefits of Scala?*
21. *What is an Anonymous Function In Scala? What is a Function Literal in Scala? What are the advantages of a Anonymous Function/Function Literal in Scala?*
22. *What is an Higher-Order Function (HOF)?*
23. *What are the differences between Case class and Normal Class?*
24. *What are the advantages of Play/Scala stack to develop web applications?*
25. *What is call-by-name? Does Scala and Java support call-by-name? What is the difference between call-by-value and call-by-name function parameters?*
26. *What are the Java’s OOP constructs not supported by Scala? What are the Scala’s OOP constructs not supported by Java? What are the new OOPs constructs introduced by Scala, but not supported by Java?*
27. *What are the popular MVC frameworks for Scala Language to develop Web Applications?*
28. *What are major differences between Java-Based and Scala-Based Maven Project’s structure?*
29. *What is Extractor in Scala? What is the difference between Constructor and Extractor in Scala? What is the use of Extractor in Scala?*
30. *What is the use of ‘???’ in Scala-based Applications?*
31. *Explain the main difference between List and Stream in Scala Collection API? How do we prove that difference? When do we choose Stream?*
32. *What is the difference between :: and #:: in Scala? What is the difference between ::: and #::: in Scala?*
33. *If I want to become a Fullstack Scala Developer, which technology stack I should learn?*


1. *What is the current latest version of Scala?What is the major change or update in Scala 2.12?*
(Old:Current Scala’s stable is 2.11.7. It supports Java SE 7.)

The major change or update in Scala 2.12 version is that it supports Java SE 8 or later versions only.
Scala 2.12 is not a binary compatible with the 2.11.x series.

2. *What is Option in Scala? What are Some and None? What is Option/Some/None Design Pattern in Scala?*
- Option is used to represent optional values that is either exist or not exist.
- Option is an abstract class.
- Option has two subclasses: Some and None.
- All three (Option, Some and None) are defined in “scala” package like “scala.Option”.
- Option is a bounded collection in Scala, which contains either zero or one element.
- If Option contains zero elements that is None.
- If Option contains one element, that is Some.
- Some is used to represent existing value. None is used to represent non-existent value.
- def get(index: Int): Option[String]
- This method has a return type of Option[String].
- If List contains elements, it returns “Some[String]” element in that index.
- Otherwise, it returns “None” (that is no elements)
- Some is a case class and None is an Object.
- As both are case class/object, we can use them in Pattern Matching very well.
- The combination of all these three definitions is known as Option/Some/None Design Pattern in Scala.

3. *What is Either in Scala? What are Left and Right in Scala? Explain Either/Left/Right Design Pattern in Scala?*
- Either is an abstract class.
- It is used to represent one value of two possible types.
- It takes two parameters: Either[A,B]
- It has two subtypes: Left and Right
- Is alternative to Option. (See doc)

4. *What is the equivalent construct of Scala’s Option in Java SE 8? What is the use of Option in Scala?*
- Scala’s Option is similar to Java SE 8’s Optional.
- Optional class is used to represent existing or non-existing of some value.
- Optional is available in java.util package.

- Both Scala’s Option and Java SE 8’s Optional are used to represent optional values.
- Both are used to avoid unwanted null checks and NullPointerException.

5. *What are the advantages of FP or advantages of pure functions?*
- More Modular
- Easier to understand Or Easier reason about
- Easier to test
- Less prone to bugs
- Easier to reuse
- Easier to Parallelism and generalize

6. *What are the popular Scala-based frameworks to develop RESTful web services or rest api?*
Most popular frameworks are:

- Play Framework
- Scalatra Framework - Inspired by Sinatra
- Spray - not maintained - superseded by Akka HTTP
- Lift - routing usin pattern matching

7. *What is the best framework to generate REST API documentation for Scala-based applications?*
- Swagger is is the best tool for this purpose.
- It is very simple and open-source tool for generating REST APIs documentation with JSON for Scala-based applications.
- If we use Play with Scala to develop your REST API, then use play-swagger module for REST API documentation.

8. *Like Hibernate for Java-based applications, What are the Popular ORM Frameworks available to use in Play/Scala based applications?*
Popular ORM frameworks for Play/Scala:

- Slick
- Anorm
- SORM(Scala ORM)
- Squeryl

9. *What is the best tool to develop Play/Scala applications to persist data in MongoDB NoSQL data store?*
- ReactiveMongo is the best Scala Driver to develop Play/Scala applications
- It is used to persist data in MongoDB NoSQL data store.
- It supports fully non-blocking and asynchronous I/O operations.

10. *Popular clients who are using Play and Scala to develop their applications?*
Most popular clients:
- LinkedIn
- The Guardian
- Ocado
- LuchidChart
- GOV.UK

11. *What is the best language to use with Play framework: Scala or Java?*
- Play 2 is completely written in Scala. If we use Java with Play framework,
  we need to face many issues because Java does not support full FP features.

- Scala is the best option to use with Play framework to develop highly scalable,
  better performance with concurrency/parallelism and low latency applications,
  because:

- Play 2 is completely written in Scala.
- It supports full FP features.
- It is more expression language than Java.
- It supports Akka Actor model very easily
- It supports some new OOP feature like Traits.
- Play’s built-in templates are developed in Scala

12. *How Scala supports both Highly Scalable and Highly Performance applications?*
- Scala supports Multi-Paradigm Programming(Both OOP and FP) and
- It uses Actor Concurrency Model,
- we can develop very highly Scalable and high-performance applications very easily.

13. *What are the available Build Tools to develop Play and Scala based Applications?*
Most popular ones:

- SBT
- Maven
- Gradle

14. *What is SBT? What is the best Build Tool to develop Play and Scala Applications?*
- SBT stands for Scala Build Tool. Its a Simple Build Tool to develop Scala-based applications.
- Most of the people uses SBT Build tool for Play and Scala Applications.
- For example, IntelliJ IDEA Scala Plugin by default uses SBT as Build tool for this purpose.

15. *What are the available Unit Testing, Functional Testing and/or BDD Frameworks for Play and Scala Based applications?*

- Spec2
- ScalaTest
- ScalaCheck
- Mokito

16. *What is the best code-coverage tool available for Play and Scala based applications?*

- SCoverage is the code-coverage tool for Play and Scala based applications.
- SCoverage stands for Scala Code-coverage tool.
- It has plugin for 3 build tools(sbt,maven,gradle)

17. *What is the best Scala style checker tool available for Play and Scala based applications?*

- Scalastyle
- Plugins for build tools and IDEs

18. *Which IDEs support Play and Scala-Based Applications Development and how?*

- Eclipse, Intellij IDEA

19. *What is the default Unit and Functional Testing Framework for Play? What is the default Build Tool for Play? What is the Default Template Engine for Play? What is the built-in Web Server available in Play Framework?*
- Play Framework’s default Unit and Functional Testing Framework is Spec2.
- It is very easy to test Play/Scala based applications using Spec2 Framework.
- Play Framework’s Default built-in template is “Twirl”. It was developed in Scala.
- By using these templates, we can develop Play/Scala based applications very easily.
- The Built-in or Default Web Server available for Play Framework is Netty Server.

20. *Why Scala is better than Java? What are the advantages of Scala over Java (Java 8)? Compare to Java What are the major advantages or benefits of Scala?*
Scala supports the following extra features, it is better than Java 8:

- Full FP Features
- More expression language
- Pattern Matching
- Better support for Akka actor model
- Automatic resolution for inheritance diamond problem with traits
- Asynch and non-blocking IO programming using Akka framework
- Fully Reactive Streaming API

21. *What is an Anonymous Function In Scala? What is a Function Literal in Scala? What are the advantages of a Anonymous Function/Function Literal in Scala?*
- Anonymous Function is also a Function but it does not have any function name.
- It is also known as a Function Literal.

The advantages of a Anonymous Function/Function Literal in Scala:
- We can assign a Function Literal to variable
- We can pass a Function Literal to another function/method
- We can return a Function Literal as another function/method result/return value.

22. *What is an Higher-Order Function (HOF)?*
Higher Order Function (HOF) is also a function but which performs one, two or both of the following things:

- Take other functions as arguments
- Return functions as their results

23. *What are the differences between Case class and Normal Class?*
Case class is also a class, however when we compare it with normal class,
it gives the following extra features or benefits:

- By default, Case-class constructor parameters are ‘val’. We don’t need to declare parameters with ‘val’.
- By default, Case-class constructor parameters become class fields.
- These methods are added automatically: toString, equals, hashCode, copy. apply and unapply.
- It automatically gets Companion object.
- No need to use ‘new’ keyword to create instance of Case Class.
- Easy to use in Pattern Matching.

All these features are added by Scala Compiler at compile-time. It is not possible with normal class.

24. *What are the advantages of Play/Scala stack to develop web applications?*
- The following are the major advantages of Play/Scala stack to develop web applications:

**Open Source**
Play is an Open-source free-software framework to develop web applications.

**Better Productivity**
- Play framework’s Auto-reload feature improves Developer Productivity.
- No need to build, deploy and test our changes.
- Just do our changes and refresh the page to see our changes.

**Stateless and Easy to Develop REST API**
- Play is HTTP based stateless model to serve web requests so it is very easy
  to develop REST API or RESTful Web Services.

**Better Error-Handling**
- If we develop our web application using Play framework, it informs all errors
  in the browser in very useful format.
- It shows error message, the file location, line number where error occurred,
  highlighting the code-snippet to understand the error very easily.

**High Performance and Better Scalability With Reactive**
- Play framework is developed by following Reactive design patterns
- It is built on top of Netty sever to utilize Non-blocking IO Feature.
- Because of this feature, we can develop very highly Scalable and performance applications very easily.

**Easy to Extend**
- Play is very flexible framework and supports developing plug-ins very easy to
  extend it’s features and functionality.

**Highly Concurrency and Better Parallelism**
- As both Scala and Play supports FP, it is very easy to develop 
  Highly Concurrency and Better Parallelism applications very easily because FP
  supports Immutability, Pure Functions (Functions without side-effects), Pattern Matching, Actor Model etc.

**Better Reusability, Easy to Test and More Modular**
- As both Scala and Play supports FP, we can develop more modular and reusable applications.
- It is also very easy to test more modular applications.

25. *What is call-by-name? Does Scala and Java support call-by-name? What is the difference between call-by-value and call-by-name function parameters?*
Call-by-name means evaluates method/function parameters only when we need them or we access them.
If we don’t use them, then it does not evaluate them.

- Scala supports both call-by-value and call-by-name function parameters.
- Java supports only call-by-value, but not call-by-name.

- In Call-by-name, the function parameters are evaluated only whenever they are needed but not when the function is called.
- In Call-by-value, the function parameters are evaluated when the function is called.
- In Call-by-value, the parameters are evaluated before executing function and
  they are evaluated only once irrespective of how many times we used them in that function.
- In Call-by-name, the parameters are evaluated whenever we access them and
  they are evaluated each time we use them in that function.

- Call-by-value syntax(default):

```scala
def myFunct(x: Int, y: Int)
```

- Call-by-name syntax:

```scala
def myFunct(a: Int, y: => Int)
```

26. *What are the Java’s OOP constructs not supported by Scala? What are the Scala’s 
   OOP constructs not supported by Java? What are the new OOPs constructs introduced by Scala, but not supported by Java?*

**Java’s OOP constructs, which are not supported by Scala:**
- There is no interface concept in Scala
- There is no Enum concept in Scala

**Scala’s OOP constructs, which are not supported by Java:**
- The new OOPs constructs introduced by Scala, but not supported by Java:

- Scala Traits
- Solving Inheritance Diamond Problem automatically.

27. *What are the popular MVC frameworks for Scala Language to develop Web Applications?*
- Play Framework
- Scalatra Framework
- Spray Framework,outdated by Akka HTTP
- Lift Framework

28. *What are major differences between Java-Based and Scala-Based Maven Project’s structure?*
Is same. Just instead of java folder names, scala is used.

29. *What is Extractor in Scala? What is the difference between Constructor and Extractor in Scala? What is the use of Extractor in Scala?*
Not only in Java and Scala, in almost all OOP languages constructor is used to
create (or assemble) an object or an instance of a Class using it’s parameters (or components).
Extractor is quite opposite to Constructor.

In Scala, Extractor is used to decompose or disassemble an object into it’s parameters (or components).

- In Scala, apply method is a Constructor.
- Internally, Extractor uses unapply method to decompose an objects into it’s parts (or parameters).
- In Scala, Extractor is mainly used in Pattern Matching concept.

30. *What is the use of ‘???’ in Scala-based Applications?*
- This ‘???’ three question marks is not an operator, a method in Scala.
- It is used to mark a method which is ‘In Progress’ that means Developer should provide implementation for that one.

This method is define in scala.PreDef class as shown below:

```scala
def ???: Nothing = throw new NotImplementedError
```

31. *Explain the main difference between List and Stream in Scala Collection API? How do we prove that difference? When do we choose Stream?*
- In Scala, both List and Stream are from Collection API and works almost similar.
- Both are Immutable collections.

**One main difference between List and Stream in Scala Collection API:**
- That is List elements are evaluated Eagerly
- Stream elements are evaluated Lazily

- we can observe that all List elements evaluated at the time of creating List object.

```shell
scala> val l = List(1,2,3,4)
l: List[Int] = List(1, 2, 3, 4)

```
- We cannot see all elements. We can see only first evaluated element and remaining elements are evaluated lazily

```shell
scala> val s = Stream(1,2,3,4,5)
s: scala.collection.immutable.Stream[Int] = Stream(1, ?)
```

32. *What is the difference between :: and #:: in Scala? What is the difference between ::: and #::: in Scala?*
- :: method works as a cons operator for List class 
- #:: method works as a cons operator for Stream class.
- Here ‘cons’ stands for construct.

- ::: method works as a concatenation operator for List class 
- #::: method works as a concatenation operator for Stream class.

33. *If I want to become a Fullstack Scala Developer, which technology stack I should learn?*
- Scala 2.11.7
- Play 2.4.6 Framework
- Akka 2.3 Framework
- One Build Tool: SBT/Maven
- One JS Framework: CoffeeScript/JavaScript
- One IDE: IntelliJ IDEA 15/ Eclipse IDE 4.x
- One TDD & BDD Framework: ScalaTest,Spec2,ScalaCheck,Mockito
- Micro Services with Play and Scala
- SCoverage
- Scalastyle
- Functional Programming Design Patterns
- Machine Learning with Scala

## Concurrency and Parallelism

 1. *Why Sequential Programming is Bad?*
 2. *Why Concurrency Programming is Good?*
 3. *What are the two main categories of Concurrency Models available in JVM?*
 4. *What are the main Advantages of Shared State Concurrency Model?*
 5. *What are the main Drawbacks of Shared State Concurrency Model?*
 6. *What are the main Advantages of Akka/Scala Actors Concurrency Model or Scala's Future/Promise Model?*
 7. *How Akka Actor Concurrency Model works?*
 8. *What are the main Drawbacks of Actors Based Concurrency Model?*
 9. *How do we implement Shared State Concurrency Model in Java?*
10. *How do we implement Locking Mechanism of  Shared State Concurrency Model in Java?*
11. *Why do we need to implement Locking Mechanism or Synchronization Block for Shared State Concurrency Model in Java?*
12. *What is a Future in Scala?*
13. *What is a Promise in Scala?*
14. *Scala Future and Promise API?*
15. *Differences between Scala Future and Promise?*
16. *Differences between Scala Future and Java Thread?*
17. *Differences between Scala Future and Java Future?*
18. *What is an ExecutionContext?*
19. *Advantages of Scala Parallel Collections?*
20. *Differentiate between Concurrency and Parallelism?*
21. *What is Scala Async API?*
22. *Advantages of Scala Async API?*
23. *Differences between Scala Future/Promise API and Async API?*

1. *Why Sequential Programming is Bad?*
Main drawbacks of sequential programming:

- Blocking Programming
- Wasting of Valuable Resources
- In-Efficient and In-Effective Use of Valuable Resources
- Synchronous Programming Model 
- Less Through Put
- Bad Performance
- More Waiting time
- Slow Response to the Client Requests  

2. *Why Concurrency Programming is Good?*
Main advantages of concurrency programming model:

- Supports Non-Blocking Programming Model
- Efficient and Effective Use of Valuable Resources
- Asynchronous Programming Model
- More Through put
- Better Performance
- No Waiting time
- Instance Response to the Client Requests

3. *What are the two main categories of Concurrency Models available in JVM?*
- Shared Sate Concurrency Model
- No-Shared Sate Concurrency Model 
1. Actors Based Concurrency Model
2. Future/Promise Concurrency Model

4. *What are the main Advantages of Shared State Concurrency Model?*
It has the following few advantages:
- May be fast (If Developer is good in understanding and writing multi threading code)
- Using this model for longer time

5. *What are the main Drawbacks of Shared State Concurrency Model?*
- More difficult to write and understand the correct code
- Lot of boiler plate code
- Lots of Synchronization code to avoid race conditions
- Does not scale much in Distributed applications
- Tough to avoid Deadlock issues
- Tough to avoid Starvation issues
- Tough to avoid Live Locks
- Debugging is very tough
- Unit testing is bit tough
- More(less?) Resources utilization
- Very low level concurrency programming
- Lot of code to get and release Locks
- A Thread cannot create another Thread
- Threads are heavy weight
- Does not provide better Performance
- Supports only concurrency, does NOT support true parallelism.
- Does not support non-blocking functionality
- Context switching overhead to support concurrency

6. *What are the main Advantages of Akka/Scala Actors Concurrency Model or Scala's Future/Promise Model?*

- High level concurrency programming
- No boiler plate code
- Easy to write highly scalable code
- Supports distributed applications very well
- By default Actors are distributed
- More type safe
- No race conditions or deadlock issues
- Easy to avoid starvation and live locks
- No shared state
- Less resource utilization
- An actor can create and manage another actor
- Unit testing is very easy
- Easy to write and understand correct code
- No locks or synchronization code
- Actors are light weight
- Supports high performance
- Supports both concurrency and true parallelism very well
- Supports non-blocking functinality
- No context-switching overhead

7. *How Akka Actor Concurrency Model works?*

- By using actors but not objects
- Each actor has its own mailbox
- No direct communication between actors
- One actor send messages to another actor asynchronously
- Asynch message passing
- No share state that means actors never share their state with other actors
- No locking techniques, no competition to get locks
- An actor's state can only change by itself
- An actor processes its messages one by one only. One message at a time.

8. *What are the main Drawbacks of Actors Based Concurrency Model?*
Actors based concurrency model cannot be used in the following cases:

- When our application needs shared state
- When our application needs synchronous communication
- When we cannot break our problem into smaller problems

9. *How do we implement Shared State Concurrency Model in Java?*
Thread-based shared state concurrency is implemented by using:

- Shared mutable state
- Locking mechanism

10. *How do we implement Locking Mechanism of  Shared State Concurrency Model in Java?*

- Synchronization block
- Locking API

11. *Why do we need to implement Locking Mechanism or Synchronization Block for Shared State Concurrency Model in Java?*

- Execute the code in the correct order
- To get correct visibility
- To avoid Data Inconsistency issues
- To avoid Dead Lock issues
- To avoid Starvation
- To avoid Live Locks

12. *What is a Future in Scala?*

- A future is an object which represents a computation unit.
- It will have some value at some point in the future.
- It is a programming construct used to write concurrency programs very easily.
- If a future completes successfully, it has some computed value.
- In case of fail, it has some error

```scala
myFutureObject.onComplete {
 case Success(value) => // do something
 case Failure(error) => // log error
}
```

13. *What is a Promise in Scala?*

- A future represents a computation unit.
- A promise is used to execute that computation unit and write the result into a future.
- Promise is used to compute a value asynchronously, and future is used to read that value
- One promise is associated only with one future.

15. *Differences between Scala Future and Promise?*

- Promise is used to compute a value
- Future is used to read that value
- Promise is used to write the value
- Future is read-only object.
- Once promise is completed, we cannot its value. It becomes immutable.
- Once future  is completed, we cannot its value. It becomes immutable.
- Future is for querying data, and promise is for writing data.
- In simple words, future is getter, promise is setter.
