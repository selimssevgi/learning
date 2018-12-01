# Arrays in C++


```cpp
double balance[10];

double balance[5] = {10.0, 5.4, 2.3, 7.0, 8.9};

double balance[] = {10.0, 5.4, 2.3, 7.0, 8.9};

balance[4] = 4.0
```

## Array to Functions

```cpp
void func(int *arr) {} // as pointer

void func(int param[10]) {} // as sized array

void func(int param[], int size) {} // as unsized array
```

## Return Array

- A pointer to an array can be returned
- C++ doesnot advocate to return the address of a local variable to outside of
  the function so you would have to define the local variable as 'static'

```cpp
int* getRandom() {
  static int r[10];
  //
  return r;
}
```
