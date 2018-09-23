# Unit Testing in Go

```shell
cd $GOPATH/src
mkdir mymath & mymath

# runs all tests in that package
go test mymath

# run specific tests
go test mymath -run Add # regex matching Add to test method names

# test runner times out in 10m
go test mymath -timeout 2s # timeout after 2 seconds, will leave db conn open

go test mymath/subpkg
go test mymath/...          # all subpackages
go test ./...
```

- Firstly write the test

```go
// math_test.go
package mymath

import (
  "testing"
)

func TestCanAddNumbers(t *testing.T) {
  result := Add(1, 2)

  if result != 3 {
    // t.Log("Failed to add one and two")
    // t.Fail()
    t.Error("Failed to add one and two")
  }
}
```

- run the test

```shell
go test mymath
```

```go
// math.go
package mymath

func Add(i, j int) int {
  return i + j
}
```

## Aborting a Test

- Sometimes the result will be nil, and it would not make sense to test againts its properties

```go
func TestSmth(t *testing.T) {
  result := SomeOp()

  if result == nil {
    // t.Log("Failed to return a sensible result")
    // t.FailNow() // return, exit
    t.Fatal("Failed to return a sensible result")
  }

  // other property tests
}
```

## Skip a Test

- go test mymath -v
- run in verbose mode to see report on skip tests

```go
func TestCanMultiplyNumbers(t *testing.T) {
  t.Skip("Not implemented yet")
}
```

- In case of long integration tests, we may want to skip them
- go test mymath -v -short

```go
func TestSmthLong(t *testing.T) {
  if testing.Short() {
    t.Skip("Skipping long tests")  
  }
}
```

## Tests in Parallel

- If tests do not have shared state, they can be safely run in parallel
- Default behavior is that all runs are run in a single-thread

```go
func TestSmthLong(t *testing.T) {
  t.Parallel() // mark the test that it can be run in parallel
}
```
