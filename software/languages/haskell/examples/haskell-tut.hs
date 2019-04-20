import Data.List
import System.IO

{-
 - Multiline comment
-}

-- maximum integer
maxInt = maxBound :: Int
minInt = minBound :: Int

-- lists
primeNumbers = [2, 3, 5, 7, 11]

-- tuples
bobSmith = ("Bob Smith", 52)

getListItems :: [Int] -> String
getListItems [] = "Your list is empty!"
getListItems (x:[]) = "Your list starts with " ++ show x
getListItems (x:y:[]) = "Your list contains" ++ show x ++ ", " ++ show y
getListItems (x:xs) = "First item is " ++ show x ++ ", rest is: " ++ show xs
