# Java Language Improvements

- Underscore as identifier illegal

- Improved try-with-resources

- Better generic type inference for anonymous classes

- Private interface methods

## Private interface methods

```java
public interface PricedObject {
  double getPrice();

  // evolving the interface later on

  default double getPriceWithTax() {
    return getPrice() * 1.21;
  }

  default double getOfferPrice(double discount) {
    return getPrice() * 1.21 * discount; // getPriceWithTax() * discount
  }

  // assume we have complex code duplication in those default methods
  // Add a helper method? which should not be public part of the interface
  private double getTaxedPriceInternal() {
    return getPrice() * 1.21;
  }
}
```
## Improved try-with-resources

```java
// before java 9: need to declare a new variable
public void doWithFile(FileInputStream fis) throws IOE {
  try (FileInputStream fis2 = fis) {
    fis2.read();
  }
}

// with java 9, can use effectively final var in try
public void doWithFile(FileInputStream fis) throws IOE {
  try (fis) {
    fis2.read();
  }
}
```

## Better generic type inference for anonymous classes


```java
// before java 9, could not infer the type
ArrayList<String> list3 = new ArrayList<>() {
  @Override
  public boolean add(String s) {
    sout("Adding " + s);
    return super.add(s);
  }
}

// java 9 compiler can infer the type
```
