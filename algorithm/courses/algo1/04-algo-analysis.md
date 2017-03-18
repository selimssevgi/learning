# Algorithm of Analysis

## Cast of characters

- Programmer:   needs to develop a working solution.
- Cleint:       wants to solve problem efficiently.
- Theoretician: wants to understand.
- Student:      might play any or all of these roles someday.

- Basic blocking and tackling is sometimes necessary.

## Running Time

## Reasons to analyse algorithms

- Predict performance
- Compare algorithms
- Provide guarantees
- Understand theoretical basis.

- Primary practical reason: avoid performance bugs

Client gets poor performance because programmer did not understand performance
characteristics.

## Some algorithmic success

- Algorithms from Npow2 to N log N.
- Npow2 not possible to solve
- N log N, possible to solve

## The challenge

- Will my program be able to solve a large practical input?
- Why is my problem so slow?
- Why does it run out of memory?

(Knuth 1970): Use scientific method to understand performance.

## Scientific method applied to analysis of algorithms

A framework for predicting performance and comparing algorithms.

* Scientific method:
  - Observe     some feature of the natural world.(running time of program)
  - Hypothesize a model that is consistent with the observations.
  - Predict     event using the hypethesis.
  - Verify      the predictions by making further observations.
  - Validate    by repeating until the hypothesis and observations agree.

* Principles:
  - Experiements must be *reproducible.*
  - Hypotheses must be   *falsifiable.*

*Question:* n = 1.000.000. n lg n how much faster than n^2.

```shell
# lg is base-2
lg 1000 = lg 10^3 ~= 10
1000 ~= 1024 = 2^10
lg 10^6 ~= 20
n^2 / n lg n = n / lg n = 10^6 / lg 10^6 = 10^6 / 20 = 50.000
```

### Observations

*Example:* 3-Sum: given N distinct integers, how many triples sum to exactly
zero?


```shell
$ more 8ints.txt
8
30 -40 -20 -10 40 0 10 5
```

```java
// brute-force algorithm: n^3

public static int count(int[] a) {
  int N = a.length;
  int count = 0;
  for (int i=0; i < N; i++) {
    for (int j=i+1; j < N; j++) {
      for (int k=j+1; k < N; k++) {
        if (a[i] + a[j] + a[k] == 0) {
          count++;
        }
      }
    }
  }
  return count;
}
```

Power law: aN^b

#### Experimental algorithms

* System independent effects: (determines b in power law)
  - Algorithm
  - Input data

* System dependent effects: (above + this determines a in power law)
  - Hardware: CPU, memory, cache...
  - Software: compiler, interpreter, garbage collector...
  - System:   operating system, network, other apps...

Bad  news: Difficult to get precise measurements
Good news: Much easier and cheaper than other sciences.(animal, space, etc.)

### Mathemetical Models for running time

Total running time: sum of cost x frequency for all operations.

- Need to analyze program to determine set of operations
- Cost depends on machine, compiler.
- Frequency depends on algorithm, input data.

(The Art of Computer Programming, Donald Knuth)

In principle, accureate mathematical models are available.

### Cost of basic operations

(Slide 25-26)

String concatenation -> s + t -> c1 x N

### Simplifying tedious calculations

* Simplification 1: cost model: Use some basic op as a proxy for running time.
* Simplification 2: tilde notation: Ignore lower order terms.

Use 'cost model' and 'tilde notation' to simplify counts.

Ex: 1 + 2 + 3 + ... + N = 1/2 x N^2 ~= N

Ex: 1 + 1/2 + 1/3 + ... + 1/N = ln N


*In principle,* accurate mathematical models are available.

*In practice,*

- Formulas can be complicated.
- Advanced mathematics might be required.
- Exact models best left for experts.

```shell
T(N) = c1A + c2B + c3C +c4D + c5E

A = array access
B = integer add
C = integer compare
D = increment
E = variable assignment
```

*Bottom line,* we use approximate models: T(N) ~ cN^3

## Order-of-Growth Classifications

- 1, logN, N, NlogN, N^2, N^3, 2^N

OoG    | Name         | Description        | Example           | T(2N) / T(N)
-------|--------------|--------------------|-------------------|--------------
1      | Constant     | Statement          | a + b             | 1
lg N   | Logaritmic   | Divide in half     | Binary search     | ~1
N      | Linear       | Loop               | Find the max      | 2
N lg N | linearithmic | Divide and conquer | Mergesort         | ~2
N^2    | Quadratic    | Double loop        | Check all pairs   | 4
N^3    | Cubic        | Triple loop        | Check all triples | 8
2^N    | Exponential  | Exhaustive search  | Check all subsets | T(N)


## Theory of Algorithms

### Commonly-used notations

Notation   | Example   | Used to
-----------|-----------|--------------
Tilde      | ~ 10N^2   | provide approximate model
Big Theta  | Theta(N^2)| classify algorithms
Big Oh     | O(N^2)    | develop upper bounds
Big Omega  | Omega(N^2)| develop lower bounds

*Common mistake:* Interpreting big-Oh as an approximate model.

Approximate model: Tilde notation
