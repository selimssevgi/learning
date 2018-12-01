# Ranges in Haskell

```haskell
[1..20]        -- a list containing numbers from 1 to 20

['a'..'z']

['K'..'Z']

[2,4..20]      -- given first two elements

[3,6..20]      -- given first two elements

[20..1]        -- doesnt work

[20,19..1]     -- [20,19,18,17....1]

[13,26,...24 * 13]

take 24 [13,26..] --infinite list
```
