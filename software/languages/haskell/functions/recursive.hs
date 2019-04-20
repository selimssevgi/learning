-- every loop can be written in recursive way

pow2 n =
  if n == 0
  then 1
  else 2 * (pow2 (n-1))

repeatString str n =
  if n == 0
  then ""
  else str ++ (repeatString str (n-1))
