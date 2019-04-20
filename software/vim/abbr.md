# Abbreviations in Vim

## Just works in that session
- :abbreviate ad advertisement
- :ab         ad advertisement

## Add them into vimrc to use them for longer time

```vim
abbr rtfm read the fine manual
abbr #b /****************************************
abbr #e <space>****************************************/
```

## List your abbreviations
- :abbreviate -> list your abbreviations
- :ab         -> list your abbreviations

### How to make them work
* Abbreviation is expanded after space,tab or other whitespace

- If it seems to be not working after space or tab, use C^] for expansion.


