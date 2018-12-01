# Methods

- Go does not have class, it has struct

- Method is a function which declares the type that operates on


```go
type Salutation struct {
  name     string
  greeting string
}

type Salutations []Salutation // named type

func (salutations Salutations) Greet() {
  for _, salut := range salutations {
    fmt.Println(salut)
  }
}

func main() {
  salutations := Salutations{
    {"Bob", "Hello"},
    {"Joe", "Hi"},
  }

  salutations.Greet()
}
```

## Pointer Methods

- If you just create a method on a named type, you can't modify that named type

- If you create a method on a pointer to a name type, we actually can modify that name type


```go
func (salutation Salutation) renameNoEffect(newName string) {
  salutation.name = newName
}


func (salutation *Salutation) renameEffective(newName string) {
    salutation.name = newName
}

func main() {
  salutations := Salutations{
    {"Bob", "Hello"},
    {"Joe", "Hi"},
  }

  salutations[0].renameNoEffect("Ahmet") // the original will still be "Bob"
  salutations.Greet()
  salutations[0].renameEffective("Ahmet") // Bob is change to "Ahmet"
  salutations.Greet()

}
```
