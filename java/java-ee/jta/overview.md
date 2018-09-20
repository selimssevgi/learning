# Programmatic Transactions with JTA

- In a Java SE environment, you call the JDBC API to mark trx boundaries. You
  begin a trx with setAutoCommit(false) on a JDBC Connection and end it by
  calling commit(), or force an immediate rollback with rollback()

- In an application that manipulates data in several systems, a particular unit
  of work involves access to more than one transactional resource. In this case,
  you can't achieve atomicity with JDBC alone

- JTA standardizes system trx management and distributed transactions so you
  won't have to worry much about the lower-level details

- The main API in JTA is the UserTransaction interface with methods to begin()
  and commint() a system transaction.

- JTA provides a nice abstraction of the underlying resource's trx system, with
  added bonus of distributed system transactions.

- High-quality standalone JTA providers such as Bitronix and Atomikos are
  available and easy to instanll in any Java environment(JTA is not just for EE)

- Think of these JTA solution as JTA-enabled database connection pools

- You should use JTA whenever you can and avoid proprietary trx API such as
  org.hibernate.Transaction or the very limited
  javax.persistence.EntityTransaction. These APIs were created at a time when
  JTA wasn't readily available outside of EJB runtime containers

- JTA is part of the Java EE specification, a Java EE server has to support it
