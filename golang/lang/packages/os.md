# os package

- Can access environment variables

```go
import "fmt"
import "os"

func main() {
  fmt.Println(os.Environ())

  for _, env := range os.Environ() {
    fmt.Println(env)
  }

  fmt.Println("Logged in user:", os.Getenv("USER"))
}
```
