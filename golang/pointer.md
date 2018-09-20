# Go's Pointer

- The pointer arithmetic isn't supported (or necessary)

- A pointer is declared by preceding the type name with a star

```go
func (stack *Stack) Pop() interface{} {}
```

- We can access the actual value that the pointer points to by 'dereferencing'

- Dereferencing is done by preceding the variable name with a star

- Start is overloaded (multiplication, pointer declaration, pointer derefence)


## Pointers and Methods

- If we call a method on a value, and the method requires a pointer to the value
  it is called on, Go is smart enough to pass the value's address rather than a
  copy of the value

- If we call a method on a pointer to a value, the method requires a value, Go
  is smart enough to dereference the pointer the give the method the pointed-to
  value

- This is why Go does not have or need the -> indirection operator used by C/C++
