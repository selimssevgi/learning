# JUnit Annotations

### @Test

- Annotate test classes
- Testing exception @Test(expected=NullPointerException.class)
- Performance test, @Test(timeout=100)

## @Before

- Before each test method runs
- setUp()
- Used when several tests need similar objects created before they can run

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

### @AfterClass

- After all tests in the class
- Should be static method
- public static void afterClass()
- Close sources(database)

## @RunWith(Suite.class)

## @SuiteClasses({ClassTest1.class, ClassTest2.class})

## @RunWith(Parameterized.class)
## @Parameters

- public static Collection testConditions()
