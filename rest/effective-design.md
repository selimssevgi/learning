# Effective Design of Restful APIs

- Items Resorce

activity          | verb/noun mapping
--------------------------------------------------------
list items        | GET /items
view items        | GET /items/:id
search for items  | GET /items?search=param
add items         | POST /items/
edit items        | PUT /items/:id

- carts Resorce

activity          | verb/noun mapping
--------------------------------------------------------
add item          | POST /carts/:id/items/:item_id
remove items      | DETELE /carts/:id/items/:item_id
clear cart        | DELETE /carts/:id
view cart         | GET /carts/:id
checkout          | POST /carts/:id/checkout

### designing relationships (3 types)

1. independent: the resource may exists regardless of the other existing, but they may reference each other

2. dependent: one resource can not exists without the parent

3. associative: they are independent but the relationship contains additional
   properties to describe it

* questions to define relationships

- can the resource exist without one another?

- does one resource only exist when the other exists?

- does the relationship between resources require more information than just the
  links between them?


```shell
/movies/:id
/movies/:id/actors
/movies/:id/characters/:id
/actors/:id
actors/:id/movies/:id
actors/:id/characters/
actors/:id/characters/:id
```
