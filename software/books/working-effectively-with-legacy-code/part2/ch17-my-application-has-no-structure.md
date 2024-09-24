# ch17 - my application has no structure

- architect should be in the team, or spend enough time with the team. so people
  will not lose the sight of the big picture

### telling the story of the system

- simplified version of what the system and its component are doing

- we should always talk about the big picture, so we wont lose the sight

### naked CRC

- CRC stands for Class, Responsibility, and Collaborations

- there are just two guidelines in Naked CRC:

1. cards represent instances, not classes

2. overlap cards to show a collection of them

### conversation scrutiny

- Are the concepts you're using in conversation the same as the concepts in the code?

- software has to satify stronger constraints than just being easy to talk
  about, but if there isn't a strong overlap between conversation and code, it
  is important to ask why.

- one of the worst mistakes a team can make is it to feel that design is over at
  some point in development

- if design is "over" and people are still making changes, chances are good that
  new code will appear in poor places, and classes will bloat because no one
  feels comfortable introducing new abstraction. There is no surer way to make a
  legacy system worse.
