# JIT compilation with HotSpot

- "dynamically compiled"

- Methods start off being interpreted from their bytecode representation
- JVM keeps track of how any times a method has been called(with other statistics)
- When a threshold value(10,000 default) is reached, and if method is eligible
- A JVM thread will compile bytecode to machine code in background
- If compilation succeeds, in other call compiled from will be used
- Until something doesnt happen to invalidate it or cause deoptimization.


- In dynamic compilation there is more information available to compiler. 
- AOT(ahead-of-time) compilation doesnot have access to any runtime information
- This opens the intriguing possiblity that a dynamically compiled language like
  Java could actually run faster than AOT-compiled languages.
