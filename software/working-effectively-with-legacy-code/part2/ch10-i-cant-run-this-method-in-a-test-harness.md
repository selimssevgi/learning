# ch10 - I cant run this method in a test harness

- here are some of the problems that we can run into:

1. the method might not be accessible to the test. It could be private or have
   some other accessibility problem.

2. it might be hard to call the method because it is hard to construct the
   parameters we need to call it

3. the method might have bad side effects (modifying a db, launching a cruise
   missile, and so on), so it is possible to run in a test harness

4. we might need to sense through some object that the method uses

### the case of the hidden method

- we need to make a change to a method in a class, but it is a private method?

- if that is a public method reaching to private one, we can test through the public method

- if we need to test a private method, we should make it public

- if making it public bothers us, in most cases, it means that our class is
  doing too much and we ought to fix it

- here is some reasons why making a private method public would bother us:

1. the method is just a utility; it isn't smth clients would care about
  - there might be just another public method on the class

2. if client use the method, they could adversely affect results from other methods on the class
  - we can move such methods into another class, and have an instance of that

### the case of the 'helpful' language feature

- there might be times the the parameter class has no constructor that we can access and it is final

- 'final' in Java prevents us to subclass, that could be problematic specially
  in cases where such classes comes from libraries

- we can write wrappers for such classes to make our class testable

### the case of the undetectable side effect

```java
public void actionPerformed(ActionEvent event) {
  // does lots of this, calling on external objects
  // performs operation on GUI
}
```

- we can call this method in a test, but cannot assert the result

- we can separate parts that does business logic and work on GUI

- after such separation, we could subclass and override gui logic to do nothing

- Command/Query Separation: query does not have side effects

- even at this point, we could move different responsibilities to different classes
