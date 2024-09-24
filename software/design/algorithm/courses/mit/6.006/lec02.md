# 6.006 - Lecture 02 - Models of Computation, Document Distance

- What's an algorithm
- What is time?
- Random access machine
- Pointer machine
- Python model
- Document distance
- Problems & algorithms

## What's an algorithm

- Computational procedure for solving a problem
- An algorithm is basically the mathematical analog of a computer program.
- program <-> algorithm
- programming language <-> pseudocode(structured english)
- computer <-> model of computation

## Model of Computation

- Specifies:
- What operations an algorithm is allowed to do
- Cost(time) of each operation

1. Random Access Machine(RAM)

- RAM also used for Random Access Memory(in computer)
- RAM, random access machine(in model of computation)
- RAMemory is modeled by big array
- In constant TETA(1) time, can:
  - load O(1) words
  - do O(1) computations
  - store O(1) words
- O(1) registers
- word is w bits

- can be thought as programming in C

2. Pointer Machine

- Dynamically allocated objects,
- An object has a constant number of fields
- A field is going to be either a word(an int for example) or a pointer(reference)

- can be thought as programming in java

- With pointers you can do arithmetic operations, +1 etc, but with references
  you cannot.

## Python Model

- In above models, every operation takes constant time.
- But in Python model, some operations can take exponantial time for ex.

- list ~= array
- L.append(x), how long it takes?
  - table doubling (Lec9)
  - O(1) time
- L = L1 + L2, O(|L1| + |L2| + 1)
- Even the operator +, as an add op could be said is contants time. But
  underlying structure with list tells it is linear time.

- x in L: linear time.
- len(L): constant time, has a built-in counter
- L.sort(): O(nlogn)

- dict, D[key] = val, O(1), constant time, hashtable
- long: Lecture11, x+y -> O(|x| + |y|), x * y -> O(|x| + |y|)^lg3

## Document Distance

- d(D1, D2)
- Google, find similar pages,
- Wikipedia, find similar articles,
- Teacher, find similar homeworks for cheaters
- document = a sequence of words
- words = string of alphanumerics chars
- idea: shared words to measure distance, similarity
- think of document as a vector
- D[w] = # occurrences of words in document

- d'(D1, D2) = D1.D2 (dot product) = sum(w -> words)(D1[w].D2[w])

- 1M words in documents, 500.000 common words
- 1H words in documents, 100 common words

- d'(D1,D2) = D1.D2 / |D1.D2|
- d'(D1,D2) = arccos (angle between two vectors)

#### Algorithm

1. Split document into words
2. Compute word frequencies
3. Compute dot product
