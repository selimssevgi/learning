# Application Controller

- MVC (input Controller)

- A lot of user-interface designs separate the presentation objects from the
  domain objects with an intermediate layer of Application Controller.

- The purpose of an Application Controller is to handle the flow of an
  application, deciding which screens should appear in which order.

- It may appear as part of the presentation layer, or you can think of it as a
  separate layer that mediates between the presentation and domain layers.

- They're usefuly if your system has a lot of logic about the order of screens
  and the navigation between them.

- If someone can pretty much see any screen in any order, you'll probably have
  little need for an Application Controller.

- If the machine is in control of the screen flow, you need an Application Controller

- If the user is in control, you do not need an Application Controller
