# Typeclass in Haskell

- A typeclass is a sort of interface that defines some behavior.

- If a type is a parf of a typeclass, that means that it supports and implements
  the behavior the typeclass describes.

- The equality function takes any two values that are of the same type and
  returns a Bool. The type of those two values must be a member of the Eq class.

```haskell
(==) :: (Eq a) => a -> a -> Bool
```

- Eq is used for types that support equality testing. == and /=

- Ord is for types that have an ordering.

- Members of Show can be presented as strings.

- Read
