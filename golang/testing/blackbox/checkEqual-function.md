# quick.CheckEqual

- There are situations in which two code paths must be guaranteed to provide the
  same result when they are called with the same inputs.


```go
// math.go
func F(x int) int {
  return x * x
}

func G(x int) int {
  if x > 0 {
    return x * x
  } else {
    return 0
  }
}

```

```go
// math_test.go
import (
  "testing"
  "testing/quick"
)

func TestSquareFunctions(t *testing.T) {
  err := quick.CheckEqual(F, G, nil)

  if err != nil {
    t.Error(err)
  }
}
```
