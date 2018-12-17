# ch06 - i dont have much time and i have to change it

- pay now or pay more later

### sprout method

- when you need to add a feature to a system and it can formulated completely as
  new code, write the code in a new method.

- you might not be able to get those call points under test easily, but at the
  very least, you can write tests for the new code.

```java
public class TransactionGate {
  public void postEntries(List entries) {
    for (Entry entry : enties) {
      entry.postDate();
    }
    transactionBundle.getListManager().add(entries);
  }
}
```

- we need to add code to verify that none of the new entries are already in
  transactionBundle before we post their dates and add them

```java
public class TransactionGate {
  public void postEntries(List entries) {
    List entriesToAdd = new LinkedList();
    for (Entry entry : enties) {
      if (!transactionBundle.getListManager().hasEntry(entry)) {
        entry.postDate();
        entriesToAdd.add(entry);
      }
    }
    transactionBundle.getListManager().add(entriesToAdd);
  }
}
```

- new code with old code, more complicated, two operation: date posting and duplicate entry detection

```java
public class TransactionGate {
  List uniqueEntries(List entries) {
    List result = new ArrayList();
    for (Entry entry : enties) {
      if (!transactionBundle.getListManager().hasEntry(entry)) {
        result.add(entry);
      }
    }
    return result;
  }

  public void postEntries(List entries) {
    List entriesToAdd = uniqueEntries(entries);
    for (Entry entry : entriesToAdd) {
        entry.postDate();
      }
    }
    transactionBundle.getListManager().add(entriesToAdd);
  }
}
```

### sprout class

- situations where you can create objects of that class to test your sprout method.

- you can create another class to hold your changes and use it from the source class

- essentially two cases lead us to Sprout Class:

1. your changes lead you toward adding an entirely new responsibility to one of your class

2. we have a small bit of functionality that we could place into an existing
   class, but we can't get the class into a test harness.

### wrap method

```java
public class Employee {
  public void pay() {
    // payment operation
  }
}
```

- every time that we pay an employee, we have to update a file with the
  employee's name so that it can be sent off to some reporting software.

```java
public class Employee {
  private void dispatchPayment() {
    // payment operation
  }

  public void pay() {
    logPayment();
    dispatchPayment();
  }

  private void logPayment() {
    // log operation
  }
}
```

- added functionality without affecting client side


* sprout method and class add code to existing methods and make them longer by
  at least one line, but wrap method does not increase the size of existing methods

### wrap class

- LoggingEmployee, calls super method for payment after logging

- this technique is called the decorator pattern
