# Three Ground Rules

1. Run ludicrously fast (if slow, you wont run tests often)

- Safety net againts regression

- Detect bugs early and cheaply

- Rapid feedback loop is required

- Run tests on every change

* Consequences:
  - no sleep or waits in tests (too slow)
  - againts a database, file operaiton, rest endpoint (too slow)

2. Small and focused

- only few lines of code

- clear structure: Assert/Act/Arrange

- Only one failing test for each bug

- Test name indicates the problem

3. 100% Reliable

- drop everything to fix failure

- reason must be obvious

- failures should be rare

- correlation with modified code

- "magical rerun" drives developers mad

- lose of trust in safety net
