# Go Interface

- Go does not have classes
- We do not have to explicitly implement interfaces

**NOTE:** Any type that has the same methods as an interface implements that interface.

```go
type Renameable interface {
  Rename(newName string)
}

func RenameToFrog(r Renameable) {
  r.Rename("Frog")
}
```

# Empty Interface

- Go's empty interface can serve the same role as Java's Object

```go
func typeOf(x interface{}) { // can pass any type of object

}
```
