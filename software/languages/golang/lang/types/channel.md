# Channel

- They are sort of like a UNIX pipe

- One Goroutine is going to feed the channel with data, and another Goroutine is
  going to have access to that same channel, but it is going to pull things off of that channel


- Channels can be buffered or unbuffered

## Unbuffered Channel

- If they are unbuffered, you have to wait for one piece of data to come in and
  out of the channel before we can put another one on

- If we want to put smth on unbuffered channel, we have to wait and see if there
  is anything already in the channel, if there is, then we can't put it in

- If we try to read from the unbuffered channel, we have to wait until there is
  actually data in the channel


```go
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

  done := make(chan bool) // boolean channel

  go func() {                                 // anonymous function
    printNums(numbers, createPrinter("C"))
    done <- true
    done <- true         // going to block, until first done is read!
    fmt.Println("Done!")
  }()

  printNums(numbers, createPrinter("S"))
  <-done // is going to block until can read the value
}
```

## Buffered Channel

- If we buffer the channel, the buffer is going to determine how many items are
  allowed to be stuffed in the channel before we actually block

- Make asynchronous operation possible

```go
done := make(chan bool)    // buffered boolean channel
done := make(chan bool, 2) // unbuffered, can put 2 values without blocking
```
