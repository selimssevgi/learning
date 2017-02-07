# Pattern Match


```scala
def createErrorMessage(errorCode: Int) : String = {
  var result : String = _  // initialized to default
  errorCode match {
    case 1 =>
      result = "Network Failure"
    case 2 =>
      result = "I/O Failure"
    case _ =>
      result = "Unknown Error"
  }
  return result;
}
```

```scala
def createErrorMessage(errorCode: Int) : String = {
  val result = errorCode match {
    case 1 => "Network Failure"
    case 2 => "I/O Failure"
    case _ => "Unknown Error"
  }

  return result
}
```

```scala
def createErrorMessage(errorCode: Int) : String = errorCode match {
  case 1 => "Network Failure"
  case 2 => "I/O Failure"
  case _ => "Unknown Error"
}
```
