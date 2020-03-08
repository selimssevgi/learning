# class loaders in jee

- parent-first

- jee spec doesn't provide implementation standards for ee server class loaders

- AS class loader loads all of the jars in the AS's /lib directory
- these are the all the libraries the AS is requeired to provide, such as jee api itself

- ear module CL is extended from the AS CL
  - loads classes at an ear level
  - by default, they are jars in /lib of the ear

- ejb CL is extended from the ear module
- there's typically only a single ejb CL that loads all the ejb-jar modules

- war CL is extended from the EJB CL
- by extending ejb CL, the war gains access to all ejbs
- each war will get its own class loader
