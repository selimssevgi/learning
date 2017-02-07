# Tuples in Haskel

- List contains same type of data
- Tuple can have different type of data

```haskell
randTuple = (1, "Random Tuple")

bobSmith = ("Bob Smith", 52)

bobsName = fst bobSmith
bobsAge  = snd bobSmith

names = ["Bob", "Marry", "Tom"]
ages  = [30, 50, 80]
nameAgeTuple = zip names ages
```
