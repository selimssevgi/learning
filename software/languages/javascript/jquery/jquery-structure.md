# How jQuery is structured

- github/jquery/jquery

- using technologies:
  - nodejs - a platform built on Chrome's JS runtime
  - npm    - the offical package manager for nodejs
  - grunt  - a task runner to automate common and repetitive tasks

- jQuery's source code follows the asynchronous module definition (AMD) format

- AMD format is a proposal for defining modules where both module and its
  dependencies can be asynchronously loaded

- Using AMD means that although jQuery being used as a unique, single block; its
  source is split into several files (modules)

- Using RequireJS for managing dependencies

## Some Modules

- ajax
  - all ajax function like ajax(), get(), and post()

- deprecated
  - all currently deprecated methods that havent been removed

- effects
  - the methods that allow animations like animate() and slideUp()

- event
  - the methods to attach event handlers to browser events like on() and off()


* Modularization leads to another advantage: the possibility of custom jQuery builds
