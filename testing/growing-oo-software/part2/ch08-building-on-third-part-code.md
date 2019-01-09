# ch08 - building on third-party code

- the critical point about third-party code is that we don't control it, so we
  cannot use our process to guide its design. instead, we must focus on the
  'integration' between our design and the external code

### only mock types that you own

- although, we know how we want our abstraction to behave, we don't know if it
  really does so until we test it in combination with the third-party code

### write an adapyer layer

- if we don't want to mock an external API, how we test the code that drives it?

- we will have used TDD to design interfaces for the services our objects need,
  which will be defined in terms of our objects' domain, not the external library

- we write a layer of adapter objects that uses the third-party API to implement these interfaces

- we keep this layer as thin as possible, to minimize the amount of potentially
  brittle and hard-to-test code

- we test these adapters with focused integration tests to confirm our
  understanding of how the third-party API works


* there are some exceptions where mocking 3rd party lib can be helpful.

- we might use mocks to simulate behavior that is hard to trigger with real
  library, such as throwing exceptions

### mock application objects in integration tests

