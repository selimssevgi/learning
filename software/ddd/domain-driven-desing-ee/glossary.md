# Glossary

### AGGREGATE

A cluster of associated objects that are treated as a unit for the purpose of
data changes. External references are restricted to one member of the AGGREGATE,
designated as the root. A set of consistency rules applies within the
AGGREGATE's boundaries.

### Analysis pattern

A group of concepts that represents a common construction in business modeling.
It may be relevant to only one domain or may span many domains. (Fowler 1997)

### ASSERTION

A statement of the correct state of a program at some point, independent of how
it does it. Typically, an ASSERTION specifies the result of an operation or an
invariant of a design element.

### BOUNDED CONTEXT

The delimited applicability of a particular model. BOUNDING CONTEXTS gives team
members a clear and shared understanding of what has to be consistent and what
can develop independently.

### cohesin

Logical agreement and dependence.

### command (a.k.a. modifier)

An operation that effects some change to the system (for example, setting a
variable). An operation that intentionally creates a side effect.

### CONCEPTUAL CONTOUR

An underlying consistency of the domain itself, which, if relected in a model,
can help design accommodate change more naturally.

### CONTEXT MAP

A representation of the BOUNDED CONTEXTS involved in a project and the actual
relationships between them and their models.

### CORE DOMAIN

The distinctive part of the model, central to the user's goals, that
differentiates the application and makes it valuable.

### ENTITY

An object fundamentally defined not by its attributes, but by a thread of
continuity and identity.

### FACTORY

A mechanism for encapsulating complex creation logic and abstracting the type of
a created object for the sake of a client.

### life cycle

A sequence of states an object can take on between creation and deletion,
typically with constraints to ensure integrity when changing from one state to
another. May include migration of an ENTITY between systems and different
BOUNDED CONTEXTS.

### REPOSITORY

A mechanism for encapsulating storage, retrieval, and search behavior which
emulates a collection of objects.

### SERVICE

An operation offered as an interface that stands alone in the model, with no
encapsulated state.

### VALUE OBJECT

An object that describes some characteristic or attribute but carries no concept
of identity.

### WHOLE VALUE

An object that models a single, complete concept.
