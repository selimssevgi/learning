# List in Python3

- A collection of objects
- An ordered group of items or elements
- Elements of a list can be accessed by an index
- Items in a list need not all have the same type.
- Lists can grow in a program run, while in C and Java arrays are fixed size

- List is mutable.
- We can add, append, remove things.

```python
x = [1, 2, 3]
print(type(x), x)
```


## List Methods

```python
empty_list = []

integer_list = [1, 2, 3]
mixed_list   = [1, 2, "Istanbul", 3.14]

lst = ["Istanbul", "Izmir"]
len(lst) # 2

"Istanbul" in lst # true

lst.append("Bursa") # returns None

lst.pop(0) # removes and returns the element
lst.pop() # last element
lst.remove(i)
lst.index("Istanbul") # return 0, if not ValueError
lst.insert(index,object)
```
