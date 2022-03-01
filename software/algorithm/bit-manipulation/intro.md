# bit manipulation

- can use bit manipulation in case of boolean[] needed
  - panagram, counting if each letter occured


### bitwise operations

- & and 
- | or
- ^ xor (eXclusive or)
- ~ not
- << left shift
- >> right shift


- each shift multiply by 2 (unless there is overflow)
- each shift divide by 2 with round towards negative infinity


### set bit = 1

- given a value, set the bit in a given position


```shell
def set_bit(x, position):
  mask = 1 << position
  return x | mask
```

```shell
x = 00000110
p = 00000101 = position 5
m = 00100000
|
r = 00100110
```

### clear bit = 0

- NOT mask will flip all digits
- easier to set the bit to 1 and digit flip them

```shell
def clear_bit(x, position):
  mask = 1 << position
  return x | ~mask
```

### flip bit

```shell
def flip_bit(x, position):
  mask = 1 << position
  return x ^ mask
```

### is bit set?

```shell
def is_bit_set(x, position):
  shifted = x >> position
  return shifted & 1
```

```shell
x = 01100110
p = 00000101 = position 5
s = 00000011
& = 00000001
r = 00000001
```

### modify bit

## check if even

```shell
(x & 1) == 0

0110
&
0001
0000
```

### check if power of two

- x must be bigger than 0

```shell
(x & x-1) == 0

1000 = 8
&
0111 - 7
0000
```
