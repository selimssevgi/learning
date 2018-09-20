# Intoducing Restbucks

- Restbucks has actors such as customers, cashiers, baristas, managers, and
  suppliers who must interact to keep the coffee flowing.

- Classic problems:

* Notification
* Handling communication failures
* Transactions
* Scalability

- Barista can be responsible for taking orders, payments, and preparing coffees.
- In case of a lot of customers, this approach could fail.

- Introducing cashier, who will be responsible for taking order and payment.
- Now Barista can be only responsible for preparing orders.
- This approach decouples ordering and payment from the coffee preparation.

- Decoupled parts can be improved, optimized indivicually.
