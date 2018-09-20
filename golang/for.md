# Go for Loop

- Traditional for-loop

```go
for i := 0; i < len(arr); i++ {
  fmt.Println(arr[i])
}
```

- Infinite loop

```go
for { // no condition
  item, err := haystack.Pop()
  if err != nil {
    break
  }
}
```
