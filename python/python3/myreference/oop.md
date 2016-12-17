# OOP in Python3

- self is tradition to use. Can use someother word too.

```python
class Egg:
  def __init__(self, kind = "fried"):
    self.kind = kind

  def whatKind(self):
    return self.kind

fried = Egg()
print(fried.whatKind()) # fried
boiled = Egg("boiled")
```

```python
class Fibonacci():
  def __init__(self, a, b):
    self.a = a
    self.b = b

  def series(self):
    while(True):
      yield(self.b)
      self.a, self.b = self.b, self.a + self.b


f = Fibonacci(0, 1)
for r in f.series():
  if r > 100: break
  print(r, end=' ')
```
