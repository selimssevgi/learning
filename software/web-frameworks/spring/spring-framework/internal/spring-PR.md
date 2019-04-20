# Spring Framework PR

## spring-framework:spring-beans

- ExtendedBeanInfo#standardReadMethodsAndOverloadedNonStandardWriteMethods
  - there are dupcalite lines

- AbstractPropertyValuesTests#doTestTony

```java
    PropertyValue[] ps = pvs.getPropertyValues();
    Map<String, String> m = new HashMap<>();
    m.put("forname", "Tony");
    m.put("surname", "Blair");
    m.put("age", "50");
    for (int i = 0; i < ps.length; i++) {
      Object val = m.get(ps[i].getName()); // dont we know return type is string already?
      assertTrue("Can't have unexpected value", val != null);
      assertTrue("Val i string", val instanceof String); // compiler already validates this?
      assertTrue("val matches expected", val.equals(ps[i].getValue()));
      m.remove(ps[i].getName());
    }
    assertTrue("Map size is 0", m.size() == 0); // isEmpty?
```
