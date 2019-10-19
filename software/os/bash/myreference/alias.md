# Alias

- The shell maintains a list of aliases that may be set and unset with the alias
  and unalias built-in commands.

```java
alias # to see the aliases in current shell
```

* define your alias in ~/.bash_aliases

```shell
alias la='l -a' # create an alias

unalias la      # remove an alias
```

- Aliases are not inherited by child processes.
- Bourne shell (sh) does not recognize aliases.

- Functions are faster
- Aliases are looked up after functions and thus resolving is slower
- While aliases are easier to understand, shell functions are preferred over
  aliases for almost every purpose.
