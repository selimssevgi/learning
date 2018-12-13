# Spock vs JUnit

Spock                        | JUnit
------------------------------------------
Specification                | Test class
setup()                      | @Before
cleanup()                    | @After
setupSpec()                  | @BeforeClass
cleanupSpec()                | @AfterClass
Feature                      | Test
Feature Method               | Test Method
Data-driven feature          | Theory
Condition                    | Assertion
Exception condition          | @Test(expected=...)
Interaction                  | Mock expectation (e.g. in Mockito)

## Mocking and Stubbing

- With JUnit, you need a third-party library like Mockito for such capability

- Spock comes with built-in support for "faking" external object communication

## Assert vs Assertions

- the preferred way is to use Spock 'assertions' instead, a feature s powerful
  that it has been backported to Groovy itself. (Power Asserts)

- Spock provides detailed information on failure(like intermediate results), in JUnit failed test, you need
  to run the test in a debugging session to find out what went wrong.

## Testing Method Names

- JUnit method names can be cryptic to non-technical people

- def "Can write method name as English-like sentences in Spock"() {}
