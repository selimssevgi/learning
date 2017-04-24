# Lec2 - Proofs

- You dont really understand the subject until you know how to prove the basic
  facts.

- Dont memorize the things, just know how to prove, then you can debug and get
  your way through.

*Pythagorean Theorem:*

- a^2 + b^2 = c^2
- Familiar? Yes. Obvious? No.
- 4 triangles

* Proof by picture
* Proof by calculation
* Proof by contradiction
* Proof by cases
* Proof by WOP (Well Ordering Principle)

## Proof by Contradiction

- Is cubicroot(1332) <= 11?
- cube each side: 1332 <= 11^3: 1332 <= 1331?
- That is not tree, so cuberrot(1332) > 11

- If an assertion implies something "false", then the assertion itself must be
  "false"!

- If you start by accepting something is true(assumption),
- and keep proving things step by step in a way that preserves truth,
- and you arrive at something false,
- it is inevitable that what you started with must have been false,
- or else the thing you finished with would have been true.

*Theorem:* sqrt(2) is irrational.

- Suppose sqrt(2) was rational.
- So have n, d integers without common prime factors such that sqrt(2) = n / d
- no primes that divide n and d
- We will show that n and d are both even.
- That is an immediate contradiction, because then both n and d have the common
  factor 2.
- This contadicts no common factor.

- sqrt(2) = n / d
- sqrt(2) * d = n
- 2 * d^2 = n^2
- If left side is divisible by 2, then n^2 is divisible by 2, so n is even.
- so can assume; n = 2 * k
- n^2 = 4k^2 # place n^2
- 2 * d^2 = 4 * k^2
- CONTRADICTED!
- d^2 = 2 * k^2; now d^2 is divisible by 2, so n is even.
- Proof assumes that if n^2 is even, then n is even.

## Proof by Cases

- Prove something by breaking it up into pieces that are easy to prove but
  together cover all possibilities.

- if ((x > 0) || (x <= 0 && y > 100))
- if ((x > 0) || (y > 100)) // better, easier to understand.

- x > 0 and x <= 0 cases produce the same result.
- Reasoning by cases breaks a complicated problem into easier subproblems.

## Well Ordering Principle

- N ::= nonnegative integers, 0 is included.


* Prime Products
- Theorem: Every integer > 1 is a product of primes.
- Proof:(by contradiction) Suppose {nonproducts} is nonempty.

## Propositional Operators

- Propositional (Boolean) Logic
- A proposition is either True or False

- There are 5 regular solids. True
- There are 5 regular solids. False
- Non-examples:
  - Wake up!
  - Where am I?
  - 5pm, true at some times and false others

- OR, XOR, AND, NOT

- Digital Logic:
  - x(line over) ::= NOT(x)
  - 1 ::= T (voltage on line)
  - 0 ::= F (no voltage)
  - . ::= AND
  - + ::= OR
