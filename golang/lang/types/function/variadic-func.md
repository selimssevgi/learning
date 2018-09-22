# Variadic Functions

- Parameters are passed as slice

```go
func Sum(elements ...int) int {
    fmt.Println("Element count: ", len(elements))
    sum := 0
    for _, i := range elements {
      sum += i
    }
}
```
