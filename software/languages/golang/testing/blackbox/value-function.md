# Value Function

- Its job is to generate randomized values and objects for use by other members
  of the testing/quick package

- Can generate random values and test edge cases of our application


```go
import (
  "fmt"
  "math/rand"
  "reflect"
  "testing/quick"
  "time"
)

// Value function requires fields to be public
type MyStruct struct {
  MyInt    int
  MyString string
  MySlice  []float32
}

func main() {
  generator := rand.New(rand.NewSource(time.Now().Unix()))
  val, ok := quick.Value(reflect.TypeOf(1), generator)

  if ok {
    fmt.Println(val.Int())
  }

  myVal, ok := quick.Value(reflect.TypeOf(MyStruct{}), generator)

  if ok {
    fmt.Println(myVal.Interface().(MyStruct))
  }
}
```
