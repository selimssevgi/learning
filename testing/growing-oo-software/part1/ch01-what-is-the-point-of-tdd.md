# ch01 - what is the point of tdd?

- there will be a lot of new things in a project(tech, meta, techniques, processes)

- we all know there will be changes, we just don't know what changes

- we need a process that will help us cope with uncertainty as our experience grows
  - to anticipate unanticipated changes

#### feedback is the fundamental tool

- deploying completed work to some kind of environment at each cycle is critical

- without deployment, the feedback is not complete

- the nested feedback loops reinforce each other; if a discrepancy slip through
  an inner loop, there is a good change an outer loop will catch it
  - inner loops are more focused on technical detail: what a unit of code does
  - outer loops are more focused on organization and the team: whether the app serves its users' needs

- *incremental developlemt:* each feature is implemented as an end-to-end, the
  system is always integrated and ready for deployment

- *iterative developlemt:* refines the implementation in response to feedback

#### practices that support changes

- we need two technical foundations if we want to grow a system reliably and to
  cope with the unanticipated changes that always happen

1. we need constant testing, to catch regression errors, we must automate testing

2. we need to keep the code as simple as possible (easier to understand and modify)
  - test suites in the feedback loops protect us against our own mistakes as we
    improve (and change) the code

* Golder rule of TDD: never write new functionality without a failing test

- write a failing acceptance tests (outer loop)
  - write a failing test (inner loop)
  - make the test pass (from here u can step to outer loop)
  - refactor

#### testing end-to-end

- an acceptance test should exercise the system end-to-end without directly calling its internal code

- an end-to-end test interacts with teh system only from the outside:
  - through its user interface
  - by sending messages as if from the 3rd party system
  - by invoking its web services
  - by parsing reports

- we prefer to have the end-to-end tests exercise both the system and the
  process by which it's built and deployed

- an automated build will:
  - check out the latest version
  - compile and unit-test the code
  - integrate and package the system
  - perform a production-like deployment into a realistic environment
  - exercise the system through its external access points

- many of the steps might be fiddly and error-prone, so end-to-end build cycle
  is an ideal candidate for automation

#### levels of testing

* *Acceptance:* does the whole system work? // functional, customer, system tests
* *Integration:* does our code work against the code we can't change?
* *Unit:* do our objects do the right things, are they convenient to work with?

#### external and internal quality

- external quality is how well the system meets the needs of its customers and users
  - is it functional, reliable, available, responsive, etc

- internal quality is how well it meets the needs of its developers and administrators
  - is it easy to understand, easy to change, etc

- 'running end-to-end' tests tell us about the external quality, 'writing' them
  tell us something about how well we/team understand the domain, but e2e tests
  don't tell us how well we've written the code

- 'writing' unit tests gives us a lot of feedback about the quality of our code,
  'running' them tells us that we haven't broken any classes, but again, unit
  tests don't give us enough configdence that system as a whole works

- we're tempted not to write tests when our code makes it difficult, but we try
  to resist. We use such difficulties as an opportunity to investigate why the
  test is hard to write and refactor the code to improve its structure ("listening to the tests")
