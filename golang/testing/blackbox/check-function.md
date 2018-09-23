# quick.Check function

- Is used to conduct basic tests on a section of code and provide randomized data into it

```go
import "testing/quick"

func TestNewAlgorithm(t *testing.T) {
  oldAlg := OldAlgorith{}
  newAlg := NewAlgorith{}

  f := func(p1, p2 float64, otherParams [2]float64) bool {
    r1 = oldAlg.Calculate(p1, p2, otherParams[0], otherParams[1)  
    r2 = newAlg.Calculate(p1, p2, otherParams[0], otherParams[1)  

    if calculateErrMargin < 0.01 {
      return true  
    }
    return false
  }

  err := quick.Check(f, nil)
  if err != nill {
    t.Error(err)  
  }
}
```
