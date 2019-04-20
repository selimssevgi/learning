# References in C++

- A reference variable is an alias, that is, another name for an already
  existing variable.

## Reference vs Pointer

- Three major differences:

1. You cannot have NULL references. You must always be able to assume that a
   reference is connected to a legitimate piece of storage.

2. Once a reference is initialized to an object, it cannot be changed to refer
   to another object. Pointers can be pointed to another object at any time.

3. A reference must be initialized when it is created. Pointers can be
   initialized at any time.


```cpp
// declare simple variables
int i;
double d;

// declare reference variables
int&    r = i;
double& s = s

```
