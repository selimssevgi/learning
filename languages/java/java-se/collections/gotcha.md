

```java
for (Product product : products) {
  if (canRemove(product)) 
    products.remove(product); // RE: ConcurrentModificationException
  else
    sout(product);
}

// Use iterator if you are gonna modify the collection
```

```java
Iterator<Product> it = products.iterator();
while (it.hasNext()) {
    if (canRemove(product)) 
      product.remove();
    else
      sout(product);
}
```

```java
public final static Comparator<Product> BY_WEIGHT =
  comparing(Product::getWeight);

products.sort(BY_WEIGHT);
```
