# Go If Statement

- no parentheses around predicate

```go
func minAndMax(a, b int) (int, int) {
    if a > b {
        return b, a
    } else {
      return a, b
    }
}

func analyze(number int) {
  if number == 0 {
    fmt.Println(number, "is equal to zero")  
  } else if number > 0 {
    fmt.Println(number, "is greater than zero")  
  } else {
    fmt.Println(number, "is smaller than zero")  
  }
}
```

## Optional Initialization Statement

- Also called simple statement

- Can be used to initialize the variable to be used in if block

- Variables initialzied this way, are scoped to if block

```go
if number := 10;  number == 0 {
  fmt.Println(number, "is equal to zero")  
} else if number > 0 {
  fmt.Println(number, "is greater than zero")  
} else {
  fmt.Println(number, "is smaller than zero")  
}

fmt.Println(number) // cannot reach here
```

## Error Handling with If

- It is idiomatic to return 'error' as the last return from functions and methods

- 'nil' is used to indicate success

```go
_, err := os.Open("/home/ssselim/tst.txt")
if err != nil {
  fmt.Println("Error returned:", err)  
}
```
