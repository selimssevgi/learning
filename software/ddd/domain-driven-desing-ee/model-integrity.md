## Maintaining Model Integrity

- The most fundamental requirement of a model is that it be internally
  consistent; that its terms always have the same meaning, and that it contain
  no contradictory rules.

- The internal consistency of a model, such that each term is unambigous and no
  rules contradict, is called *unification*.

- A model is meaningless unless it is logically consistent.

- In large systems development to maintain high consistency of unication in an
  entire enterprise system is more trouble than it is worth. It is necessary to
  allow multiple models to develop in different parts of the system in a careful way.

- Total unification of the domin model for a large system will not be feasible or cost-effective.

- to unify all the software in a large project under a single model risks:

1. Too many legacy replacements may be attempted at once.

2. Large projects may bog down because the coordination over-head exceeds their abilities.

3. Applications with specialized requirements may have to use models that don't
   fully satify their needs, forcing them to put behavior elsewhere.

4. Conversely, attempting to satisfy everyone with a single model may lead to
   complex options that make the model difficult to use.
