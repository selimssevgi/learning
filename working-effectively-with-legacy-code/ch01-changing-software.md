# Ch01 - Changing Software

- four reasons to change software

1. adding a feature (see it as behavior change)
2. fixing a bug (see it as behavior change: there was a bug, now there is not)
3. improving the design
4. optimizing resource usage

- modifing existing code could be seen as changing behavior
- adding and calling(adding is not enough) it could be seen as adding behavior
- any additation could be seen as behavior change: a new button in the ui

- the act of improving design without changing its behavio is called 'refactoring'
- improving design and optimization have different goal: no functional changes


                   | adding a feature | fixing a bug | refactoring | optimizing
--------------------------------------------------------------------------------
structure          | changes          | changes      | changes     | -
functionality      | changes          | changes      | -           | -
resource usage     | -                | -            | -           | changes

- adding features, refactoring, and optimizing all hold existing functionality
  invariant.


### risky change

- to mitigate risk, we have to ask 3 questions:

1. what changes do we have to make?

2. how will we know that we have done them correctlly?

3. how will we know that we haven't broken anything?

- avoid changes, getting rusty
