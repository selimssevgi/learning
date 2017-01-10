# Flow Control
Flow control describes the order in which statements will be executed at
runtime.

1. Selection Statements
   - if-else
   - switch-case

2. Iterative Statements
   - while Loop
   - do-while Loop
   - for Loop
   - foreach Loop (1.5V)

3. Transfer Statements
   - break
   - continue
   - return
   - try-catch-finally
   - assert (1.4V)


## Selection Statements

### if-else

#### Syntax
The argument to if statement should be boolean type. By mistake if we are trying
to provide any other type, then we will get compile time error.

```java
if (b) {
  // action if b is true
} else {
  // action if b is false
}
```

```java
int x = 0;
if (x) { // CE: incompatible type. found : int required : boolean
  System.out.println("Hello");
} else {
  System.out.println("Hi");
}
```

```java
int x = 0;
// assignment returns the value assigned
if (x = 20) { // CE: incompatible type. found : int required : boolean
  System.out.println("Hello");
} else {
  System.out.println("Hi");
}
```

```java
int x = 0;
if (x == 20) { // return false
  System.out.println("Hello");
} else {
  System.out.println("Hi"); // Hi
}
```

```java
boolean b = true;
// assignment returns the value assigned
if (b = false) { // even assignment operator, in this case returns false
  System.out.println("Hello");
} else {
  System.out.println("Hi"); // Hi
}
```

```java
boolean b = false;
if (b == false) { // return true
  System.out.println("Hello"); // Hello
} else {
  System.out.println("Hi");
}
```

Else part and cury braces are optional. Without curly braces only one statement
is allowed, which should not be declaritive statement.

```java
// valid
if (true)
  System.out.println("Hello");

// valid. empty statement
if (true);

// not valid. should not be declaretive. no point of having it. no scope
if (true)
  int x = 10;

if (true) {
  int x = 10;
  // x could be use in this scope
}
```

**NOTE:** semicolon(;) is valid java statement, which is also known as empty
statement.

**NOTE:** There is no dangling else problem in Java. Every else is matched to
nearest if statement.

### Switch(x)
If several options are available, then it is not recommended to use nested
if-else. Because it reduces readability. To handle this requirement we should go
for switch statement.

#### Syntax

```java
switch(x) {
  case 1:
    // action 1
    break;
  case 2:
    // action 2
    break;
  case n:
    // action n
    break;
  default:
    // default action
}
```

#### Allowed Argument Types
The allowed argument types for switch statements are byte,short,char,int until
1.4V. But from 1.5V onwards corresponding wrapper classes and enum type is
allowed. From 1.7V onwards String type is also allowed.

1.4V  |   1.5V    | 1.7V
------|-----------|-----
byte  | Byte      |
short | Short     |
char  | Character | 
int   | Integer   |
      | Enum      |
      |           | String


Curly braces are mandatory. Except switch everywhere curly braces are optional.

Both case and default are optional. That is an empty switch statement is valid
Java syntax.

```java
int x = 10;
switch(x) {
  // empty switch is valid  
}
```

Inside switch every statement should be under some case or default, that is
independent statements are not allowed inside switch. Otherwise, we will get
compile time error.

```java
int x = 10;
switch(x) {
  System.out.println("Hello"); // CE: case, default or } expected
}
```

Every case label should be compile time constant(constant expression). If we
declare variable as final, we wont get any compile time error.

```java
int x = 10;
int y = 20;
final z = 30;

switch(x) {
  case 10:
    System.out.println(10);
  case y : // CE: constant expression required
    System.out.println(20); 
  case z : // valid. is defined as constant
   System.out.println(30);
}
```

Both switch argument and case label can be expressions. But case label should be
constant expression.


```java
int x = 10;
switch(x+1) { // valid
  case 10:
    System.out.println(10);
  case 10 + 20 + 30: // valid. constant expression
    System.out.println(60);
}
```
Every case label should be in range of switch argument type. Otherwise we will
get compile time error.

```java
byte b = 10;
switch(b) {
  case 10:
    System.out.println(10);
  case 100:
    System.out.println(100);
  case 1000: // CE: possible loss of precision. f: int required: byte
    System.out.println(1000);
}
```

```java
byte b = 10;
switch(b+1) { // promotion. 1 is int literal. result is int
  case 10:
    System.out.println(10);
  case 100:
    System.out.println(100);
  case 1000:
    System.out.println(1000);
}
```

Duplicate case labels are not allowed. Otherwise we will get compile time error.

```java
int b = 10;
switch(x) {
  case 97:
    System.out.println(97);
    break;
  case 98:
    System.out.println(100);
    break;
  case 99:
    System.out.println(100);
    break;
  case 'a': // CE: 97. duplicate case label
    System.out.println('a');
}
```

#### case label
- It should be constant expression.
- The value should be in the range of switch argument type.
- Duplicate case labels are not allowed.

#### Fall-through inside switch
Within the switch if any case is matched, from that case onwards all statements
will be executed until break or end of switch. This is call fall-through inside
switch. The main advantage of fall-through inside switch is we can define common
action for multiple cases(code reusability).

```java
switch (x) {
  case 1:
  case 2:
  case 3:
    System.out.println("Q-4");
    break;
  case 4:
  case 5:
  case 6:
    System.out.println("Q-1");
    break;
  //.
  //.
  //.
}
```

```java
switch (x) {
  case 0:
    System.out.println(0);
  case 1:
    System.out.println(1);
    break;
  case 2:
    System.out.println(2);
  default: 
    System.out.println("def");
}

// x = 0 : output: 0 1
// x = 1 : output: 1
// x = 2 : output: 2 def
// x = 3 : output: def
```

#### default case
- Within the switch we can take default case at most once.
- default case will be executed if and only if there is no case matched.
- Within the switch we can write default case anywhere, but it is recommend to write as last case.

```java
switch (x) {
  default: System.out.println("def");  
  case 0:
    System.out.println(0);
    break;
  case 1:
   System.out.println(1);
  case 2:
   System.out.println(2);
}

// x = 0 : output: 0
// x = 1 : output: 1 2
// x = 2 : output: 2 
// x = 3 : output: def 0
```

## Iterative Statements

### while Statement
If we dont know the number of iteration in advance, then we should go for while
loop.

```java
while (rslt.next()) {}

while (e.hasMoreElements()) {}

while (itr.hasNext()) {}
```

#### Syntax
The argument should be boolean type. If we are trying to provide any other type,
then we will get compile time other.

```java
while (b) {
  // action 
}

while (1) { // CE: incompatible types. found: int required: boolean
  // action 
}
```

Curly braces are optional, and without curly braces we can take only one
stamements, and which should not be declaretive statement.

```java
// valid
while (true)
  System.out.println("Hello");

// valid
while (true);

// invalid
while (true)
  int x = 10;

// valid
while (true) {
  int x = 10;
}
```

#### Unreachibility
```java
while(true) {
  System.out.println("hello");
}
System.out.println("hi"); // CE: unreachable statement
```

```java
while(false)
{ // CE: unreachable statement '{'
  System.out.println("hello");
}
System.out.println("hi"); 
```

```java
int a = 10, b = 20;
while(a < b) {
  System.out.println("hello");
}
System.out.println("hi"); 
// valid, infinite times of hello
```

```java
int a = 10, b = 20;
while(a > b) {
  System.out.println("hello");
}
System.out.println("hi"); 
// valid, just hi
```

```java
final int a = 10, b = 20;
while(a < b) { // compiler will know this part is always true
  System.out.println("hello");
}
System.out.println("hi");  // CE: unreacheable statement
```

```java
final int a = 10, b = 20;
while(a > b) { // compiler will know this part is always false
               // // CE: unreacheable statement '{'
  System.out.println("hello");
}
System.out.println("hi");  
```

**NOTE:** Every final variable will be replaced with the value at the compile
time only.

```java
final int a = 10;
int b = 20;
System.out.println(a);
System.out.println(b);
// after compilation
System.out.println(10);
System.out.println(b);
```

**NOTE:** If every argument is final variable(compile time constant), then that
operation should be performed at the compile time only.

```java
final int a = 10, b = 20;
int c = 30;

System.out.println(a + b);
System.out.println(a + c);
System.out.println(a < b);
System.out.println(a < c);
// after compilation
System.out.println(30);
System.out.println(10 + c);
System.out.println(true);
System.out.println(10 < c);
```

### do-while loop
If we want to execute loop body at least once, then we should go for do-while.

#### Sytanx

```java
do {
  
} while(b);
```

Curly braces are optional. Without curly braces we can take only one statement
between do-while. And it should not be declaretive statement. Semicolon at the
end of while is mandatory.

```java
// valid
do
  System.out.println("Hello");
while (true);

// valid
do;
while (true);

// invalid
do
  int x = 10;
while (true);

// valid
do {
  int x = 10;
} while (true);

// invalid, at least one statement needed
do
while(true);
```

```java
// valid
do while(true)
System.out.println("hello");
while(false);
```

```java
do
  while(true)
    System.out.println("hello"); // it belong to above while, so together one statement
while(false);
```

#### Unreachability

```java
do {
  System.out.println("hello");
} while (true);
System.out.println("hi"); // CE: unreachable statement

do {
  System.out.println("hello"); // at least once
} while (false);
System.out.println("hi"); 

int a = 10, b = 20;
do {
  System.out.println("hello"); // infinite times
} while (a < b );
System.out.println("hi"); // wont reach here, but compiler is fine cus of variable

int a = 10, b = 20;
do {
  System.out.println("hello"); // once
} while (a > b );
System.out.println("hi"); // once

final int a = 10, b = 20;
do {
  System.out.println("hello"); 
} while (a < b ); // constants are replaces, replaced with true
System.out.println("hi"); // CE: unreachable statement. 

final int a = 10, b = 20;
do {
  System.out.println("hello");  // once
} while (a > b ); // constants are replaces, replaced with false
System.out.println("hi");  // once

```

### for Loop
for loop is most common used loop in java. If we know number of iterations in
advance, then for loop is the best choice.

#### Syntax

```java
for(initialization_section ; conditional_check ; increment_decrement_section ) {
  // loop body  
}
```

Curly braces are optional. Without curly braces we can take only one statement
under for loop, which should not be declaretive statement.

```java
for(int i=0; true ; i++ )
  System.out.println("hello");
```

```java
for(int i=0; i < 10 ; i++ ); // empty statement
```

```java
for(int i=0; true ; i++ )
  int x = 10; // invalid
```

#### Initialization Section
- This part will be executed only once in loop life cycle. 
- Here we can be declare and initialize local variables of for loop.
- Here any number of variables can be declared, they should be same type.
- By mistake, if we are trying to declare different data type variable, we will get compile time error.


```java
int i = 0, j = 0;
int i = 0, String s = "selim"; // invalid
int i = 0, int j = 0; // invalid
```

In the Initialization Section we can take any valid java statement including
System.out.println();.

```java
int i = 0;
for (System.out.println("hello"); i < 3; i++) {
  System.out.println("hi");  
}

// hello
// hi
// hi
// hi
```

#### Conditional Section
- We can take any valid java expression, but should be of type boolean.
- This part is optional, if we are taking anything, then compiler will always
place true.

#### Increment-Decrement Section
In this section we can take any valid java statement including
System.out.println();. 

```java
int i = 0;
for (System.out.println("hello"); i < 3; System.out.println("hi")) {
  i++;
}

// hello
// hi
// hi
// hi
```

All three parts of for loop are independent of each other and optional.

```java
for (;;){
  System.out.println("Hello");   // infinite 
}

for (;;); // inifite empty statement
```

#### Unreachability

```java
for (int i=0; true; i++) {
  System.out.println("hello");
}
System.out.println("hi"); // CE: unreachable statement

for (int i=0; false; i++) {
  System.out.println("hello"); // CE: unreachable statement 
}
System.out.println("hi");

for (int i=0; ; i++) { // compiler will put true
  System.out.println("hello"); 
}
System.out.println("hi"); // CE: unreachable statement 

int a = 10, b = 20;
for (int i=0; a < b; i++) {
  System.out.println("hello"); // forever
}
System.out.println("hi");

int a = 10, b = 20;
for (int i=0; a > b; i++) {
  System.out.println("hello");
}
System.out.println("hi"); // just here

final int a = 10, b = 20;
for (int i=0; a < b; i++) { // compiler replaces 10 < 20 : true
  System.out.println("hello"); 
}
System.out.println("hi"); // CE: unreachable stat

final int a = 10, b = 20;
for (int i=0; a > b; i++) { // compiler replaces 10 < 20 : false
  System.out.println("hello"); // CE: unreachable stat
}
System.out.println("hi"); 
```

### foreach Loop (Enhanced for loop) : 1.5V
- Introduced in 1.5V.
- It is specially designed to retrieve the elements of arrays and collections.

Ex1: To print elements of 1D array.

```java
int[] x = {10, 20, 30, 40};

// normal for loop
for (int i=0; i < x.length; i++) {
  System.out.println(x[i]);  
}

// enhanced for loop
for (int x1 : x) {
  System.out.println(x1);  
}
```

Ex2: to print elements of 2D array.

```java
int[][] x = { {10, 20, 30}, {40, 50} };

// normal for loop
for (int i=0; i < x.length; i++) {
  for (int j=0; j < x[i].length; j++) {
    System.out.println(x[i][j]);
  }
}

// enhanced for loop
for (int[] x1 : x) {
  for (int x2 : x1) {
    System.out.println(x2);
  }
}

// enhanced for loop 3D array
for (int[][] x1 : x) {
  for (int[] x2 : x1) {
    for (int x3 : x2) {
      System.out.println(x3);
    }
  }
}
```

For-each loop is the best choice to retrieve elements of arrays and collections.
But its limitation is that it is applicable only for arrays and collections and
it is not a general porpuse loop.

```java
for (int i=0; i < 10; i++) {
  System.out.println("Hello");  
}

// we cannot write the equivalent foreach loop
```

By using normal for loop we can print array elements either in original order or
in reverse order. But by using foreach loop we can print array elements only in
original order but not in reverse order.

```java
int[] x = {10, 20, 30};

for (int i=x.length-1; i >= 0; i--) {
  System.out.println(x[i]);  
}

// 30
// 20
// 10

// we cannot write the equivalent foreach loop
```

#### Iterable(I)
- The target element in foreach loop should be Iterable object. 
- An object is said to be Iterable if and only if corresponding class implements
java.lang.Iterable interface. 
- Iterable interface Introduced in 1.5V. And it contains only one method(iterator)

- public Iterator iterator()

- All array related classes and collection implemented classes already implement
Iterable interface. Being a programmer we are not required to do anything, just
we should aware the point.

for (eachitem x : target ) {
    
}

##### Differences between Iterator(I) and Iterable(I)

Iterator(I):
- It is related to Collections.
- We can use to retrieve elements of collection one by one
- Present in java.util package
- It contains three methods:
  1. hasNext()
  2. next()
  3. remove()

Iterable(I):
- It is related to foreach loop.
- The target element in foreach loop should be iterable.
- Present in java.lang package
- It contains one method
  1. iterator()

## Transfer Statements

### break Statement
We can use break statement in the following places.

1. Inside Switch : to stop fall-through

```java
int x = 0;
switch (x) {
  case 0:
    System.out.println(0);
  case 1:
    System.out.println(1);
    break;
  case 2:
    System.out.println(2);
  default:
    System.out.println("def");
}

// 0
// 1
```

2. Inside Loops : to break loop execution based on some condition

```java
for (int i=0; i < 10; i++) {
  if (i == 3) {
    break;
  }
  System.out.println(i);
}

// 0
// 1
// 2
```

3. Inside Label Blocks : to break block execution based on some condition

```java
public class Test {
  public static void main(String[] args) {
    int x = 10;
    l:
    {
      System.out.println("begin");  
      if (x == 10) {
        break l;
      }
      System.out.println("end");
    }
    System.out.println("hello");
  }
}

// begin
// hello
```

These are the only places where we can use break statement. If we are using
anywhere else, we will get CE: break outside of switch or loop.


```java
public class Test {
  public static void main(String[] args) {
    int x = 10;
    if (x == 10) {
      break; // CE: break outside of switch or loop
    }
    System.out.println("hello");
  }
}
```

### continue Statement
We can use continue statements inside loops to skip current iteration and
continue for the next iteration.

```java
for (int i=0; i < 5; i++) {
  if (x % 2 == 0) {
    continue;
  }
  System.out.println(i);
}

// 1
// 3
```

We can use continue statement only inside loops If we are using anywhere else,
we will get CE: contunie outside of loop

```java
public class Test {
  public static void main(String[] args) {
    int x = 10;
    if (x == 10) {
      contunie; // CE: contunie outside of loop
    }
    System.out.println("hello");
  }
}
```

#### Labeled break and contunie Statement
We can use labeled break and contunie to break or contunie a particular loop in
nested loops.


```java
l1:
for (int i=0; i < 10; i++) {
  l2:
  for (int j=0; j < 10; j++) {
    for (int k=0; k < 10; k++) {
      break l1; // jumps end of l1
      break l2; // jumps end of l2
      break; // jumps end of loop
    } // end of loop
  } // end of l2
} // end of l1
```

```java
l1:
for (int i=0; i < 3; i++) {
  for (int j=0; j < 3; j++) {
    if (i == j) {
      // break; break l1; continue; continue l1;
    }
    System.out.println(i + ".." + j);
  }
}

// break;
// 1..0
// 2..0
// 2..1

// break l1;
// no output

// continue;
// 0..1
// 0..2
// 1..0
// 1..2
// 2..0
// 2..1

// continue l1;
// 1..0
// 2..0
// 2..1
```

#### do-while vs continue [dangerous combination]

```java
int x = 0;
do { // continue doesnot come here
  x++;
  System.out.println(x);
  if (++x < 5) {
    continue;
  }
  x++;
  System.out.println(x);
} while (++x < 10); // continue comes here

// 1
// 4
// 6
// 8
// 10
```
