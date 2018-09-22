# Go Functions

- Can have multiple return values

- Can be used like any other type

- Go has function literals (closure)

* basic function definition

```go
// capital: public
// parameter name and parameter type
func Greet(salutation Salutation) {
    fmt.Println(salutation.name)
    fmt.Println(salutation.greeting)
}
```

* function with return 

```go
// if parameters are same type, can just specify it at the end
// return type also comes after func definition
func Add(a, b int) int {
    return a + b
}
```

* multiple returns

```go
func minAndMax(a, b int) (int, int) {
    return a, b
}

min, max := minAndMax(5, 6)

// ignore the first value, compiler will warn if variable is not used
_, max := minAndMax(5, 6)
```

* named returns

```go
// can used return values as normal variables
// return with the values that set finally
func minAndMax(a, b int) (max int, min int) {
    min = a
    max = b
    return
}
```

* function types

```go
func apply(a, b int, op func(int, int) int) int {
    return op(a, b)
}

apply(5, 6, Add)
```

* declaring a function type

```go
type BiFunction func(int, int) int
type Printer func(string) ()

func apply(a, b int, op BiFunc) int {
    return op(a, b)
}

apply(5, 6, Add)
```

* Closure

```go
func doubleResult(op BiFunc) BiFunc {
    return func(x, y int) int {
          return op(x, y) * 2
    }
}
```
