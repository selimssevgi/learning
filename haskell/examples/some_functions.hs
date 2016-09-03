-- some function from the pluralsight tutorials

square x = x * x

-- multiplies the largest of a and b by x
multMax a b x = (max a b) * x

posOrNeg x = 
  if x >= 0
  then "Positive"
  else "Negative"

-- Recursion Replaces Loops
-- int pow2(int n) {
-- int x = 1
-- for(int i=0; i<n; i++){
--  x *= 2
--  }
--
pow2 n = pow2loop n 1 0 -- using helper

pow2loop n x i = 
  if i<n
  then pow2loop n (x*2) (i+1)
  else x
--


-- pow2 n = 2  to power n
pow2 n = 
  if n == 0
  then 1
  else 2 * ( pow2 ( n -1 ) )

repeatString str n =
  if n == 0
  then ""
  else repeatString str ++ ( repeatString str ( n - 1 ) )

-- doubling every element in the list
double nums =
  if null nums
  then []
  else (2 * (head nums)) : (double (tail nums))

-- remove odd numbers from the list
removeOdd nums =
  if null nums
  then []
  else 
    if (mod (head nums) 2) == 0 -- even?
    then (head nums) : (removeOdd (tail nums))
    else removeOdd (tail nums)
