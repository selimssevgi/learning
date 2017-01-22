# JUnit Annotations

### @Test

- Annotate test classes
- Testing exception @Test(expected=NullPointerException.class)
- Performance test, @Test(timeout=100)

## @Before

- Before each test method runs
- setUp()
- Used when several tests need similar objects created before they can run
- Each test runs with a fresh resources created in @Before method.
- Create EntityManager

## @After

- After each test method runs
- tearDown()
- Releasing allocated external resources

### @BeforeClass

- Before all tests in the class
- Should be static method
- Runs before constructor is called
- public static void beforeClass()
- Open sources(database)
- Create EntityManagerFactory

### @AfterClass

- After all tests in the class
- Should be static method
- public static void afterClass()
- Close sources(database)

## @RunWith(Suite.class)

- JUnit will invoke the class it references(Suite.class) to run the tests in
  that class instead of runner built into JUnit.

## @SuiteClasses({ClassTest1.class, ClassTest2.class})

## @RunWith(Parameterized.class)
## @Parameters

- public static Collection testConditions()

## @Ignore

- failing test blocks you to check-in in a mission critical code
- instead of waiting to be fixed, commenting out
- JUnit will not run @Ignore tests.
- @Ignore("reason of ignoring the test")

## @FixMethodOrder

- JUnit depends on reflection to execute tests, randomness comes from JVM
- We can specify an order
- Class level annotation
- @FixMethodOrder(MethodSorters.JVM)
- @FixMethodOrder(MethodSorters.NAME_ASCENDING)
- @FixMethodOrder(MethodSorters.DEFAULT)
