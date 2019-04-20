# ch21 - i am changing the same code all over the place

- removing duplication doesnt have to be a grand effort such as in reengineering or re-archtecting

* when two methods look roughly the same, extract the differences to other
  methods. when you do that, you can often make them exactly the same and get rif of one.


- find duplication between similar class, move repeat part to a super class
  - LoginCommand
  - AddEmployeeCommand
  - Command

- orthogonality is a fancy word for independece.
- if you want to change existing behavior in your code and there is exactly one
  place you have to go to make that change, you have got orthogonality.


- duplication removal is a powerful way of distilling a design.
