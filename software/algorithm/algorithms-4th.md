# Algorithms, 4th Edition

- Booksite: algs4.cs.princeton.edu

- What is the difference between a for loop and its while formulation?
  - The code in the for loop header is considered to be in the same block as the for loop body.
  In a typical for loop, the incrementing variable is not available for use in later statements;
  in the corresponding while loop, it is. This distinction is often a rea- son to use a while instead of a for loop.

- an abstract data type (ADT) is a data type whose representation is hidden from client

- the primary difference is that we associate data with the function
  implementations and we hide the implementation of the data from the client

- when `using` an ADT, we focus on the `operations` specified in the API and pay
  no attention to the data representation

- when `implementing` an ADT, we focus on the `data`, then implement the operations on that data

- objects are characterized by 3 essential properties:
  1. state
  2. identity
  3. behavior


- One of Java’s characteristic features is its policy that references cannot be
  modified. This policy enables Java to do efficient automatic garbage
  collection.
