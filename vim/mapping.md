# Mapping in Vim
Mapping enables you to bind a set of Vim commands to a single key.

## Example
```vim
:map <F5> i{<Esc>ea}<Esc>
```

- F5 is the trigger key, causes the command to be executed.
- i{ goes insert mode and types {
- Esc leaves insert mode
- e moves to the end of the word
- a goes insert mode and appends }
- Esc leaves insert mode

#### List of Mappings
:map lists all the mappings.


:mkvimrc file
