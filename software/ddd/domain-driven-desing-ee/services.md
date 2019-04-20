# Service

- Sometimes, it just isn't a thing.

- In some cases, the claerest and most pragmatic design includes operations that
  do not conceptually belong to any object. Rather than for the issue, we can
  follow the natural contours of the problem space and include SERVICEs
  explicitly in the model.

- There are important domain operations that can't find a natural home in an
  entity or value object.

- Forcing the required domain functionality to be the responsbility of an ENTITY
  or VALUE either distorts the definition of a model-based object or adds
  meaningless artificial objects.

- A SERVICE is an operation offered as an interface that stands alone in the
  model, without encapsulating state.

- A SERVICE tends to be named for an activity, rather than an entity.

- Operation names should come from the UBIQUITOUS language, parameters and
  results should be domain objects.


- A good SERVICE has three characteristics:

1. The operation relates to a domain concept that is not a natural part of an ENTITY or VO.

2. The interface defined in terms of other elements of the domain model.

3. The operation is stateless.

- The execution of a SERVICE will use information is accessible globally, and
  may even change that global information (side-effect), but the SERVICe does
  not hold the state of its own that affects its own behavior, as most domain objects do.

## Service and the Isolated Domain Layer

- This pattern is focused on those SERVICES that have an important meaning in
  the domain in their own right.

- Most SERVICES discussed in the literature are purely technical and belong in
  the infrastructure layer.

- If the banking application can convert and export our transactions into a
  spreadsheet file for us to analyze, that export is an application SERVICE.
  There is no meaning of "file formats" in the domain of banking, and there are
  no business rules involved.

- A feautre that can transfer funds from one account to another is a domain
  SERVICE because it embeds significant business rules, and becuase a "funds
  transfer" is a meaningful banking term. In this case the SERVICE does not do
  much on its own; it would ask the two Account objects to do most of the work.
  But to put the "transfer" operation on the Account object would be awkward,
  because the operation involves two accounts and some global rules.
