# ch14 - dependencies on libraries are killing me

- avoid littering direct calls to library classes in your code. you might think
  that you will never change them, but that can become a self-fulfilling prohpechy

* library designers who use language features to enforce design constraints are
  often making a mistake. They forget that good code runs in production and test
  environments. Constraints for the former can make working in the latter nearly impossible

* sometimes usinga coding convention is just as good as using a restrictive
  language feature. Think about what your tests need.
