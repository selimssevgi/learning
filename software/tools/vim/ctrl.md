# Behaviors of Keys with CTRL
* get help(default normal mode) for each combination :help CTRL-A
- :help i_CTRL-H (help for insert mode)
- no need to hold shift key, a or A are same.

## Normal Mode
- C^A -> add one to the number under the cursor
- C^B -> move one page backward at a time
- C^C -> change mode. acts like <ESC>
- C^D -> scroll half of the window Down
- C^E -> scroll the window one line down
- C^F -> move one page forward at a time
- C^G -> show your location in the file and the file status at the bottom
- C^H ->
- C^I -> go forward location in the file, opposite of C^O
- C^J -> |:help| means a hyperling, between the bars, ctrl+j jumps you to indicated subject.
- C^K -> 
- C^L ->
- C^M ->
- C^N -> completion of the word being typed
- C^O -> go back where u came from, opposite of C^I
- C^P -> prev auto-complete list
- C^Q ->
- C^R -> undo the undo
- C^S ->
- C^T -> after ctrl-j jumpes, you can go back by ctrl-t, pop tag
- C^U -> scroll half of the window Up
- C^V -> visual selection blockwise
- C^W -> double, ctrl-w ctrl-w jumps between windows.
- C^X -> subsract one from the number under the cursor, opposite of C^A
- C^Y -> scroll the window one line up
- C^Z -> suspend the vim

## Insert Mode

- C^A -> 
- C^B -> 
- C^C -> Exit insert mode
- C^D -> Delete the current line (custom)
- C^E -> 
- C^F -> 
- C^G -> 
- C^H -> Delete back one character (backspace)
- C^I -> same as pressing TAB key
- C^J -> 
- C^K -> insert digraph C^K{char1}{char2}, :h digraph-table
- C^L ->
- C^M -> same as pressing enter
- C^N -> Trigger generic word autocompletion starting from top of the list
- C^O -> Switch to Insert Normal Mode
- C^P -> Trigger generic word autocompletion starting from bottom of the list
- C^Q ->
- C^R -> Paste the content of a register, C^r0, C^rc, C^r=
- C^S ->
- C^T -> 
- C^U -> Delete back to start of line
- C^V -> insert a character by its code, C^V{code}, find a code on letter: ga
- C^W -> Delete back one word
- C^X -> prefix of variant forms of autocompletion C^xC^o
- C^Y -> 
- C^Z -> 

- C^[ -> Switch to Normal Mode, like ESC
- C^6 -> Switch to alternate buffer

## Ex Mode

- C^A -> 
- C^B -> 
- C^C -> exit Ex mode
- C^D -> tab completion
- C^E -> 
- C^F -> go to into commandline window while in ex mode
- C^G -> 
- C^H -> Delete back one character (backspace)
- C^I -> 
- C^J -> 
- C^K -> insert digraph C^K{char1}{char2}, :h digraph-table
- C^L ->
- C^M -> same as pressing enter
- C^N -> next command in the history: down arrow
- C^O -> 
- C^P -> previous command in the history: up arrow
- C^Q ->
- C^R -> Paste the content of a register, C^r0, C^rc, C^r=
- C^S ->
- C^T -> 
- C^U -> Delete back to start of line
- C^V -> insert a character by its code, C^V{code}, find a code on letter: ga
- C^W -> 
- C^X -> Delete back one word
- C^Y -> 
- C^Z -> 
