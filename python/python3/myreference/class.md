# Classes in Python3


```python
class Duck:
  def __init__(self):
    print('constructor')

  def __init__(self, value):
    self._v = value

  def quack(self):
    print('Quak!')

  def walk(self):
    print('walks like a duck')


donald = Duck()
donald.quack()
donald.walk()
```

```python
class Duck:
  def __init__(self, color = 'white'): # default value
    self._color = color

  def set_color(self, color):
    self._color = color

  def get_color(self):
    return self._color

  def quack(self):
    print('Quak!')

  def walk(self):
    print('walks like a duck')


donald = Duck()
print(donald.get_color())
donald.set_color('color')
print(donald.get_color())
```
