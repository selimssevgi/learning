-- recursive fibonacci 
fab :: Int -> Int
fab 0 = 1
fab 1 = 1
fab n = fab (n-1) + fab(n-2)

-- find max number in a list 
maximum' :: (Ord a) => [a] -> a
maximum' []  = error "maximum of empty list"
maximum' [x] = x
maximum' (x:xs) 
  | x > maxTail = x
  | otherwise = maxTail
  where maxTail = maximum' xs

-- maximum' (x:xs) = max x (maximum' xs)
--

-- replicate 3 5, [5,5,5]
replicate' :: (Num i, Ord i) => i -> a -> [a]
replicate' n x
  | n <= 0    = [] -- testing for edge condition. 
  | otherwise = x:replicate' (n-1) x

-- take 3 [...], returns 3 elements from the list
take' :: (Num i, Ord i) => i -> [a] -> [a]
take' n _
  | n <= 0     = [] -- edge condition
take' _ []     = [] -- edge condition
take' n (x:xs) = x : take' (n-1) xs

-- reverse function
reverse' :: [a] -> [a]
reverse' []  = []
reverse' [x] = [x]
reverse' (x:xs) =  reverse' xs ++ [x]

-- repeat function repeat x infinitely
repeat' :: a -> [a]
repeat' n = n:repeat' n

-- zip function 
zip' :: [a] -> [b] -> [(a,b)]
zip' _ [] = []
zip' [] _ = []
zip' (x:xs) (y:ys) = (x,y):zip' xs ys

-- elem function, check if given element in the list
elem' :: (Eq a) => a -> [a] -> Bool
elem' a [] = False
elem' a (x:xs)
  | a == x   = True
  |otherwise = elem' a xs


-- quicksort
quicksort :: (Ord a) => [a] -> [a]
quicksort [] = []
quicksort (x:xs) =
  let smallerSorted = quicksort [a | a <- xs, a <= x]
      biggerSorted  = quicksort [a | a <- xs, a >  x]
  in  smallerSorted ++ [x] ++ biggerSorted

-- sum of the list
sum' :: (Num a) => [a] -> a
sum' [] = 0
sum' (x:xs) = x + sum' xs

-- length of a list
length' :: [a] -> Int
length' [] = 0
length' (x:xs) = 1 + length' xs

-- product of a list
product' :: (Num a) => [a] -> a
product' [] = error "No product of empty list"
product' [x] = x
product' (x:xs) = x * product' xs
