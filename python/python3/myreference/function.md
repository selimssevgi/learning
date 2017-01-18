# Function in Python3

### How to leave an function empty

```python
def testfunc():

```
We cannot leave like this it will give intentition error for the following line.

```python
def testfunc():
  pass # place holder, NOOP
```

### Defining a function

```python3
def isprime(n):
  if n == 1:
    print("1 is special")
    return False
  for x in range(2, n):
    if n % x == 0:
      print(str(n) + " equals " + str(x) + str(n//x))
      return False
    else:
      print(n, "is a prime number")
      return True

for n in range(1, 20):
  isprime(n)
```

#### Default Values for functions = Optional Parameters

```python
def func(a=7):
  print(a)

func()    # 7
func(10)  # 10
```

#### List of Arguments
- like java varargs
- is passed as tuple so it is immutable

```python
def testfunc(this, that, other, *args):
  print(this, that, other)
  for n in args: print(n, end=' ')
```

#### Named Function Arguments
- passed as dictionary

```python
def testfunc(**kwargs): # key word args
  print('test function', kwargs['one'])
```

```python
def testfunc(this, that, other, *args, **kwargs):
  pass

test(5,6,7,8,9, one = 1, two = 2, four = 42)
```
