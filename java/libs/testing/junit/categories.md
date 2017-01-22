# JUnit Categories

```java
public  interface SmartTests  { /*  category  marker  */  }
public  interface CrazyTests  { /*  category  marker  */  }

public  class SomeTest  {
    @Test
    public  void  a() {
        fail();
    }

    @Category(CrazyTests.class)
    @Test
    public  void  b() {
    }
}

@Category({CrazyTests.class,  SmartTests.class})
public  class OtherTest {
    @Test
    public  void  c() {
    }
}

@RunWith(Categories.class)
@IncludeCategory(CrazyTests.class)
@SuiteClasses(  { SomeTest.class, OtherTest.class })  //  Note  that  Categories is  a kind  of  Suite
public  class CrazyTestSuite  {
    //  Will  run SomeTest.b  and OtherTest.c,  but not SomeTest.a
}

@RunWith(Categories.class)
@IncludeCategory(CrazyTests.class)
@ExcludeCategory(SmartTests.class)
@SuiteClasses(  { SomeTest.class, OtherTest.class })  
public  class CrazyTestSuite  {
    //  Will  run SomeTest.b, but not SomeTest.a  or  OtherTest.c
}
```
