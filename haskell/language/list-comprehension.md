# List Comprehension in Haskell


```haskell
take 10 [2,4..] -- there is another way

[x * 2 | x <- [1..10]]            -- x*2 output function

[x * 2 | x <- [1..10], x*2 >= 12] -- part after comma is condition(predicate)

[x | x <- [50..100], x `mod` 7 == 3]

pow3List = [x^3 | x <- [1..10]]

# Weeding out lists by predicates is also called filtering.
```
