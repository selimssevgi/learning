# Slices

- Arrays are fixed size
- Different arrays of different sizes are different types

- If you want to use an array for a parameter in a function, then you would have
  to specify the size and that would limit the number of arrays that you'd be
  able to pass into there

- The size of a slice does not affect its type
- Slices of different sizes are still the same type

- Slice is a wrapper and abstraction of an array

- Use make to initalize a slice, otherwise is nil

- If we make a change to a slice of slice, the change will be effective in parent slice too

**NOTE:** Slices are passed as pointers, modifying them in funcs will be
effective outside of function.

## Slice Literal

```go
s := []int {1, 10, 500, 24}

langs := []string{"Go", "Java", "Python"}
```


## Define, then Initialize

- firstly all elements get their zero value

```go
var s []int = make([]int, 3, 5) // length: 3, capacity: 5
myCourses := make([]string, 6)

var s []int
s = make([]int, 3) // length and capacity is 3
s[0] = 1
s[1] = 3
s[2] = 30

// short version
s := []int {1, 10, 500, 24}
```

## Operations

- [inclusive:exclusive]

```go
// slicing
slice = s[1:2] // takes just index 1
slice = s[:2]  // from beginning
slice = s[1:]  // until end

// append
newSlice = append(slice, 63)
newSlice = append(slice, slice...) // append slice with itself

// delete
slice = append(slice[:1], slice[2:]...) // delete index 1
```

## Loop them over

```go
for _, element := range int[]{12, 45, 67} {
  fmt.Println(element)  
}
```
