--takes any number and multiplies by 2
doubleMe x = x + x

--takes any two numbers and sum the double of each
doubleUs x y = x*2 + y*2

doubleUs' x y = doubleMe x + doubleMe y

--double a number if is bigger than 100
doubleSmallNumber x = if x > 100
                        then x
                        else x * 2

-- add one
doubleSmallNumber' x = (if x > 100 then x else x*2) + 1

removeNonUpperCase st = [ c | c <- st, c `elem` ['A'..'Z'] ]

addThree :: Int -> Int -> Int -> Int
addThree x y z = x + y + z

factorial :: Integer -> Integer
factorial n = product [1..n]

-- using pattern matching
factorial' :: (Integral a) => a -> a
factorial' 0 = 1
factorial' n = n * factorial' (n -1)

charName :: Char -> String
charName 'a' = "Albert"
charName 'b' = "Broseph"
charName 'c' = "Cecil"

addVectors :: (Num a) => (a,a) -> (a,a) -> (a,a)
addVectors a b = (fst a + fst b, snd a snd b)

-- using pattern matching
addVectors' :: (Num a) => (a,a) -> (a,a) -> (a,a)
addVectors' (x1, y1) (x2, y2) = (x1 + x2, y1 + y2)

first :: (a,b,c) -> a
first (x, _, _) = x

second :: (a,b,c) -> b
second (_,y,_) = y

third :: (a,b,c) -> c
third (_, _, z) = z

head' :: [a] -> a
head' [] = error "Cant call head on an empty list, dummy!"
head' (x:_) = x

tell :: (Show a) => [a] -> String
tell [] = "The list is empty"
tell (x:[]) = "The list has one element: " ++ show x
tell (x:y:[]) = "The list has two elements: " ++ show x ++ " and " ++ show y
tell (x:y:_) = "This list is long. The first two elements are:" ++ show x ++ " and " ++ show y

length' :: (Num b) => [a] -> b
length' [] = 0
length' (_:xs) = 1 + length' xs

sum' :: (Num a) => [a] -> a
sum' [] = 0
sum' (x:xs) = x + sum' xs

capital :: String -> String
capital "" = "Empty string, whoops!"
capital all@(x:xs) = "The first letter of " ++ all ++ " is " ++ [x]

-- using guards
max' :: (Ord a) => a -> a -> a
max' a b
  | a > b     = a
  | otherwise = b

-- using guards with where
bmiTell :: (RealFloat a) => a -> a -> String  
bmiTell weight height  
  | bmi <= skinny = "You're underweight, you emo, you!"  
  | bmi <= normal = "You're supposedly normal. Pffft, I bet you're ugly!"  
  | bmi <= fat    = "You're fat! Lose some weight, fatty!"  
  | otherwise     = "You're a whale, congratulations!"  
  where bmi = weight / height ^ 2  
        skinny = 18.5  
        normal = 25.0  
        fat = 30.0  

initials :: String -> String -> String
initials firstname lastname = [f] ++ ". " ++ [l] ++ "."
  where (f:_) = firstname
        (l:_) = lastname
