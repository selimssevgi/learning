# Vimscript

## Echo

- echom messages will be stored in :messages for later, useful for debugging

```vimscript
:echo "Hello Vimscript!"

:echom "Hello again!"

:messages

:help echo
```

## Comment

- Comment lines start with double quote, "


## Setting Options

- Two kinds of options:
  1. Boolean: "on" and "off"
  2. Value

```vimscript
:set number
:set nonumber

:set number!           " Toggle
:set number?           " ask what an option is

:set numberwidth=4
:set numberwidth?
```

## Mapping

- be more specific about when you want mappings to apply:
  - imap: insert mode
  - vmap: visual mode
  - nmap: normal mode
  - map: may work in normal and also visual mode

```vimsciprt
:map - x                 " normal mode, now - is exactly like x
:map - dd                " now - removes one line

:map <space> viw         " space selects a word
:map <c-d> dd            " C^D  removes one line

:imap <c-d> dd           " insert mode: C^D insert 'dd' in file, not delete
:imap <c-d> <ESC>ddi      " leave insert mode, dd removes the line, then imode
```

### Strict Mapping

- map, imap, vmap, nmap are usefult, but have a downside

```vimscript
:nmap - dd
:nmap \ -
```

- Pressing \ in normal mode is mapped to -, and that is map to dd
- When mapping with these commands, Vim will take other mappings into account
- This is pure evi.

- remove mappings: unmap

```java
:nunmap -
:nunmap \
```

### Recursion

```vimscript
:nmap dd o<esc>jddk        " C^C to get vim back from infinity
:nunmap dd
```

- \*map commands have danger of recursion
- there is chance that you may change some mappings that plugins are depend on

### Nonrecursive Mapping

- Another set of mapping commands that will 'not' take mappings into account
- noremap, nnoremap, vnoremap, inoremap

```vimscript
:nmap x dd
:nnoremap \ x                " this wont use above mapping
```

**NOTE:** Always use nonrecursive mapping in order not to have problems in the
future with plugins and other things.

## Leaders

- ':nonoremap <space> dd' overrides what <space> normally does
- There are only a few that are not needed in daily usage
- are they enough to create our own safe mappings?

- mapping key sequence

```vimscript
nnoremap -d dd
nnoremap -c ddO                         " mapping '-c'
```

- In this way we can pick a prefix key and create mappings on top it
- Vim already has such mechanism
- Vim calls this 'prefix' key the leader

```vimscript
let mapleader = ","
nnoremap <leader>d dd
```

- Defining a mapleader once, make it easy to change later to something else
- People can copy mappings, it would work for their leader key
- Many plugins create mappings that start with leader key

### Local Leader

- let maplocalleader = "\\"

## Learning the Map

- You got a new great mapping, how to learn it?
- To rewrite the muscle memory, disable the one you are used to

```vimscript
inoremap jk <esc>
inoremap <esc> <nop>
```

## Operator-Pending Mappings

Keys    | Operator     | Movement
--------|--------------|----------
dw      | Delete       | to next word
ci(     | Change       | inside parens
yt,     | Yank         | until comma


```vimscript
onoremap p i(

" dp would delete inside parens, cp change parameters
return person.get_pets(type="cat", fluffy_only=True)

" db : delete the entire body
onoremap b /return<cr>

print foo()
```
