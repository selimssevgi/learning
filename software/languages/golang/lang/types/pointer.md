# Pointer 

- Has simplified version of pointer
- The pointer arithmetic isn't supported (or necessary)

- Pointers have value of memory location

- A pointer to integer can only point to an integer type

- Star is overloaded (multiplication, pointer declaration, pointer derefence)

```go
message := "Hello World"

var greeting *string = &message // greeting := &message

fmt.Println(message, greeting) // prints memory address
fmt.Println(message, *greeting) // prints the value at the memory address

// We can access the actual value that the pointer points to by 'dereferencing'
*greeting = "hi"
fmt.Println(message, *greeting) // hi hi
```


```go
func changeName(n string) {
  n = "Ahmet"
}

func doChangeName(n *string) {
  *n = "Ahmet"
}

func main() {
  name := "Selim"
  changeName(name)
  fmt.Println(name)   // Selim
  doChangeName(&name)
  fmt.Println(name)   // Ahmet
}
```

## Pointers and Methods

- Go passes arguments by value(like Java)

- If we call a method on a value, and the method requires a pointer to the value
  it is called on, Go is smart enough to pass the value's address rather than a
  copy of the value

- If we call a method on a pointer to a value, the method requires a value, Go
  is smart enough to dereference the pointer the give the method the pointed-to
  value

- This is why Go does not have or need the -> indirection operator used by C/C++
