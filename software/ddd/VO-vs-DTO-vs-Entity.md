# DTO vs Value vs Entity Object

### DTO - Data Transfer Object

- DTO is a class representing some data with no logic in it.

- DTOs are usually used for transferring data between different applications or
  different layers within a single application.

- DTOs are dumb bags of information the sole purpose of which is to just get
  this information to a recipient.

### Value Object

- VO is a full member of your domain model.

- It conforms to the same rules as Entity.

- The only difference between VO and Entity is that VO doesnot have its own
  identity.

- VO with the same property set should be considered the same whereas two
  Entities differ even if their properties match.

- VOs do contain logic and, typically, they are not used for transferring data
  between application boundaries.
