# Values

- Values can be numbers, strings, vectors, maps, sets or other things
- Once created, Clojure values cannot be altered
- They are immutable
- Imperative model of a box that has contents that change is not the way Clojure works
- Binding means creating an association between a name and a value


```clojure
(def hello (fn [] "Hello World"))
```

- (def) always binds identifiers(symbols) to values
- A function takes no arguments and returns a string
- Call it as (hello)

- The binding of a symbol to a value can be changed by another call to 'def'
- The ability to change which value a symbol is bound to is alternative to mutating state

- Mutating means changing the content of the box
- Rebinding means repointing to another box
