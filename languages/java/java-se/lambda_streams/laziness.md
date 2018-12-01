
# Applicative Order vs Normal Order

Applicative order is calling methods in order. The way java does.

Normal order is calling methods that are needed to called. The way Haskell does.


## Lazy Evaluation

- Not calling until it has show some side effect.
- Functional languages have pure functions(without side effects), so they can be
  lazy. Programmers will not know if they called each function or not. They can
  skip doing some work if doesnt change the side effect being asked for.

- Lazy evaluation and pure function go in hands.

- Final report on 1 April. Then i will do it the day before. Nobody knows when i
  did it.

- Final report on 1 April. But each week progress report(side effect). Then i
  have to show the progress, i cannot postpone it until 1 april.

- In Scala we can mark an variable/value lazy with the keyword "lazy".

- In Java we can have laziness with lambdas.
