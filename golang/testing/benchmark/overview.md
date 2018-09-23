# Benchmark Test

- Benchmark tests are valuable tool to have available when the application has
  performance requirements that must be maintained

```shell
// benchmark tests take quite some time, they do not run by default
go test mymath

go test mymath -bench . // regex to pick, . matches all
```

```go
package mymath

import (
  "bytes"
  "testing"
  "text/template"
)

func BenchmarkExample(b *testing.B) {
  temp, _ := template.New("").Parse("Hello, Go")

  b.ResetTimer() // do not include setup time in benchmarking

  var buf bytes.Buffer
  for i := 0; i < b.N; i++ {
    temp.Execute(&buf, nil)
    buf.Reset()
  }
}
```
