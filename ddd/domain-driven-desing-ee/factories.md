# Factories

- When creation of an object, or an entire AGGREGATE, becomes complicated or
  reveals too much of the internal structure, FACTORIES provide encapsulation.

- Creation of an object can be a major operation in itself, but complex assembly
  operations do not fir the responsibility of the created objects. Combining
  such responsibilities can produce ungainly designs that are hard to
  understand. Making the client direct construction muddies the design of the
  client, breaches encapsulation of the assembled object or AGGREGATE, and
  overly couples the client to the implementation of the created object.

- Complex object creation is a responbility of the domain layer, yet that task
  does not belong to the objects that express the model.

- Object creation and assembly usually have no meaning in the domain; they are a
  necessity of the implementation. To solve this problem, we have to add
  constructs to the domain design that are not ENTITIES, VALUE OBJECTS, or SERVICES.

- We are adding elements to the design that do not correspond to anything in the
  model, but they are nonetheless part of the domain layer's responsibility.

- A program element whose responsibility is the creation of other objects is called a FACTORY.


Shift the responsibility for creating instances of complex objects and
AGGREGATES to a separate object, which may itself have no responsibility in the
domain model but is still part of the domain design. Provide an interface that
encapsulates all complex assembly and that does not require the client to
reference the concrete classes of the object being instantiated. Create entire
AGGREGATES as a piece, enforcing their invariants.
