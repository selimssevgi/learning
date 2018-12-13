# An example from 'tdd by example'


```java
// Transaction
Transaction(Money value) {
  this.value= value;
}
```


```java
// Account

Transaction transactions[];

Money balance() {
   Money sum= Money.zero();
   for (int i= 0; i < transactions.length; i++)
      sum= sum.plus(transactions[i].value);
   return sum;
}
```

- A customer has a bunch of accounts and would like to see an overall balance

- The obvious way to implement this is as a new class: OverallAccount, which
  sums the balances of a list of Accounts.

- Duplication, Duplication, Duplication!

- What if both Transaction and Account implement the same interface?

```java
interface Holding {
  Money balance();
}
```

- Transaction can easily implement Holding

```java
Money balance() {
  return value;
}
```


```java
// Account
Holding holdings[];      // now we can hold either Transactions or Accounts

Money balance() {
   Money sum= Money.zero();
   for (int i= 0; i < holdings.length; i++)
      sum= sum.plus(holdings[i].balance());
   return sum;
}
```

* May not be so obvious, but the positive side can be heavier.

- Folders contains Folders, TestSuites contains TestSuites, Drawings contains Drawings
