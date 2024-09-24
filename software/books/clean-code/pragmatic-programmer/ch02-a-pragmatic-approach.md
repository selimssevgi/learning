# ch02 - a pragmatic approach

## the evils of duplication

- knowledge isn't stable, it changes, often rapidly

- we spend a large part of our time in maintenance mode
  - reorganizing and reexpressing the knowledge in our systems

- DRY

```shell
every piece of knowledge must have a single, unambiguous, authoritative
representation within a system
```

### how does duplication arise?

* imposed duplication: developers feel they have no choice cus of env
  - multiple rep of information
  - documentation in code, comments
  - documentation and code

* inadvertent duplication: not aware of duplicating information

* impatient duplication:  lazy developers
  - "short cuts make for long delays"

* interdeveloper duplication: multiple people duplicate a piece of info

## orthogonality (modular, component-based, layered, AOP)

- a term borrowed from geometry

- two lines are orthogonal if they meet at right angles
  - two lines are independent
  - move along one of the lines, and your position projected onto the other does not change

- in computing: the term signify a kind of independence or decoupling

- helicopter controls are decidedly not orthogonal


### benefits of orthogonality

- when components of any system are highly interdependent, there is no such thing as a local fix

- cohesion

- gain productivity
  - M X N

- reduce risk


- project teams
  - responsibility overlaps -> lots of sync meetings

  - with AOP, you implement logging orthogonallly to the things being logged


  - with DRY, you minimize the duplication within a system, whereas with
    orthogonality you reduce the interdependency among the system's components


- gui vs cli, which one is more orthogonal?
- c++ multi-inheritance, java multiple- interfaces
- degelation vs inheritance?
- Split(InputStreamReader) vs Split(String line)?
- procedural vs oop vs fp?

### reversibility

- nothing is forever, and if you rely heavily on some fact, you can almost guarantee that it will change

- the problem is that critical decisions aren't easily reversible

- vendor database? architectural pattern? a certain deployment model?

- using DRY, decoupling and use of metadata is a good thing, we dont have to
  make as many critical, irreversible decisions. is a good thing, cus we dont
  always make the best decisions the first time around


- requirements, users, and hardware change faster than we can get the software developed

- instead of carving decisions in stone, think of them more as being written in the sand at the beach

- if smth is added automatically, it can be taken out automatically as well


### tracer bullets

- it applies to new projects, particularly when you are building smth that hasnt been built before

- you are trying to hit a target in the dark

- cus your users have never seen a system like this before, their requirements may be vague
  - unfimiliar algorithms, techniques, languages, libraries

- you can pretty much guarantee the environment you are working in will change before you are done

- tracer bullets work because they operate in the same environment and under
  same constraints as the real bullets

* the tracer code approach has many advantages:
  - users get to see smth working early
  - developers build a structure to work in
  - you have an integration platform
  - you have smth to demonstrate
  - you have a better feel for progress


- tracer bullets show what you are hitting. this is may not always be the target
- you then adjust your aim until they are on target. that is the point


* tracer code vs prototyping (prototyping is activity before tracer bullet is fired)
  - prototype: aim to explore specific aspects of the final system
  - prototype: generates disposable code
  - prototype: you throw it away, recode properly
  - tracer: need to know how the app as a whole hangs together
  - tracer: code is lean but complete
  - tracer: give user the interaction, give developers an architectural skeleton


## prototypes and post-it notes

- we tend to think of prototypes as code-based but they dont always have to be

- post-it notes are great for prototyping dynamic things such as workflow and application logic

- prototyping is a learning experience

- its value lies not in the code produced, but in the lessons learned

- some specific areas you may want to look for the architectural prototype:
  - are the responsibilities of the major components well defined and appropriate?
  - are the collaborations between major components well defined?
  - is coupling minimized?
  - can you identify potentiel sources of duplication?
  - are interface definitions and constraints acceptable?
  - does every module have an access path to the data it needs during execution?
    does it have that access when it needs it?

## domain languages

## estimating

- in the process of producing an estimate, you will come to understand more
  about the world your programs inhabit

- do they need high accuracy, or are they looking for a ballpark figure?

- what is the value of PI? for flower bed? for school? for NASA?

- help other understand that the team, their productivity, and the environment
  will determine the schedule
