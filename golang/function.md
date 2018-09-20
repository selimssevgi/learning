# Go's Function

- Go functions and methods can return a single value or multiple values

- It is conventional in Go to report errors by returning an error value

- Both functions and methods are defined using the 'func' keyword

## Methods

- In the case of methods the type of value to which the method applies is
  written after the func keyword

- The value on which the method is called is known in Go terminology as the 'receiver' (this, self)

```go
func (stack Stack) Len() int { // type of the receiver is Stack, passed by value
  return len(stack)
}

func (stack *Stack) Push(x interface{}) { // pass by reference
  *stack = append(*stack, x)
}
```
