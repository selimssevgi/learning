# Go Map

- Built into language

- Keys have to have equality operator defined(slice or map does not have)

- Maps are reference types

- Go maps are not thread safe

- map[keyType]valueType

## Using make

```go
bigMap := make(map[string]string, 100)

func mapEx() {
  prefixMap := make(map[string]string)

  prefixMap["Bob"] = "Mr "
  prefixMap["Joe"] = "Dr "
  prefixMap["Amy"] = "Dr "
  prefixMap["Mary"] = "Mrs "

  retVal = prefixMap["Bob"] // return (value, exists)
}

```

## Map Literal

```go
// static map
strLength := map[string]int {
  "Bob" : 3,
  "Joe" : 3, // need to put final comma
}
```

## Iterating Maps

```go
testMap := map[string]int{
  "A": 1,
  "B": 2,
  "C": 3,
}

for key, value := range testMap {
  fmt.Printf("\nKey is: %v, Value is: %v", key, value)
}
```

## Map Operations

```go
// update
prefixMap["Mary"] = "Ms "

delete(prefixMap, "Mary")

// check for existince
if value, exists := prefixMap["Joe"]; exists {
  return value  
}
```
