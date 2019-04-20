# Application

- The user interface will make use of application-level services that coordinate
  use case tasks, manage transactions, and assert necessary security
  authorizations.

- The user interface, Application Services, and domain model will rely on
  enterprise platform-specific infrastructural support.

- DTO, DPO (Data Payload Object: holds references to aggregates)

## Application Services

- The Application Services are the direct clients of the domain model.

- These are responsible for task coordination of use case flows, one service per
  flow.

- When using an ACID database, the Application Services also control
  transactions, ensuring that model state transitions are atomically persisted.

- Security is also commonly cared for by Application Services.

- We should strive to push all business domain logic into the domain model,
  whether that be in Aggregates, Value Objects, or Domain Services.

- Keep Application Services thin, using them only to coordinate tasks on the model.

- For methods with many parameters in Application Service, a Command(GOF) object can
  be used. UserCreationCommand: carrying data for outside for user creation.

```java
public String provisionTenant(ProvisionTenantCommand aCommand) {}
```

## Infrastructure

- The job of the infrastructure is to provide technical capabilities for other
  parts of your application.

- When an Application Service looks up a Repository, it will be dependent only
  on the interface from the domain model, but using the implementation from the
  infrastructure.

- Implementations of Repositories are kept in the infrastructure because they
  deal with storage, which is not a responsibility that the model should take on.
