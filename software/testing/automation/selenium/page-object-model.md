# page object model

- create separate object repository to store object locators

- for each web page there should be a separate page class

- the page class will have all object locators and preferably action methods for
  the corresponding page

- Test Objects and Functions are separated for easy maintenance and keeping the code clean

- objects are kept separated from test scripts and can be used multiple times in multiple tests

- every unique object locator is created only once

- easy maintaince and less rework
