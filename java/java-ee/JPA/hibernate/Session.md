# Session

- Session objects are not hread-safe

- Session is a gateway to our database

- Session's job to take care of all db operations such as saving, loading,
  retrieving records from relevant tables

```java
Session session = factory.getCurrentSession();

Transaction tx = null;

try {
 tx = session.getTransaction();  
 tx.begin;
 // do db operation
 tx.commit();
} catch(HibernateException he) {
   if (tx != null) {
      tx.rollback();
      throw he;
   }
} finally {
   session.close();
}
```

