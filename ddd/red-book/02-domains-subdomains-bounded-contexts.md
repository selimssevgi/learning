# Domains, Subdomains and Bounded Contexts

- Think of a retail company that sells products online

- This online retailer's Domain seems to be composed of these 4 primary Subdomains:

1. Product Catalog
2. Orders
3. Invoicing
4. Shopping

- Applying good DDD techniques, simple Subdomains can be separated from the Core
  using Modules and need not be housed in a heavy, architecturally significant
  subsystem component.

- Most of your project efforts will be focused on the Core Domain.

- Sometimes a Bounded Context is created or acquired to support the business. If
  it models some aspect of the business that is essential, yet not Code, is it a
  Supporting Subdomain.
  
- The business creates a Supporting Subdomain because it is somewhat specialized.
  Otherwise, if it captures nothing special to the business, yet is required for
  the overall business solution, it is a Generic Subdomain.


- Banking Context: Account
- Literary Context: Account

- Account objects in two different Bounded Contexts have completely different
  meanings, but you know that only by considering the name of each Bounded
  Context

- Saving Context: SavingsAccount, or could be called Account
- Checking Context: CheckingAccount, or could be called Account

- When integrations are needed, mapping must be done between Bounded Contexts.
  This can be a complex aspect of DDD and calls for a corresponding amount of
  care. We don't usually use an object instance outside its boundary, but
  related objects in multiple contexts may share some subset of common state.
  
- Generally you can determine a proper separation because the similar objects
  have different properties and operations. In that case the boundary has
  separated the concepts appropriately. However, if you see the exact same
  objects in multiple contexts, it probably means there is some modeling error,
  unless the two Bounded Contexts are using a Shared Kernel.

- Both user interface components and service-oriented endpoints delegate to
  Application SErvices. These are different kinds of services, generally
  providing security and trx management, and acting as Facade to the model. They
  are task managers, transforming use case flow requests into the execution of
  domain logic. Application Services are also inside the boundary.

- Using Java, the top-level package generally defines the highest-level Module
  name for the Bounded Context.

```shell
com.mycompany.optimalpurchasing
com.mycompany.optimalpurchasing.presentation
com.mycompany.optimalpurchasing.application
com.mycompany.optimalpurchasing.domail.model
com.mycompany.optimalpurchasing.infrastructure
```

- Only a single team should work in a single Bounded Context

- Domain
  - Agile PM Context (Agile PM(Core))
  - Identity and Access Context (Identity and Access (Generic))
  - Collaboration Context (Collaboration (Supporting))
