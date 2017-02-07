# IO in Haskell

- Compile a Program
- IO Actions
- Combine IO Actions
- IO Values
- Useful IO Functions

## Compile a Program

- Save as 'HelloWorld.hs'
- ghc HelloWorld.hs
- ./HelloWorld

```haskell
-- HelloWorld.hs
main :: IO ()
main = putStrLn "Hello World"

-- putStrLn :: String -> IO ()
```

## IO Actions
- () - Unit, Void
- data Unit = Unit

- IO
- data IO a
- IO () - IO Unit - IO Action

- main - IO action executed by the program

```haskell
main :: IO ()
main = putStrLn "Hello World" -- printed

main2 :: IO ()
main = putStrLn "Hello World" -- not printed
```

## do Block

- Chain more IO action into one

```haskell
main = do
  putStrLn "Hello"
  putStrLn "World"
x = 3 -- not part of do block
```

```haskell
helloWorld :: IO ()
helloWorld = putStrLn "Hello World"

main :: IO ()
main = do
  helloWorld
  helloWorld
  helloWorld
```

```haskell
introduce :: String -> String -> IO ()
introduce name1 name2 = do
  putStrLn (name1 ++ ", this is " ++ name2)
  putStrLn (name2 ++ ", this is " ++ name1)

main = do
  introduce "Alice" "Bob"
  introduce "Alice" "Sally"
```

## IO Values

- '<-' can only used inside do block
- Bound variable can only be used later in the do-block
- IO actions can be combined like other functions

```haskell
main = do
  line <- getLine -- getLine :: IO String
  putStrLn ("You said" ++ line)
```

```haskell
greet :: IO ()
greet = do
  putStrLn "Who are you?"
  who <- getLine
  putStrLn ("Hello" ++ who)

greetForever :: IO ()
greetForever = do
  greet
  greetForever

main :: IO ()
main = greetForever
```
```haskell
import System.IO

main = do
  putStrLn "What's your name?"
  name <- getLine
  putStrLn ("Hello " ++ name)
```

## return Function

- Produces an IO action
- return :: a -> IO a

```haskell
dummyGetLine :: IO String
dummyGetLine =
  return "A dummy line"

main = do
  line <- dummyGetLine
  putStrLn line
```


```haskell
promptInfo :: IO (String, String)
promptInfo = do
  putStrLn "What is your name?"
  name <- getLine
  putStrLn "What is your favorite color?"
  color <- getLine
  return (name, color)

main :: IO ()
main = do
  (name, color) <- promptInfo
  putStrLn ("Hello " ++ name)
  putStrLn ("I like " ++ color ++ " too! ")
```


```haskell
main :: IO ()
main = do
  line1 <- getLine
  line2 <- getLine
--lines <- line1 ++ line2, ERROR: <- extract value from IO action
--lines <- return (line1 ++ line2), works but not the best way
  let lines = line1 ++ line2
  putStrLn lines
```


```haskell
main = do
  return 0      -- is not like in imperative languages
  putStrLn "haha, still running"
  return "halt" -- returns IO action but no binding so thrown away
  putStrLn "you cant stop me"
```

## Some Useful IO Actions

```haskell
-- print a string, and append a new line
putStrLn :: String -> IO ()

-- reads a line from the console
getLine :: IO String

-- print string representation of the value
print :: (Show a) => a -> IO ()

-- read an entire file as a (lazy) string
readFile :: FilePath -> IO String

-- write a string to a file
writeFile :: FilePath -> String -> IO ()

-- appends a string to a file
appendFile :: FilePath -> String -> IO ()

-- type FilePath = String
```

```haskell
interact :: (String -> String) -> IO ()

reverseLines :: String -> String
reverseLines input =
  unlines (map reverse (lines input))

main :: IO ()
main = interact reverseLines
```
