# Consumer-driven Contracts Workflow

* Everything starts on the consumer side.

- Write an inter-service failing consumer test
- Define a contract (copy of provider project in local, install contract inside that)
- Build stubs from the contract (use framework with provider)
- Make the consumer test pass (now consumer side has the stub to use for tests)

- Send a PR with the changes to contract to provider project
- Provider side takes over the new contract and fails
- Make provider contract verification tests pass


"Consumer-driven contracts are like TDD applied at the API level." - Grzejszczak
