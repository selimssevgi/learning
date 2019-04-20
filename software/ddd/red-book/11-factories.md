# Factories

- GOF: Abstract Factory, Factory Method, and Builder

Shift the responsibility for creating instances of complex objects and
AGGREGATES to a separate object, which may itself have no responsibility in the
domain model but is still part of the domain design. Provide an interface that
encapsulates all complex assembly and does not require the client to reference
the concrete classes of the objects being instantiated. Create entire AGGREGATES
as a piece, enforcing their invariants. [Evans]

## Factory Method on Aggregate Root

```java
public class Product {
  public BacklogItem planBacklogItem(...) {}
}
```

- If our design were to support only a public constructor, it would reduce the
  expressiveness of the model and we would not be able to explicitly model that
  part of the Language of the domain.

## Factory on Service

```java
public interface CollabolatorService {
  
  Author authorFrom(Tenant aTenant, String anIdentity);

  Creator creatorFrom(Tenant aTenant, String anIdentity);

  Moderator moderatorFrom(Tenant aTenant, String anIdentity);

  Owner ownerFrom(Tenant aTenant, String anIdentity);
}
```

- This Service provides object translation from the Identity and Access Context
  to the Collaboration Context.

- To accomplish this, the team will need to interact with the IAContext behind a
  Service and transform user and role objects from that model into corresponding
  collaborator objects of their own model's Context.
