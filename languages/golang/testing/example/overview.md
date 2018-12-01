# Example Tests

- They work like regular tests

- They have some unique constraints in how assertions are performed

- Less flexible than regular tests, it opens up some powerful possibilities

- Allows to have also examples in documentation

```go
package mymath

import "fmt"

// Output has special meaning

func ExampleTest() {
  fmt.Println("Hello")
  fmt.Println("Go")

  // Output:
  // Hello Go
}

// go test mymath
```
