# Go Variable

- Go can deduce the variable type from the assignment

- type comes after the variable name

- variables declared at the function level must be used

```go
// inside function
d, e, f := 5, 6, 7
fmt.Println(d, e, f)
```

- short variable declaration wont work in global scope, can use keyword 'var'

```shell
// global scope
var days = []string{ "mon", "tue" }

var (
  name   string
  course string
)

func main() {
  
}
```

- other ways

```go
var message string
message = "Hello"

// multi-var declaration
var a, b, c int
var d, e, f int = 5, 6, 7
fmt.Println(a, b, c, d, e, f)

// go can infer the types
var d, e, f = 5, 6, 7
fmt.Println(d, e, f)

// can even remove var
```
