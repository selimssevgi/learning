# Why FP matters?

- it is good to learn a new programming paradigm cus it makes you a better programmer

- FP helps you concurrent applications more effectively and easily

- FP helps you better handle complexity

- Unix pipes

- All Unix processes follow two simple rules:
  - write programs that do one thing and do it well
  - write programs to work together

- These simple rules gain you "composability"

- A Unix pipe is like a functional programming language
  - each process as a function
  - pipe lets you compose these functions using | notation


```scala
def even: Int => Boolean = _ % 2 == 0
def not: Boolean => Boolean = !_
def filter[A](criteria: A => Boolean)(col: Traversable[A]) = col.filter(criteria)
def map[A, B](f: A => B)(col: Traversable[A]) = col.map(f)

def evenFilter = filter(even) _            // currying
def double: Int => Int = _ * 2
```

- To compose the two functions together Scala provides a method called andThen
- andThen available to all function type except those with zero arguments
- andThen behaves similary to Unix pipes
- andThen combines two functions in sequence and creates one function


```scala
def doubleAllEven = evenFilter andThen map(double)

def odd: Int => Boolean = not compose even
def oddFilter = filter(odd) _
def doubleAllOdd = oddFilter andThen map(double)
```

- The only difference between andThen amd compose is that the order of
  evaluation for compose is right to left

- follow the Unix design philosophy:
  - write pure functions that do one thing and do it well (Single Responsibility Principle)
  - write functions that can compose with other functions

- Keeping functions small and pure automatically helps you compose them together
- One way to keep functions small is to have them only take on parameter or fewer
- write function while keeping function currying in mind
- make sure you order you parameters from most specific to most generic
  
  
  
  
  
  
  
  

