# Ranges

- Ranges can work with array, slice, string, map, channel

```go
func rangeEx() {
  languages := []string{"Go", "Java", "Python"}
  for index, item := range languages { // _, item
    fmt.Println(index, item)
  }
}
```
