# Go for Loop

- Traditional for-loop
- Only loop type
- Can use for loop to construct other kinds of loops

```go
func sayHi(times int) {
  for i := 0; i < times; i++ {
    fmt.Println("Hi")
  }
}

for i := 0; i < len(arr); i++ {
  fmt.Println(arr[i])
}
```

- while loop

```go
func sayHi(times int) {
  i := 0
  for i < times {
    fmt.Println("Hi")
    i++
  }
}
```

- Infinite loop(break, continue)

```go
for { // no condition
  item, err := haystack.Pop()
  if err != nil {
    break
  }
}
```
