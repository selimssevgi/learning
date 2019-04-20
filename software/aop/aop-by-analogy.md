# AOP by analogy

## CSS

- Without CSS, formatting information is fused with content (causing tangling)

- Similar content elements have presentational information spread into multiple
  places (causing scattering)

- CSS helps the situation by letting the main document focus on content by
  separating the formatting information into a document called a 'stylesheet'.

- A core concept in CSS is a 'selector' that selects document elements matching
  a certain specification. AOP's pointcuts have the same selection role as CSS
  selectors.

- Similarly, the blocks describing the formatting information are analogous to
  AOP advice in functionality.

- Often, the selection mechanism requires more information than merely using the
  inherent characteristics of a structure such as 'body p'. It is common
  practice to supplement content elements with additional metadata through the
  'class' attribute.

- In AOP, practitioners face the same problem -- selection through a pointcut
  often requires information beyond merely relying on inherent characteristics
  of the program elements such as class and method names. The use of Java
  annotations plays a role similar to the class attribute in HTML documents. You
  can mark a method as @Transactional and utilize it in a pointcut expression.

## Database systems

- It offers two good analogies to AOP concepts: SQL with pointcuts and triggers
  with advice.

### SQL and Pointcuts

- A join point is like a row in a database, whereas a pointcut is like an SQL query.

- An SQL query selects rows according to a specified criterion, it provides
  access to the content of the selected rows.

- Similarly, a pointcut is a query over program execution that selects join
  points according to a specified criterion, it also provides access to the join
  point context.

### Triggers and Advice

- Database programming often uses triggers to respond to changes made in data.

- The stored procedure specified in the trigger is analogous to AOP's advice.

## Event-oriented programming
