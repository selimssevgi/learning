# Specification

- In all kinds of applications, Boolean test methods appear that are really
  parts of little rules. As long as they are simple, we handle them with testing
  methods, such as anIterator.hasNext() or anInvoice.isOverdue()

- Not all rules are so simple.

- Compilecated rules and other object in the play, the clarity of the main
  object will soon be lost in the sheer mass of rule evaluetion code.

- The main object will also develop all sorts of dependencies on domain classes
  and subsystems that do not support that basic meaning.

- At this point, in an attempt to save the Invoice class, a developer will often
  refractor the rule evaluation code into the application layer. Now the rules
  have been separated from the domain layer altogether, leaving behind a dead
  data object that does not express the rules inherent in the business model.

- These rules need to stay in the domain layer, but they don't fit into the
  object being evaluated. Not only that, but evaluating methods swell with
  conditional code, which make the rule hard to read.


Business rules often do not fit the responsbility of any of the obvious ENTITIES
or VALUE OBJECT, and their variety and combinations can overwhelm the basic
meaning of the domaon object. But moving the rules out of the domain layer is
even worse, since the domain code no longer expresses the model.


Create explicit predicate-like VALUE OBJECTS for specialized purposes A
SPECIFICATION is prpedicate that determines if an object does or does not satify
some criteria.

- The SPECIFICATION keeps the rule in the domain layer.

- A FACTORY can configure a SPECIFICATION using information from other sources,
  such as the customer's account or the corporate policy database.

## Applying and Implementing SPECIFICATION

1. To validate an object to see if it fullfills some need or is ready for some purpose.

2. To select an object from a collection

3. To specify the creation of new object to fit some need
