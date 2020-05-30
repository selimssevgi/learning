# ch06 - while you are coding

- coding is not mechanical - transcribing the design into executable statements

## programming by coincidence

- soldier checking the field for minefield, for some steps there is nothing(luck),
  then starts to walk freely, and boom

- as developers, we also work in minefields

- we should not rely on luck and accidental successes

### how to program by coincidence

- type a little code, try, and seems to work
- type a little code, try, and seems to work
- type a little code, try, and seems to work
- type a little code, try, and seems to work
- type a little code, try, and does not work

- we dont know why the code is failing because we didnot know why it worked in the first place

- for routines you call, rely only on documented behavior
  - if cant, for whatever reason, then document your assumption well

### how to program deliberately

- be aware of what you are doing

- dont code blindfolded

- proceed from a plan

- rely only on reliable things, dont depend on accidents or assumptions

- document your assumptions

- dont just test your code, but test your assumptions as well

- prioritize your effort

- dont be a slave to history

## algorithm speed

- most significant algorithms are not linear

- simple loops: O(n)
- nested loops: O(m x n)
- binary chop: O(lg(n))
- d&concquer: O(nlg(n))
- combinatoric: n!

## refactoring

- software is not construction(building), is more like gardening

- we are not building skyscrapers, we aren't as constrained by the boundaries of
  physics and the real world

### when should you refactor?

- duplication
- nonorthogonal design
- outdated knowledge
- performance

- medical analogy: think of the code that needs refactoring as a "growth".  removing it requires invasive surgery
  - go in now, take it out while it is still small
  - wait while it grows and spreads, removing both more expensive and dangerous
  - wait longer, and lose the patient entirely

- keep track of the things that need to be refactored

### how do you refactor?

- dont try to refactor and add functionality at the same time

- make sure you have good tests before you begin refactoring

- take short, deliberate steps

## code that's easy to test

- unit testing as testing against contract
  - ensure that a given unit honors its contract

## evil wizards

- dont use wizard code you dont understand
