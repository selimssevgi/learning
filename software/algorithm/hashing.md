# Hashing

## Direct Access Tables

- Suppose keys are drawn from U={0,1,2...m-1}
- Assume keys are distinct.
- Set up array T[0..m-1] to represent dynmanic set S
- T[k] = x if key exists, 0 if not
- Therefore all operations take constant time. O(1)

### Problem = Limitation

- what if m-1 is a really big number like 2^64?
- An array from 0 to 2^64 would require lof of space. Memory hog!

## Hashing

- Hash function h maps keys "randomly" into slots of table T.

### Problem = Collision

- What if h function maps different keys into same slot in the table?

- When a record to be inserted maps to an already occupied slot, a *collision*
  occurs.

#### Resolving Collisions by Chaining

- Idea: link records in same slots into list.
- [a slot] -> [a record] -> [a record]
- h(49) = h(86) = h(52)

**Analysis:**

- *Worst-case:* Every key hashes to the same slot, ending up with linked list.
- Search, insert, delete: O(n)

- *Average-case:* Need assumption, simple uniform hashing. Each key is equally
  likely to be hashed to any slot in T, independent of where other keys are
  hashed.

- Load factor of a hash table with n keys and m slots is a = n/m, avrg # keys
  per slot

- Expected unsuccessful search time = O(1 + a) = hash & access key + search list
- Expected search time = O(1) if a = O(1) or n = O(m)

- Hashtable search time is not just O(1), it depends on load factor.

#### Choosing a Hash Function

- Should distribute keys uniformly into slots
- Regularity in key distribution should not affect uniformity.

## Hash Functions

### 1. Division Method

- h(k) = k mod m
- BAD: if m is even, or m is a small number
- Dont pick m with small divisor d

EX: d = 2 and all keys are even? Odd slots will never be used.
Ex: m = 2^r => hash doesnt not depend on all bits of k

- Pick m to be prime not too close product of 2 or 10

- Division takes more cycles than multiplication or addition.

### 2. Multiplication Method

- assume m = 2^r
- computer has w-bit words

```shell
h(k) = [(a.k) mod 2^w] >> (w - r)
```
- a -> a random odd integer between 2^(w-1) < a < 2^w
- a shouldnt be too close the boundaries

```shell
m = 2^3, table size is m=8,r is 3.
w = 7, 7 bit words

     1011001 = a = 89
     1101011 = k = 107
  +--------------------
     xxxxxxx
    xxxxxxx
  xxxxxxx
 xxxxxxx
xxxxxxx
--------------------
100010100110011 = mutiplying two w-bit words result in a 2w-bit result

Applaying mod 2^w, we will get rid of(ignore) the first w-bit part.

Shifting by w-r=4 we get the most significant three bits of w-bit word.
```

- Right shifting by (w-r) in order to get more randomazation, because after
  multiplication right most digits are going down as it is. Those bits are not
  colliding with other bits.

3. Universial Hashing Method:

```shell
h(k) = [(ak + b) mod p] mod m

a, b are random between {0,1,2,3..p-1}

p is a big prime number.
```

#### Resolving Collisions by Open Addressing

- IDEA: no storage for links

- Probe table systematically until an empty slot is found

- h = U x {0,1..m-1} -> {0,1,2..m-1}
- h = (universe of keys) x (probe number/step) -> (slot)
- Probe sequence should be permutation.
- You dont have to worry about chaining, table may fill up: n <= m
- Deleting is problematic, because of removing one of the probing steps.


```shell
Ex: Insert k = 496

h(496, 0) -> lets say it ppoint to non-empty slot
h(496, 1) -> again non-empty slot
h(496, 2) -> empty slot, insert there
```
- Searching follows the same probe steps, if run into empty slot, return nil.

#### Probing Strategies

##### 1. Linear Probing

- h(k,i) = (h(k,0) + i) mod m
- Just checking the next slot
- Group of slots become full, and becomes linear searching.

##### 2. Double Hashing

- h(k,i) = (h1(k) + i * h2(k)) mod m
- Excellent method
- Usually pick m = 2^r and h2(k) odd

**Analysis:**

- # probes = a / (a - 1), a = n/m
- If table is empty, # probes: 1
- If table is half empty, # probes: 2
- If table is %90 full, # probes: 10

## Hashing II

### Weakness of Hashing

- For any choice of hash function, there exists a bad set of key that all hash
  to the same slot

- Two compiler producer, benchmarking eachother, seeing hash function, and
  making it linked list, and beating the other one.

- Solution: Randomness, choose hash function at random, independent from keys
- Hash function will be picked at runtime, no way to guess and make it linkedlist

### Universal Hashing

- Let U be a universe of keys, and H' be a finite collection of hash functions
  mapping U to {1,2..m-1}

- H' is universal if x,y keys in U where x!=y, if h is randomly chosen from H',
  probability of collision between x and y is 1/m


### Static dictionary problem

- given n keys, construct a static hashtable(just search, no delete or insert)
- Most common used english word hash table, check one word in worst-case O(1)

#### Perfect Hashing

- O(1) worst-case time for search
- O(n) worst-case space(no wasting extra space)
- How long takes to build the data structure, polynomial build time

- IDEA: 2-level hashing
- In case of collision, gonna use another hash-table instead of linked list
- In the first hashtable collision are expected, but in the second level
  hashtables no collision should occur.

- Universal hashing in the first level
- slot holds key | a random number|
- If


- n people, n^2 birthdays, [Birthday Paradox]
