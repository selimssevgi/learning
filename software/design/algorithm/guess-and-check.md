# Guess and Check Algorithm

- It is also called exhaustive enumeration.

- Guess a starting value for a solution.
- Check if the guess is correct
- If not correct, guess another value.
- Repeat until find a solution


```python
# cube root
cube = 8
for guess in range(cube+1):
  if guess ** 3 == cube:
    print("Cube root of", cube, "is", guess)

# deal with negative cube and not perfect cube
cube = 8
abs_cube = abs(cube)
for guess in range(abs_cube+1):
  if guess ** 3 >= abs_cube:
    break
if guess ** 3 != abs_cube:
  print(cube, "is not a perfect cube")
else:
  if cube < 0:
    guess = -guess
  print("Cube root of " + str(cube) + "is " + str(guess))
```

* To find solution for not perfect cube, see Approximation.
