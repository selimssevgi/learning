# Twelve ways to make code suck less

- Venkat - 2018 Oracle Code

- We can't be agile if our code sucks

- code is how we tell our colleagues how we feel about them

- "lowering quality lengthens development time" -- first law of programming

### What is Quality Code?

- the quality of code inversely proportional to the effort it takes to understand it

### Twelve ways we can help

12. schedule time to lower technical debt
  - non-upgraded tools and frameworks

11. Favor high cohesion
  - narrow focus code, does only one thing well
  - lowering cost of maintaining code
  - more cohesive, less change

10. Favor loose coupling
  - new keyword for coupling
  - tight coupling make code: hard to extend, hard to test

09. Program with intention
  - best-comment-in-source
  - // when i wrote this, only god and i understood what i was doing
  - // now, god only knows

* Beck's Rule for Simple Design, by priority

1. passes the tests (implicitly saying we have tests!)
2. reveals intention
3. no duplication
4. fewest elements

08. Avoid primitive obsession
  - general purpose things already done in libraries, use them
  - are you the chosen one for this task? (domain specific yes, general no)
  - imperative code has hidden complexity
  - functional style == declaritive style + high order

07. Prefer clear code over clever code
  - programs must be written for people to read, only incidentally for machines to execute
  - 10% of the time, we write ugly code for performance reasons, the other 90%
    of the time, we write ugly code to be consistent.
  - those who sacrifice quality to get performance may end up getting neither

06. Apply Zinsser's principle on writing
  - on writing well - William Zinsser
  - simplicity, clarity, brevity, humanity

05. Command why, not what
  - i++; // increment
  - write expressive self-documenting code
  - a good code is like a good joke
  - writing comments is like explaining a joke
  - those who can't design are condemned to document - (pull to turn on)

04. avoid long methods -- apply SLAP (single level of abstraction)
  - how long is long?
  - turns out long is not about length of code, but levels of abstraction

03. Give good meaningful names

02. Do tactical code reviews
  - review tests first
  - in case of a bug, write a test that fails, and check-in

01. reduce state & state mutation
