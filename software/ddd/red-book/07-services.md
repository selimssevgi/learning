# Services

## What it is not

- a coarse-grained component that enables a remote client to interact with a
  complext business system.

- That basically descries a service in a SOA.

- There are different technologies and approaches for developing SOA services.

- In the end these kidns of services emphasize system-level RPCs or
  message-oriented middleware (MoM), where other systems across the data center,
  or across globe, are able to interact with the service to caryy out business
  transactions. None of those is a Domain Service.

- Do not confuse a Domain Service with an Application Service.

- Don't want to house business logic in an Application Service, but do want to
  house BLogic in a Domain Service.

- Just because a Domain Service has the word 'service' in its name does not mean
  that it is required to be a coarse-grained, remote capable, heavyweight
  transactional operation.

** There are times when a DService is concerned with remote invocations on a
foreign BContext. Yet, the focus here is different in that the DService is not
itself providing a RPC interface but is rather the client of the RPC.

## What it is

When a significant process or transformation in the domain is not a natural
responsibility of an ENTITY or VO, add an operation to the model as a standalone
interface declared as a SERVICE. Make the SERVICE stateless.

* You can use a Domain Service to

- Perform a significant business process
- Transform a domain object from one composition to another
- Calculate a Value requiring input from more than one domain object


** A Service in the Dmain is welcome to use Repositories as needed, but
accessing Repositories from an Aggregate instance is not a recommended practice.

** Address transactions and security as application concerns in Application
Services, not in Domain Services.
