# Motivation for CDC

### End-to-end testing microservices

- Automated tests
- Browser or other UI
- Environment(services)

- Selenium

- Not testing individual microservice, but the system as a whole

### Shortcomings of End-to-end testing

- They take a long time to run (need fast test and release)

- failures are hard to debug, especially if async (no logs of failure from ui)

- The infrastructure cost is high

- Operationally challenging

- They can be flaky

- we are testing a distributed monolith

## Mocking or Stubbing microservices

- Automated tests
- Microservice
- Mock or stub of dependency

- We can test the microservice itself in isolation

### Shortcomings of Mocking and Stubbing

- slow to create

- difficult to maintain (change to api, change to all mocks)

- can easily give false positives

## The Weak Feedback Loop

- Run individual microservice tests (possible false positive)

- Build and deploy to stage

- End-to-end test (slow and the first "real" failures, preferable to catch them in local)

- Release
