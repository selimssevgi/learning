# Partially Applied Functions

- When you invoke a functions, you're said to be applying the function to args.
- Passing all the expected arguments is fully applied.
- Only a few arguments is partially applied.
- It gives the convenience of binding some arguments and leaving the rest to be
  filled in later.



```scala
val date = new Date
log(date, "msg1")

Thread.sleep(1000)
log(date, "msg2")

Thread.sleep(1000)
log(date, "msg3")

def log(date: Date, message: String) {
  println(date + "---" + message)
}
```

- Invoking log method multiple times with same date value.

```scala
val date = new Date
val logWithDate = log(date, _: String)

logWithDate("msg1")

Thread.sleep(1000)
logWithDate("msg2")
```
