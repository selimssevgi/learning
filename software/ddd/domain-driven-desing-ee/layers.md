# Four Conceptual Layers

1. UI (or Presentation Layer)

Responsible for showing information to the user and interpreting the user's
commands. The external actor might sometimes be another computer system rather
than a human user.

2. Application Layer

Defines the jobs the software is supposed to do and directs the expressive
domain objects to work out problems. The tasks this layer is responsible for are
meaningful to the business or necessary for interaction with the application
layers of other systems.

This layer is kept thin. It does not contain business rules or knowledge, but
only coordinates tasks and delegates work to collaborations of domain objects in
the next layer down. It does not have state reflecting the business situation,
but it can have state that reflects the progress of a task for the user or the
program.

3. Domain Layer (or Model Layer)

Responsible for representing concepts of the business, information about the
business situation, and business rules. State that reflects the business
situation is controlled and used here, even though the technical details of
storing it are delegated to the infrastructure. This layer is the heart of
business software.

4. Infrastructure Layer

Provides generic technical capabilities that support the higher layers; message
sending for the application, persistence for the domain, drawing widgets for the
UI, and so on. The infrastructure layer may also support the pattern of
interactions between the four layers through an architectural framework.
