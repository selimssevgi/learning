# Custom Types in Haskell

- Type Synonyms
- Newtype
- Records (class or struct)
- Algebraic Data Types

## Type Synonyms

- Defines a new name for existing type
- Make code more readable
- Semantic meaning
- Completely ignored by compiler
- New type and existing type can be used interchangable


```haskell
type String = [Char]

type Point = (Double, Double)

midPoint :: (Double, Double) -> (Double, Double) -> (Double, Double)
midPoint (x1,y1) (x2,y2) =
  ((x1 + x2) / y, (y1 + y2) / 2)

midPoint' :: Point -> Point -> Point
midPoint' (x1,y1) (x2,y2) =
  ((x1 + x2) / y, (y1 + y2) / 2)
```

## Newtype

- Create a new type represented by an existing type
- New type and representation cannot be mixed up
- Add semantic meaning, checked by compiler

```haskell
-- = (constructor) (representation)
newtype CustomerId = MakeCustomerId Int

badCustomer :: CustomerId
badCustomer = 13 -- Not a good way!

customer :: CustomerId
customer = MakeCustomerId 13 -- turn this int into CustomerId

customerToInt :: CustomerId -> Int
customerToInt (MakeCustomerId i) = i  -- using pattern matching

-- constructor name can be newtype name
newtype CustomerId = CustomerId Int

customer :: CustomerId
customer = CustomerId 13

customerToInt :: CustomerId -> Int
customerToInt (CustomerId i) = i
```

## Records

- Not extensible
- No shared field name in different records
- Weakest point of the language, should avoided
- Use algebraic data types instead

```haskell
data Customer = MakeCustomer
  { customerId  :: CustomerId
  , name        :: String
  , luckyNumber :: Int
  }

alice :: Customer
alice = MakeCustomer
  { customerId  = MakeCustomerId 13
  , name        = "Alice"
  , luckyNumber = 42
  }
```

* Records can be updated, creating new record from an old one

```haskell
sally = alice { name = "Sally", luckyNumber = 84 }
```

## Algebraic Data Types

- Newtpye, but with more argument
- Tuples, with names
- Package some values together
- Named container

```haskell
-- data Customer = MakeCustomer CustomerId String Int
-- using same name as constructor is common

data Customer = Customer CustomerId String Int

alice :: Customer
alice = Customer (CustomerId 13) "Alice" 42

getCustomerId :: Customer -> CustomerId
getCustomerId (Customer cust_id name luckyNumber) = cust_id

getCustomerId' :: Customer -> CustomerId
getCustomerId' (Customer cust_id _ _) = cust_id

-- tuples with name
x :: (Double, Double, Double)

data RGB = RGB Double Double Double
x :: RGB


data StringTree = StringTree String [StringTree]
```

### Algebraic Data Type Constructors

- Constructors - different kinds of values for a type

* Many constructor without argument, enums

```haskell
data Bool = False | True -- two constructors: False, True

x :: Bool
x = True
y :: Bool
y = False

negate :: Bool -> Bool
negate False = True
negate True = False

data DialogResponse = Yes | No | Help | Quit
```

* Multiple constructors, different kinds of values

```haskell
data MaybeInt = NoInt | JustInt Int

defaultInt :: Int -> MaybeInt -> Int
defaultInt defaultValue NoInt = defaultValue
defaultInt _ (JustInt x) = x
```

```haskell
data StringList = EmptyStringList
                | ConsStringList String StringList

lengthStringList :: StringList -> Int
lengthStringList EmptyStringList = 0
lengthStringList (ConsStringList _ xs) = 1 + lengthStringList xs
```

### Parameterized Types

- Parameterized types hold values of any type
```haskell
data Maybe a = Just a | Nothing

x :: Maybe Int
x = Nothing

fromMaybe :: a -> Maybe -> a
fromMaybe defaultVal Nothing = defaultVal
fromMaybe _ (Just x) = x

data List a = Empty | Cons a (List a)
data Map k a = ...
```
