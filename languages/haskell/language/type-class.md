# Type Class in Haskell

- Type Class Instances
- Derived Type Classes
- Creating Type Classes
- Subclasses

## Type Class Instances

- A typeclass is a sort of interface that defines some behavior.

- If a type is a parf of a typeclass, that means that it supports and implements
  the behavior the typeclass describes.

- The equality function takes any two values that are of the same type and
  returns a Bool. The type of those two values must be a member of the Eq class.

```haskell
(==) :: (Eq a) => a -> a -> Bool
```

```haskell
elem :: Eq a => a -> [a] -> Bool
elem _ [] = False
elem x (y:ys) =
  | x == y    = True
  | otherwise = elem x ys
```

* Eq is used for types that support equality testing. == and /=

```haskell
data RGB = RGB Double Double Double

instance Eq RGB where
  (RGB r1 g1 b1) == (RGB r2 g2 b2) =
    (r1 == r2) && (g1 == g2) && (b1 && b2)

elem green colors
```

* Show type class is used to represent a type as a string

```haskell
data RGB = RGB Int Int Int

instance Show RGB where
  show (RGB r g b) =
    "RGB " ++ (show r) ++ "  " ++
    (show g) ++ " " ++ (show b)

show (RGB 255 0 255)
```

- Ord is for types that have an ordering.
- Read

## Derived Type Class Instances

- Eq   - Deriving components-wisely equality
- Ord  - deriving component-wise comparison, (>), (<), (<=), (>=)
- Show - show "{Constructor-name} {argument-1} {argumnet-2}..."
- Read - read (parse output of default show)

```haskell
-- can be tedious to write equalality every time
-- we can ask for it
data RGB = RGB Int Int Int
  deriving Eq                   -- compiler generates it
```

## Defining Type Classes

```haskell
class Eq a where
  (==) :: a -> a -> Bool
  (/=) :: a -> a -> Bool

  -- default implementation, so we dont have to provide implementation for both
  x /= y = not (x == y)
  x == y = not (x /= y)
```

```haskell
class Measurable a where
  distance :: a -> a -> Double
```

## Subclasses of Type Classes

```haskell
class (Eq a) => Ord a where
  (<)      :: a -> a -> Bool
  (>)      :: a -> a -> Bool
  (<=)     :: a -> a -> Bool
  (>=)     :: a -> a -> Bool
  compare  :: a -> a -> Ordering
  max      :: a -> a -> a
  min      :: a -> a -> a

data Ordering = LT | EQ | GT
```
## Type Class Constraint

```haskell
sum :: Num a => [a] -> a  -- constraint a to be a Num
sum [] = 0
sum (x:xs) = x + sum xs

-- multiple constaints
showSum :: (Num a, Show a) => [a] -> [Char]
showSum xs = show (sum xs)
```
