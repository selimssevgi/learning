# Notes on Generics
* Introduction
* Generic Classes
* Bounded Types
* Generic methods & wild-card character(?)
* Communication with non-generic code
* Conclusions

- the main objectives of generics are to provide/solution
  - type safety
  - type casting problem

## Introduction
### Case 1: Type Safety
Arrays are type-safe, that is we can give the guarantee for the type of elements presenting inside array.

If our programs requirement is to hold only String type objects, we can choose String array,
by mistake if we are trying to add any other type object, we will get compile time error.

```java
String[] s = new String[1000];
s[0] = "durga";
s[1] = "ravi";
//s[2] = new Integer(0); // CE: incompatible types. Found: Integer, Required: String
s[2] = "shiva";
```

- Hence String array can contain only String type of objects, due to this we can
  give the guarantee for type of elements presenting inside array.
- Hence arrays are safe to use with the respected to type, that is *arrays are 'type-safe'*.

However, collections are not type-safe, that is we cant give the guarantee for
the type of elements presenting inside collection. If our programs requirements
is to hold only String type of objects, and if we choose arraylist, by mistake,
if we are trying to add any other type of object, we will not get any compile time error.
But the program may fail at runtime.

```java
ArrayList l = new ArrayList();
l.add("durga");
l.add("ravi");
l.add(new Integer(10)); // no error while compiling

String s1 = (String) l.get(0);
String s2 = (String) l.get(1);
String s3 = (String) l.get(2); // RE: ClassCastException
```

Hence we cannot give the guarantee for type of elements presenting inside collection.
Due to this collections are not safe to use with the respected to type, that is *collections are not type-safe*.

### Case 2: Type Casting Problem
In case of array at time of retrievel is not required to perform type-casting,
because there is a guarantee for type of elements presenting inside array.

```java
String[] s = new String[1000];
s[0] = "durga";
String name = s[0]; // !! Type casting not required
```

But in case of collections at time of retrievel compalsary we should perform type-casting,
because there is no guarantee for type of elements presenting inside collection.

```java
ArrayList l = new ArrayList();
l.add("durga");
String name = l.get(0); // CE: incompatible types found. Found: Object, Required: String
String name = (String) l.get(0); // type-casting is mandatory
```

- Type-casting is a bigger headache in collection.

To overcome above problems of collections, Sun people introduced generics concept in 1.5V.
Hence the main objectives of generics are :

1. to provide type-safety
2. to resolve type-casting problem

### Type-Safety in Collections
To hold only string type of objects we can create generic version of ArrayList objects:
For this arraylist we can add only string type of objects,
by mistake, if we are trying to add any other type, then we will get compile time error.

```java
ArrayList<String>  l = new ArrayList<String>();
l.add("durga");
l.add("riva");
l.add(new Integer(10)); // CE:
```

- Hence through generics we are getting type-safety.

### Type-Casting in Collections
At the time of retrievel we are not required to perform type-casting.

```java
ArrayList<String> l = new ArrayList<String>();
l.add("durga");
String name = l.get(0); // type-casting is not required!
```

- Hence through generic we can solve type-casting problems.

### Comparasion
ArrayList l = new ArrayList();
- non-generic version of ArrayList object.
- It does NOT provide type-safety.
- It requires type-casting.

ArrayList<String> l = new ArrayList<>();
- generic version of ArrayList object.
- it provides type-safety.
- it does NOT require type-casting.

### Conlusions 1
Polymorphism concept is applicable only for base type but not for parameter type.
Poly: usage of parent reference to hold child objects.

```java
ArrayList<String> l = new ArrayList<String>();
// ArrayList = base type
// String    = parameter type
List<String> l = new ArrayList<String>();
Collection<String> l = new ArrayList<String>();
ArrayList<Object>  l = new ArrayList<String>();
// CE: incompatible types: found: AL<String>, required: AL<Object>
```

### Conlusions 2
For the type parameter, we can provide any class or interface name, but not primitives.
If we are trying to provide primitive then we will get compile time error:

```java
ArrayList<int> l = new ArrayList<int>;
// CE: unexpected type found: int, required: reference
```

## Generic classes
Until 1.4V a non-generic version of ArrayList class was as follows:

```java
class ArrayList {
  add(Object o);
  Object get(int i);
}
```

Argument to add is Object, hence we can add any type object to the arraylist.
Due to this, we are missing type safety.

Return type of get method is Object, hence at time of retrievel we have to perform type-casting.

But in 1.5V a generic version of ArrayList is declared as follows:

```java
class ArrayList<T> { // T: type parameter
  add(T t);
  T get(int index);
}
```

Based on our runtime requirement, T will be replaced with our provided type.
For example to hold only String type of objects, a generic version of AL object can be created:

```java
ArrayList<String> l = new ArrayList<String>();
```

For this requirement, compiler consired version of ArrayList class as follows:
```java
class ArrayList<String> {
  add(String t);
  String get(int index);
}
```

Argument to add method is String type, hence we can add only String type objects.
By mistake if we are trying to add any other type, we will get compiler time error:

```java
l.add("durga");
l.add(new Integer(10));
// CE: cannot found symbol, add(Integer), location: ArrayList<String> class.
```

Hence through generics we are getting type-safety.

The return type of get method is String, hence at the time of retrievel we are not required to perform type-casting.

```java
String name = l.get(0);
```

In generic we are associating a type parameter to the class,
such a type of parameterized classes are nothing but generic classes. or template classes.

Based on our requirement, we can define our own generic classes also.

```java
class Account<T> {
  //.
  //.
  //.
}

Account<Gold> a = new Account<Gold>();
Account<Platinum> a = new Account<Platinum>();
```

## Bounded Types
We can bound the 'type parameter' for a particular range by using extends keywords.
Such types are called bounded types.

```java
class Test<T> {} // can be any type, it is unbounded type
Test<Integer> t = new Test<>();
Test<String>  t = new Test<>();
```

### Syntax for bounded type
```java
class Test<T extends X> {}
```

X can be either class or interface,
- if X is a class, then we can pass either X type or its child classes.
- if X is a interface, then we can pass either X type or its implementation classes.

```java
class Test<T extends Number> {} :
Test<Integer> t = new Test<>();
Test<String>  t = new Test<>(); // CE: type parameter String is not in the bound.

class Test<T extends Runnable> {}
Test<Runnable> t = new Test<>();
Test<Thread>   t = new Test<>();
Test<Integer>  t = new Test<>(); // CE: type parameter Integer is not in the bound.
```

We can define bounded type even in combination also:
As T paratemeter, we can take anything should be child class of Number and implements Runnable(I)

```java
class Test<T extends Number & Runnable> {}
class Test<T extends Runnable & Comparable> {}
class Test<T extends Number & Runnable & Comparable> {}
class Test<T extends Runnable & Number> {} // INVALID: because we have to take class first, then interfaces
class Test<T extends Number & Thread> {}   // INVALID: because java doesnt allow multiple inheretence
```

#### Note 1
We can define bounded types only by using extends keyword.
And we cannot use implements and super keywords.
But we can replace implements keyword purpose with extends keyword.

#### Note 2
As a type parameter 'T', we can take any valid java identifier,
but it is convention to use 'T',

#### Note 3
Based on our requirement, we can declare any number of type parameters,
and all these type parameters should separated with the ','

```java
class HashMap<K,V> {} // K: key type, V: value type
```

## Generic methods and wild-card character(?)
```java
method1(ArrayList<String> list);
```
- We can call this method by passing arraylist of only string type.
- Within the method, we can add only string type object to the list.
- By mistake, if we are trying to add any other type, then we will get compile time error.

```java
method2(ArrayList<?> list);
```
- We can call this method by passing arraylist of any type.
- But within the method, we cannot add anything to the list except null: Because we dont know the type exactly.
- null is allowed because it is valid value for any type.
- This type of methods are best suitable for read-only operations.

```java
method3(ArrayList<? extends x> list); // x is either class or interface
```
- If x is a class, then we can call this method by passing arraylist of x type or its child classes.
- if x is interface, then we can call this method by passing arraylist of x type or its implementation classes.
- But within the method, we can NOT add anything to list except null.
- This type of methods are also best suitable for read-only operations.

```java
method4(ArrayList<? super x> list); // x can be either class or interface
```
- if x is a class, then we can call this method by passing arraylist of x type or its super classes.
- if x is an interface, then we can call this method by passing arraylist of either x type or 'super class of implementation class of x'
- x -> Runnable(I) <- Thread(C) -> Object
- But within the method we can add x type of objects and null to the list.

```java
ArrayList<String> list         = new ArrayList<>();                // valid
ArrayList<?> list2             = new ArrayList<String>();          // valid
ArrayList<?> list3             = new ArrayList<Integer>();         // valid
ArrayList<? extends Number> l4 = new ArrayList<Integer>();         // valid
ArrayList<? extends Number> l5 = new ArrayList<String>();          // invalid CE: incompatible types
ArrayList<? super String>   l6 = new ArrayList<Object>();          // valid
ArrayList<?> l7                = new ArrayList<?>();               // invalid CE: unexpected type
ArrayList<?> l8                = new ArrayList<? extends Number>();// invalid CE: unexpected type
```

We can declare type parameter either class level or method level.

- Declaring type parameter as class level:

```java
class Test<T> {}
```
We can use 'T' anywhere in this class based on our requirements.

- Declaring type parameter as method level: We have to declare type parameter right before return type.

```java
public <T> void  m1(T ob) {}
```
We can use 'T' anywhere in this method based on our requirements.

#### We can define bounded types even at the method also:

```java
public <T> void m1();
public <T extends Number>
public <T extends Runnable>
public <T extends Number & Runnable>
public <T extends Comparable & Runnable>
public <T extends Number & Comparable & Runnable>
public <T extends Runnable & Number>             // invalid! first class then interface
public <T extends Number & Thread>               // invalid! cannot extends two classes
```

## Communication with the non-generic code
- If we send a generic object to non-generic area, then it starts behaving like non-generic object.
- If we send a non-generic object to generic area, then it starts behaving like generic object.
- That is the location in which object present based on that behaviour will be defined.
- vegetarean home, non-vegan outside analogy

## Conclusions
- The main purpose of generics is to provide type-safety and to resolve type-casting problems.
- Type-safety and type-casting both are applicable at the compile time.
- Hence, generics concept is also applicable only at the compile time. but not at the runtime.
- At the time of compalition as a last setup, generic syntax will be removed.
- And hence for the JVM, generic syntax will NOT be available.

Following definations are all the same.

```java
// left part for compiler:static, right part for jvm:dynamic
ArrayList l = new ArrayList();
ArrayList l = new ArrayList<Double>();
ArrayList l = new ArrayList<Integer>();
ArrayList l = new ArrayList<String>();
l.add("durga");
l.add(10);
l.add(10.5);
l.add(true);
System.out.println(l); // [durga, 10, 10.5, true]
```
!! compile time not using generic, then there are not available again no problem.

The following declarations are equal:
```java
ArrayList<String> l = new ArrayList<String>();
ArrayList<String> l = new ArrayList();
```

They are equal for compiler, and afterward it doesnt matter.
For above AL objects we can add only string type of object.

```java
// ERROR
class Test{
  public void m1(int i){}              // signature: m1(int)
  public int  m1(int i){ return 10; }  // signature: m1(int)
}

//
class Test{
  public void m1(ArrayList<String> l) {}  // m1(ArrayList l)
  public void m1(ArrayList<Integer> l) {} // m1(ArrayList l)
}
```

// at the compile time
1. compile the above code normally by considering generics
2. remove generic syntax
3. compile once again resulting code

CE: name clash: both methods have same erasure

*Notes from DurgaSoft*
