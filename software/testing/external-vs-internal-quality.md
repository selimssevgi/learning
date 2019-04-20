## external and internal quality

- from Growing OO Software

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
