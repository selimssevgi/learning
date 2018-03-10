# Continuous Integration

- Having defined a BOUNDED CONTEXT, we must keep it sound.

When a number of people are working in the same BOUNDED CONTEXT, there is a
strong tendecy fro the model to fragment. The bigger team, the bigger the
problem. but as few as three or four people can encounter serious problems. Yet
breaking down the system into ever-smaller CONTEXTS eventually loses a valuable
level of integration and coherency.

- Sometimes developers do not fully understand the intent of some object or
  interaction modeled by someone else, and they change it in a way that makes it
  unusable for its original purpose.

- Sometimes they don't realize that the concepts they are working on are already
  embodied in another part of the model and they duplicate (inexactly) those
  concepts and behavior.

- Sometimes they are aware of those other expressions but are afraid to teamper
  with them, for fear of corrupting the existing functionality, and so they
  proceeed to duplicate concepts and functionality.

- It is very hard to maintain the level of communication needed to develop a
  unified system of any size. We need ways of increasing communication and
  reducing complexity. WE also need safety nets that prevent overcautious
  behavior, such as developers duplicating functionality because they are afraid
  they will break existing code.

- CI is essential only within a BOUNDED CONTEXT. Design issues involving
  neighboring CONTEXT, including translation, don;t have to be dealt with at the
  same pace.
