# Struct

- Go does not have classes

- type allows us to have class like behavior, custom data types

- We can add some methods to user defined type

- Structs are basically a collections of named fields


```go
type CourseMeta struct {
  Author string  
  Level string
  Rating float 64
}

// var DockerDeepDive courseMeta
// DockerDeepDive := new(courseMeta) // new gives us a pointer
// composite literal way
DockerDeepDive := courseMeta{
  Author: "NP",
  Level: "Inter",
  Rating: 5,
}
```

```go
type Salutation struct {
  name string
  greeting string
}

var s = Salutation{"Selim", "Hello"}
var g = Salutation{greeting: "Hi", name: "Go"}
var o = Salutation{} // zero default empty string
o.name = "Bob"
o.greeting = "wasup?"

fmt.Println(s.name, s.greeting)
```

```go
type Salutation string // redefinition of string type

var message Salutation = "Hello World"
fmt.Println(message)
```
