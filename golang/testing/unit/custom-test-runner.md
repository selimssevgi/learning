# Custom Test Runner

- Tests require some setup operation before execution

- setUp(), test(), tearDown()

- go test mymath -v

```go
// test runner deletegates the control of execution to TestMain
func TestMain(m *testing.M) {
  println("Tests are about to run")
  result := m.Run() // needed by runner to decide if was successful or not
  println("Tests done executing")
  os.Exit(result)
}
```
