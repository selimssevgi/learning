# JPQL

- instead of table and column names, JPQL relies on entity class and property names

- Except for entity class and property names, JPQL is case-insensitive

- A significant disadvantage of JPQL surfaces as problems during refactoring of the domain model

- You can make query construction with CriteriaBuilder and CriteriaQuery APIs
  completely type-safe.

## JPQL vs HQL

- The differences between JPQL and HQL are insignificant

- (For Hibernate) Same engine parses both JPQL and HQL query internally

- HQL supports some special constructs that aren't standardizd in JPA
