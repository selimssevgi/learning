# Goroutines

- Lightweight thread(layered on top of threads)

- Managed by Go runtime(green thread, scheduled by go runtime)

- If a goroutine blocks, go runtime runs another goroutine on the same thread

- Go's concurrency model: actor model, communicating sequential processes(CSP)

- Goroutines has smaller size than threads

- Just use the keyword "go"


```go
package main

import "fmt"
import "time"

func printNums(nums []int, printer func(int)) {
  for _, num := range nums {
    printer(num)
  }
}

func createPrinter(customize string) func(int) {
  return func(val int) {
    fmt.Println(val, customize)
  }
}

func main() {
  numbers := []int{1, 2, 3, 4}

  go printNums(numbers, createPrinter("C")) // spins up new thread
  printNums(numbers, createPrinter("S"))
  time.Sleep(100 * time.Millisecond) // had to put this, cus it does not know other thread havent finished
}

```
