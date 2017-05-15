# Call-by

- call-by-value
- call-by-reference
- call-by-name

## Call-by-name

```scala
def log(m: String) = if (logEnabled) println(m)        // call-by-reference
```

- what if string value passed to functions takes some time to compute

```scala
def popErrorMessage = { popMessageFromASlowQueue() }
log("The error message is " + popErrorMessage)
```

- Even if the log is not enabled that string value is going to be computed
- to have the computation cost only when it is really necessary

```scala
def log(m: => String) = if (logEnabled) println(m)     // call-by-name
```
