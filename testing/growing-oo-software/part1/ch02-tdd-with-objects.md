# ch02 - tdd with objects

- an object communicates by messages
  - it receives messages from other objects
  - reacts by sending messages to other objects
  - returning a value or exception to the original sender

#### values and objects

- values model unchanging quantities or measurements (immutable)

- objects have an identity, might change state over time, model computational processes

- in practice, we split our system into two "worlds":
  - values, which are treated functionally
  - objects, which implement the stateful behavior of the system

#### follow the messages

- a communication pattern is a set of rules that govern how a group of objects
  talk to each other: the roles they play, what messages they can send and when and so on

- in java we identify object roles with interfaces

#### tell, don't ask

- the calling object should describe what it wants in terms of the role that its
  neighbor plays, and let the called object dcide how to make that happen

- or known more formally as 'Law of Demeter'

- avoid navigating to other objects so codebase will be more flexible for swapping objects for the same role

```shell
// train wreck
((EditSaveCustomizer) master.getModelisable()
  .getDockablePanel()
    .getCustomizer())
      .getSaveItem().setEnabled(Boolean.FALSE.booleanValue());

// clear, more intention revealing, internal hiding, method
master.allowSavingsOfCustomisations();
```

- occasionally, we also ask objects about their state when searching or filtering

#### unit-testing the collaborating objects

- for example an objects will send messages to one or more of its neighbors when
  invoked. How can we test that it does so correctly without exposing any of its
  internal state?

- use mocks, mock objects assert that
  - they have been called as expected
  - they also implement any stubbed behavior needed to make the rest of test work

- we can use the test to help us tease out the supporting roles our object
  needs, defined as java interfaces, and fill in real implementations later

- 'interface discovery'
