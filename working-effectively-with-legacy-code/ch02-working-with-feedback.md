# ch02: working with feedback

- changes in a system can be made in two primary ways:

1. edit and pray
2. cover and modify


- edit and pray: make changes, and then spend extra time poking around if smth
  got broken, it seems like "working with care", surgeon with a better knife
  just before he worked with care?

- covering software means covering it with tests. having that 'safety net' while applying changes

- "testing to attempt to show correctness" and "testing to detect change" (regression testing)

**The legacy code dilemma:** When we change code, we should have tests in place.
To put tests in place, we often have to change code.

- When you break dependencies in legacy code, you often have to suspend your
  sense of aesthetics a bit. There will be scar left after the surgery, but
  everything under can get better. In time, the scar can be healed.

## legacy code change algorithm

1. identify change points

2. find test points

3. break dependencies

4. write tests

5. make changes and refactor
