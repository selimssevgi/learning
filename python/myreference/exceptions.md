# Exception Handling in Python3


```python
try:
  fh = open('nofile.txt')
  for line in fh.readlines():
    print(line)
except IOError as e:
  print("something bad happened: {}".format(e))
except:
  print("smth bad happened")
```

```python
try:
  fh = open('nofile.txt')
except:  # catch all error
  print("smth bad happened")
else:
  for line in fh.readlines(): print(line)
```

## How to raise an exception

```python
def readfile(filename):
  if filename.endswith('.txt'):
    fh = open(filename)
    return fh.readlines()
  else:
    raise ValueError('Filename must end with .txt')

try:
  for line in readfile('xlines.doc'): print(line.stript())
except IOError as e:
  print('cannot read file:', e)
except ValueError as e:
  print('bad filename:', e)
```
