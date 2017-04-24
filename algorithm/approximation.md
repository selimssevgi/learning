# Approximation

- Good enough solution
- Start with a guess and increment by some small value
- Keep guessing if |guess^3-cube| >= epsilon for some small epsilon

- small increment size -> slower program
- big epsilon -> less accurate answer

```python
cube = 27
epsilon = 0.01
guess = 0.0
num_guesses = 0 # or limiting number of guesses
while abs(guess ** 3 - cube) >= epsilon and guess <= cube:
  guess += increment
  num_guesses += 1

print("number of guesses = ", num_guesses)
if abs(guess ** 3 - cube) >= epsilon:
  print("Failed on cube root of", cube)
else:
  print(guess, "is close to the cube root of", cube)
```

* Approximation algorithm is linear, in order to get the answer faster see
  Bisection.
