# IO in Haskell


```haskell
import System.IO

main = do
  putStrLn "What's your name?"
  name <- getLine
  putStrLn ("Hello " ++ name)
```
