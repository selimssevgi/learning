# Integratation with Godoc

- Godoc uses the string after "Example" to decide which part of code should have
  the association with the example.


```go
// math_test.go
import "fmt"

// does not take any object like *testing.T
func ExampleStructName_MethodName() {
  pi := PolyIntegrator{}

  result := pi.Integrate(0, 10, 3)

  fmt.Println(result)

  // Ouput:
  // 30
}

func ExampleStructName_MethodName_textToBeShowInParentheses() {
  pi := PolyIntegrator{}

  result := pi.Integrate(0, 10, 3)

  fmt.Println(result)

  // Ouput:
  // 30
}
```

