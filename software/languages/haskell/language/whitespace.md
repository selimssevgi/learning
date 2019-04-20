# WhiteSpace in Haskell

- Do not use tabs. Ever. Use normal space


```haskell
-- indent further when breaking expression onto another line
pairMax p = max (fst p)
             (snd p)

pairMax p = max (fst p)
          (snd p)        -- ERROR: must start after 'm'


fancyNine =
  let x = 4
      y = 5 -- should be lined up
  in  x + y
```
