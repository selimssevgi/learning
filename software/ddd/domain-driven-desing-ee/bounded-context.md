# Bounded Context

- Cells can exist because their membranes define what is in and out and
  determine what can pass.


Multiple models are in play on any large project. Yet when code based on
distinct models is combined, software becomes buggy, unreliable, and difficult
to understand. Communication among team members becomes confused. It is often
unclear in what context a model should not be applied.


Explicitly define the context within which a model applies. Explicitly set
boundaries in terms of team organization, usage within specific parts of the
application, and physical manifestations such as code bases and db schemas. Keep
the model strictly consistent within these bounds, but don't be distracted or
confused by issues outside.

-  Integration across the boundaries necessarily will involve some translation,
   which you can analyze explicitly.

- The team responsible for the model deals with the whole life cycle of each
  object, including persistence. The schema is being driven by the model and
  therefore is in bounds.

- If two teams are not in the same CONTEXT, they should stop trying to share
  code until placing processes to manage the situation. (SHARED KERNEL)

## CONTEXT MAP

- Boundaries are special places.

- The relationships between a BOUNDED CONTEXT and its neighbors require care and attention.

- The CONTEXT MAP charts the territory, giving the big picture of the CONTEXTS
  and their connections.

### Favoring Larger BOUNDED CONTEXTS

- Flow between user tasks is smoother when more is handled with a unified model.

- It is easier to understand one coherent model than two distinct ones plus mappings.

- Translation between two models can be difficult (sometimes impossible)

- Shared language fosters clear team communication.

### Favoring Smaller BOUNDED CONTEXTS

- Communication overhead between developers is reduced.

- CI is easier with smaller teams and code bases.

- Larger contexts may call for more versatile abstract models, requiring skills
  that are in short supply.

- Different models can cater to special needs or encompass the jargon of
  specialized groups of users, along with specialized dialects of the UBIQUITOUS
  LANGUAGE.
