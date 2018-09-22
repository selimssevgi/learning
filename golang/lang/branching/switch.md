# Go Switch Statements

- No default fall through

- Don't need an expression

- Cases can be expressions

- Can switch on types

```go
func GetPrefix(name string) (prefix string) {
  switch name {
  case "Bob":
    prefix = "Mr "
    fallthrough       // explicitly telling it to fall through
  case "Joe", "Amy:   // either Joe or Amy
    prefix = "Dr "
  case "Mary":
    prefix = "Mrs "
  default:
    prefix = "Dude "
  }
  return prefix
}

// do not have to switch on smth
func GetPrefix(name string) (prefix string) {
  switch {
  case name == "Bob":
    prefix = "Mr "
  case name == "Joe", name == "Amy:
    prefix = "Dr "
  case name == "Mary":
    prefix = "Mrs "
  default:
    prefix = "Dude "
  }
  return prefix
}
```

## Swithc on Type

```go
func typeOf(x interface{}) {
  switch x.(type) {
  case int:
    fmt.Println("int")
  case string:
    fmt.Println("string")
  case Salutation:
    fmt.Println("salutation")
  default:
    fmt.Println("unknown")
  }
}
```
