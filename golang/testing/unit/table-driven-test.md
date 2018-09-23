# Table Driven Tests


```go
var addTable = []struct {
  in  []int
  out int
}{
  {[]int{1, 2}, 3},
  {[]int{1, 2, 3, 4}, 10},
}

func TestCanAddNumbers(t *testing.T) {
  for _, entry := range addTable {
    result := Add(entry.in...) // spread operator
    if result != entry.out {
      t.Error("Failed to add more than two numbers")
    }
  }
}

```
