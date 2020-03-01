# angular module

- a class with a NgModule decorator

- its purpose:
  - organize the pieces of our application
  - arrange them into blocks
  - extend our application with capabilities from external libraries
  - provide a template resolution environment
  - aggregate and re-export


- module declares component, directive, pipe
- module bootstraps components
- module exports other modules
- module imports other modules
- module provides services


## bootstrap array

* every application must bootsrapt at least one component, the root app component

* should be only used in the root application module, AppModule

## declarations array

- every component, directive, and pipe we create must belong to one and only one
  Angular Module

- only declare components, directives, and pipes

- never re-declare components, directives, or pipes that belong to another module

- all declared components, directives, pipes are private by default
  - only accessible to other c/d/p declared in the same module
