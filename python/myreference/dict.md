# Dictionary in Python3
- mutable
- hashed
- no certain order

#### Defining a Dictionary
- one way

```python
d = { 'one': 1, 'two': 2, 'tree': 3 }
print(type(d), d)
```

- another way

```python
d = dict(
  one = 1,
  two = 2,
  three = 3,
  four = 4,
  five = 'five'
)
```

## Adding an Element to Dictionary

```python3
d = { 'one': 1, 'two': 2, 'tree': 3 }
d['seven'] = 7
```

## Accessing a Dictionary Element

```python
d = { 'one': 1, 'two': 2, 'tree': 3 }
print(d['one']) # 1
```

**NOTE:** If the key is not in the dictionary, we will get exception. Not to
have error, we can use get method of dictionary.

```python
d = { 'one': 1, 'two': 2, 'tree': 3 }
d.get('four', 'other') # other is default value in case it is not in dict
```

## Iterating a Dictionary

```python
d = { 'one': 1, 'two': 2, 'tree': 3 }
for k in d:
  print(k, d[k])
```

## Iterating a Dictionary as Sorted

```python
d = { 'one': 1, 'two': 2, 'tree': 3 }
for k in sorted(d.keys()):
  print(k, d[k])
```
