# Guards in Haskell

- Guards are indicated by pipes that follow a function's name and its parameters.
- Watch out that there is no equal sign!!

```haskell
isOdd :: Int -> Bool
isOdd n
  | mod n 2 == 0 = False
  | otherwise    = True

isEven n = mod n 2 == 0

isEven' n = not (isOdd n)

---------------------------------------------------------------
whatGrade :: Int -> String
whatGrade age
  | (age >= 5 && age <=6) = "Kindergarten"
  | (age >= 7 && age <10) = "Elementary School"
  | otherwise             = "Unknown"
---------------------------------------------------------------

bmiTell :: (RealFloat a) => a -> String
bmiTell bmi
  | bmi <= 18.5 = "You're underweight, you emo, you!"
  | bmi <= 25.0 = "You're supposedly normal.Pffft, I bey you're ugly!"
  | bmi <= 30.0 = "You're fat! Lose some weight, fatty!"
  | otherwise   = "You are a whale, congrats!"
```

