# Notes on Exceptions in Java

* Parent class is Throwable.

* Throwable has two direct subclasses : Error, Exception.
  - Error: Never suppose to happen, you do not catch them.
  - Exception: Doesnot have any methods of own itself. 
               Inherets all the methods from Throwable.


* RuntimeException : unchecked exception, does not require try-catch.
