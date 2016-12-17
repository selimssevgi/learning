# for Loop in Python
Works like an iterator


```python
fh = open('lines.txt')
for line in fh.readlines():
  print(line)
```

```python3
for o in ( donald, john, fido ):
  in_the_forest(o)
```


```python
# x can be string, list, tuple
for i in x:
  print(i)
```

#### Enumerating Iterators
In for loop in Python we dont have traditional indexed loop. To have index value
while iterating over containers, we can use enumaration.


```python
fh = open('lines.txt')
for index, line in enumerate(fh.readlines()):
    print(index, line, end='')
```

```python
s = 'this is a string'
for i, c in enumerate(s):
    print(i, c)
```

```python
s = 'this is a string'
for i, c in enumerate(s):
    if c == 's': print('index {} is an s'.format(i))
```
