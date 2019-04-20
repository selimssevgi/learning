# Practical Vim


## Factory Settings

- u option: use vimrc file for initialization
- N option: no-compatible mode

```shell
vim -u NONE -N

vim -u any-vim-source-file
```

## Vim versions


```vimscript
" compilation of vim: --with-features=tiny|small|normal|big|huge
:h +feature-list
:version " tells you at the top which feature set
```

## Chapter 1 - The Vim Way

### Tip 1 - Meet the Dot Command

- The dot command lets us repeat the last change
- It is the most powerful and versatile command in Vim

### Tip 2 - Don't Repeat Yourself

- two for price of one
- reduce extranous movement

Compound Command | Equivalent in Longhand
-----------------|-----------------------
C                |c$
s                |cl
S                |^C
I                |^l
A                |$a
o                |A<CR>
O                |ko


```shell
var foo = 1
var bar = 'a'
var foobar = foo + bar
// to
var foo = 1;
var bar = 'a';
var foobar = foo + bar;
```

### Tip 3 - Take One Step Back Then Tree Step Forward

- make the change repeatable

- ; command repeats the last search that the f command performand
- , reverse the ; if we skipped one of the results too fast


```shell
var foo = "method("+argument1+","+argument2+")";)"
// turn into
var foo = "method(" + argument1 + "," + argument2 + ")"
```

### Tip 4 - Act, Repeat, Reverse

- @: can be used to repeat any Ex command
- , reverse the ; if we skipped one of the results too fast
- u to reverse an edit
- N to reverse search

### Tip 5 - Find and Replace by Hand

- :%s/content/copy/g
- * searches the word under the cursor
- cwcopy<esc>
- n for next, N for previous match

```shell
// replace content with copy
...We're waiting for content before the site can go live...
...If you are content with this, let's go ahead with it...
...We'll launch as soon as we have the content...
```

### Tip 6 - Meet the Dot Formula

- one keystroke to move, one keystroke to execute
- j.
- n.
- ;.

### Tip 9 - Compose Repetable Changes

- daw : delete around word, also white space around it
- diw

```shell
the end is
```

### Tip 10 - Use Counts to do Simple Arithmetic

- c-a for adding one
- c-x for substracting one
- {count} c-a or c-x
- finds the first digit on the line and operates on it

```shell
.blog, .news { background-image: url(/sprite.png); }
.blog { background-position: 0px 0px }
// to this
.news { background-position: -180px 0px }


007 # c-a turns it into 010, vim interprets number with leading zero as octal
set nrformat=        # treats all numbers decimal
```

### Tip 12 - Combine and Conquer

- operator + motion = action

- daw
- gUaw

- when an operator command is invoked in duplicate, it acts opun current line
- dd, cc, yy, gUU, >>

- commentary plugin, //{motion}, //ap

## Chapter - Insert Mode

### Tip 13 - Make correction instantly from Insert Mode

- C^h Delete back one character (backspace)
- C^w Delete back one word
- C^u Delete back to start of line

- this can also be used bash script

### Tip 14 - Get back to Normal

- ESC Switch to Normal Mode
- C^[ Switch to Normal Mode
- C^o Switch to Insert Normal Mode

- C^o>zz redraw the screen with the current line in the middle of the window

### Tip 15 - Paste from a Register without leaving insert mode

- C^r0 paste the text on register 0

### Tip 16 - Do back-of-the-Envelope calculations in place

- C^r= expression register

### Tip 17 - Insert unusual characters by Character Code

- C^v{code} insert any arbitrary character

### Tip 18 - Insert unusual characters by Digraph

- C^K{char1}{char2}
- C^K?I
- :h digraph-table

### Tip 19 - Overwrite existing text with Replace Mode

- R - replace me
- r - one shot replace
- gR - virtual replace - solving problems with overwriting tab spaces
- gr - one shot virtual space

## Chapter 4 - Visual Mode

### Tip 20 - Grok Visual Mode

- in textarea, select word, starting write deletes the word and insert new
- in visual mode it doesnt work that way, use c to delete and go to insert mode
- select mode works how it is in other editor
- select mode is usual in code snippets highlighting

### Tip 21 - Define a Visual Selection

- v character-wise
- V line-wise
- C^V block-wise
- gv reselect the last visual selection
- o go to other end of highlighted text
- o command is usual when changing the boundry of selection
- go on b of boundry, bbow to see what it does

## Chapter 5 - Command-Line Mode

### Tip 27 - Meet Vim's Command Line

- press : to switch command line mode
- commands called Ex commands
- :h ex-cmd-index
- can use some of same commonds from Insert Mode, c^h, c^w, c^u, c^r

- insert mode acts on current character or current line
- ex commands strike far and wide

### Tip 28 - Execute a command on one or more consecutive lines

- [number] , line number
- [range]  , 2,5  :{start},{end}  , inclusive
- :1 move to line 1
- :$ move to the end of file
- :print, :p

- :3p go to line 3 and print it
- :3d go to line 3 and delete it, 3Gdd

- :2,5p
- we can use other things as address other than numbers
- . represent the current line as an address
- :.,$p

- % represents all the lines in the current file
- :%p
- :1,$p

- :%s/Practical/Pragmatic/

- visually select some line and press :

- :{address} + offset
- :.,.+3p             // 2,5

### Tip 29 - Duplicate or move lines using ':t' and ':m' commands

- :t copy or duplicate
- :m move

- :[range]copy{address}
- :6copy.

### Tip 30 - Run normal mode commands across a range

- :normal
- :%normal i//        # comment out all lines
- :%normal A,         # end all lines with ,

### Tip 31 - Repeat the last ex command

- . repeats last command in insert mode
- @: repeats last ex command
- : is a register
- @: after first time we can use @@

### Tip 32 - Tab-complete your ex commands

- :col<c-d> shows all possible options
- TAB key will cycle through the option
- s-TAB to reverse back
- :colorscheme C^d

- set wildmenu
- set wildmode=full "zsh tab completion


### Tip 33 - insert the current word at the command prompt

- c^r c^w 

### Tip 34 - Recall commands from history

- set history=200 " save history of last 200 ex commands
- up and down arrow to scroll history
- c^p and c^n to scroll history

- :write | !ruby %

- q: command line window
- use it as a normal buffer
- press enter to execute current line as ex command

- go into commandline window while in ex mode: c^f
- q/ open commandline window with history of searches

### Tip 35 - Run commands in the shell

- :!ls
- :!ruby %

- :shell works as c^z to get a shell fg to get into vim again

- :read !ls
- :write! ls , overwrite ls file
- select some text and ! to filter

# Part II - Files

## Chapter 6 - Manage Multiple Files

### Tip 36 - Track open files with the buffer list

- we are editing an in-memory representation of a file, a buffer
- files are stored on the disk, whereas buffers exist in memory

- $ vim *.txt
- :ls
- :bnext, :bprev, :bfirst, :blast
- :buffer N

- :bdelete N1 N2 N3
- :N,Mbd

### Tip 37 - Group buffers into a collection with the argument list

- :args lists the arguments given to vim on startup: vim *.txt

- set the contents of the arguments
- :args {argslist}
- args index.html app.js

- ** same as * but it can recurse downward into dires below specified dir

- globs: args *.*, args **/*.js, args **/*.*
- :cat `cats file.txt`

### Tip 38 - Manage hidden files
### Tip 39 - Divide your workspace into split windows

- a window is a viewport onto a buffer
- can open multiple windows and load different buffers into them

- c^w s  divide this window horizontally
- c^w v  splity this window vertically
- c^w q  quit the window
- c^w w  cycle between open windows
- c^w h  focus window to the left
- c^w l  focus window to the right
- c^w k  focus window above
- c^w j  focus window below

- c^w c  close the active window, :close
- c^w o  keep only the active window, close all others, :only

- c^w = equalize h and w of all windows
- c^w _ max the height of the active windows
- c^w | max the width of the active windows
- [N]c^w _ set the height to N rows

- they all work when ctrl is pressed for both keys
- map them to tmux mapping!?

- could be usefult to have same buffer in different windows to see dif part of it

- c^w s and then :edit {filename} to load a dif buffer
- combine above steps into one :split {filename}
- :vsplit {filename}

### Tip 40 - Organize your window layouts with the Tab pages

## Chapter 7 - Open files and save them to disk


### Tip 41 - Open a file by using its filepath using ':edit'

- :edit {filepath}
- :pwd
- :edit {filepathrelativeto$PWD}

- :edit %<tab>          # expands to the filepath of the active buffer
- :edit %:h<tab>        # removes the filename, leaves just the path

### Tip 42 - Open a file by its filename using ':find'

- in a project with nested directory, it is tedious to provide fullpath to :edit
- :find Main.js
- :set path+=app/**

### Tip 43 - Explore the file system with netrw

- netrw plugin is in the Vim distributtion
- network read and write

### Tip 44 - Save files to nonexisting directories

- :!mkdir -p %:h

### Tip 45 - Save a file as the super user

- :w !sudo tee % > /dev/null

## Part III - Getting around faster

## Chapter 7 - Navigate inside files with motions

- :h motion.txt

### Tip 46 - Keep your fingers on the Home Row

### Tip 47 - Distingueish between real lines and display lines

- j operate on real lines
- gj operate on display lines

### Tip 48 - Move word-wise

- ge backward to end of previous word

- WORD consists of a seq of nonblank chars separated with whitespace
- WORDs are bigger than words

- word: w,b,e,ge
- WORD: W,B,E,gE

### Tip 49 - Find by character

- f{char} forward onto
- F{char} backward onto
- t{char} forward before
- T{char} backward before
- ; to repeat
- , to back up

- target rare used letters, punctuation marks, capital letters

### Tip 50 - Search to navigate

- f and t commands operate on current line
- use search / functionality for bigger jumps
- d/get

### Tip 51 - Trace your selection with precision text objects

- text objects define regions of text by structure

- vi}, a", i>, it, at, a[, 

- text objects consist of two characters, the first of which is always either i or a
- i : select inside the delimiters
- a : select evertything including delimiters, around

- i) and )i are same

- a) or ab  : a pair of parentheses
- i) or ib  : inside of parents
- a} or aB  : {around}
- a]        : a pair of []
- i]        : 
- a>, i>
- a', i'
- a", i"
- at, it

- text objects are motions themselves, cannot be used to navigate
- can use text objects in Visual mode and in Operator-Pending mode
- d{motion}, y{motion} etc

### Tip 52 - Delete around or change inside

- text objects fall into two categories
  - those that interact with pairs of delimitirs, such as i), i", it
  - those that interact with chunks of text, words, sentences, parags

- iw, aw
- iW, aW
- is, as
- ip, ap
- they can be used with d,c,y

### Tip 53 - Mark your place and snap back to it

- m{a-zA-Z} marks the current cursor location
- lowercase marks are local to each individual buffer
- uppercase marks are globally accessible
- '{mark} and `{mark} for jumping to a mark
- mm and 'm

### Tip 54 - jump between matching parentheses

- %
- surround.vim
- visual selection, S", sorround selection in "
- S}, S]
- cs{[, change surrounding {} to []

## Chapter 9 - Navigate between files with jumps

### Tip 55 - Traverse the jump list

- c^o and c^i
- motion move around within a file, whereas jumps can move between files
- :jumps, :ju

- [count]G is not a jump
- j and k are not jumps
- character and word wise motions are not jumps

- sentence and parags wise motions are jumps
- long-range motions may be classified as jumps

- each separate window has its own jumps list

### Tip 56 - Traverse the change list

- u<c^r> - undo redo hack to get to location for the last change

- vim maintains a list of the modifications we make to buffer
- :h chagelist
- :changes

- g; and g, move between most recent modification
- gi to carry on where you left off

- jumplist for a window
- changelist for a buffer

### Tip 57 - Jump to the filename under the cursor

- gf to jump into a file
- vim wouldnt be able to find files even in current dir
- specify a file extension to help vim to find files
- :set suffixesadd+=.rb
- gf add a jump to our list, use c^o to get back

- :set path?
- . directory of current file
- empty string for cwd

### Tip 58 - snap between files using global marks

- m{capitalletter}
- go into vimrc file and mV to mark the file
- form another location 'V to get back vimrc file
- global marks are persisted between editing sessions (can be changed)

- global marks are also useful when there is possibility to go through quickfix list
- :vimgrep, :argsdo, :make

## Part IV - Registers

- are simply containers that hold text
- can be used in the manner of a clipboard for x,c,p text
- can be used to record a macro

### Chapter 10 - Copy and Paste

#### Tip 59 - Delete, yank and put with Vim's unnamed register

- xp swap two characters
- ddp move a line down
- yyp duplicate a line

- d command not just deleting but also copying into unnamed register
- d is like cut
- use blackhole register for normal delete
- " _ d , _ symbol is used for blachole register, which returns nothing

#### Tip 60 - Grok Vim's Registers

- vim provides multiple registers for x,c,p

- while using d, y, and p commands we can specify which register we want to interact

- "{register}
- "ayiw, "bdd, "bp, "ap

- :delete c, :put c are commands to cut into c register and the content of it

- if you dont specify which register you want to interact with, then vim will
  use the unnamed register, which is addressed by " smybol

- ""p is equivalent to p

- yank register "0
- y{motion} copies the text also into yank register
- x, s, c, d wont overwrite the content of the yank register

- yank register is reliable, whereas the unnamed register is volatile

- :reg "0

- named registers ("a-"z)

- when we address a named register with lowercase letter, it overwtes the
  specified register, whereas when we use an uppercase letter, it appends to the
  specified register

- system clipboard "+ and selection " * registers

- on X11 " * is primaryclipboard, used with middle mouse button

- expression register "=

- read only registers are implicitly set by vim
  - "% name of the current file
  - "# name of the alternate file
  - ". last inserted text
  - ": last ex command
  - "/ last search pattern

#### Tip 61 - Replace a visual selection with a register

#### Tip 62 - Paste from a register

- P and p

#### Tip 63 - Interact with system clipboard

- c-s-v can be used to paste from clipboard
- c-s-v will be used as we are inserting the text and vim will give a wierd looking output with identation
- either use this option in paste mode
- or use clipboard "+ register so vim will preserve the format

### Chapter 11 - Macros

#### Tip 64 - Recoard and Execute a Macro

- macros allow us to recrod a seq of changes and than play them back

- q key can be used both for record and stop button
- q{register} tells where to save the macro
- ':reg a' to inspect the content of register
- @{register} executes the content of specified register
- @@ to repeat the macro that was invoked most recently

- executing a macro in seris in brittle, like a cheap xmas tree lights
- executing a macro in parallel in more fault tolerant

- vim internally use sequential executin anyway, parallelism is used as analogy

#### Tip 65 - Normalize, Strike, Abort

- if a motion fails while a macro is executing, then vim aborts the rest of macro

- 10@@
- 1000@@ you dont have to count when it fails, it stops

#### Tip 66 - Play back with a count

- . dot command cannot numbered, ;.
- qq;.q
- using q register to record smth is easier
- 11@q

#### Tip 67 - Repeat a change on contiguous lines

- qa0f.r)w~jq
- @a
- @@

```shell
1. one
2. two
3. three
4. four
```

- the above macro wouldnt work on the followig line
- on third line it will fail to find dot and stop
- qa0f.r)w~q // no j at the end
- select all the lines visually Vj
- :normal @a // run the macro on line in parallel
- each macro execution is independent of each other
- if one fails, dont stop others from running

```shell
1. one
2. two
// break up the monotony
3. three
4. four
```

#### Tip 68 - Append commands to a macro

- if you forget a keystroke in our macro, u dont have re-record all again
- we can append more keystrokes
- qAjq
- this work only in a way to end smth at the end of the macro


#### Tip 69 - Act upon a collection of files

- we can run a macro on multiple buffers

#### Tip 70 - Evaluate an iterator to number items a list

- we can use c^a and c^x to decrement and increment values in macros

- :let i = 0
- :echo i
- :let i += 1
- we can also use expression register

- qa
- :let i = 1
- I<C^r>=i<CR>)<ESC>
- :let i += 1
- q

- :normal @a tells to execute macro on each selected line

#### Tip 71 - Edit the contents of a macro

- ^[ is a ESC in macro
- <80>kb is backspace in a macro

- the register we use are same registers put and yank interacts with

- paste the content of a register
- :put a
- "ap pastes the content of register a after cursor
- :put pastes the content below the current line whether it line-wise or word-wise
- make your changes
- cut into the register again, using "add or :d a may get extra characters
- yank or delete it character-wise instead of line-wise
- 0"ay$

## Part V - Patterns

### Chapter 12 - Matching Patterns and Literals

#### Tip 72 - Tune the case sensitivity of Search Patterns

- setting case sensitivity per search:
  - \c causes the search pattern to ignore case
  - \C forces case sensitivity

- these items can be used anywhere in a pattern, at the beg at the end

- 'smartcase' if all cases are lowercase it uses case insensitivity, if there is
  a one uppercase then the search becomes case sensitive

#### Tip 73 - Use the \v Pattern switch for regex searches

- vim regex is closer to POSIX than it is to Perl
- no to escape each special character

- instead use \v switch to make it behave similar to Python, Ruby, Perl
- /\v
- very magic search treats all characters as special, except _ , letters, numbers, #

```shell
/\v#([0-9a-fA-F]{6}|[0-9a-fA-F]{3})

/\v#(\x{6}|\x{3})
```

#### Tip 74 - Use the \V literal switch for verbatim searches

- verynomagic mode just backslashes have special meaning

```shell
/a.k.a.
// . matches any word
/a\.k\.a\.
// escapes special characters
/\Va.k.a.
```

- use \v for regex
- use \V for literal search

#### Tip 75 - Use parentheses to capture submatches

#### Tip 76 - Stake the boundaries of a word

- the appers in these, they, their
- /\v<the> matches just the word 'the' not other combinations

#### Tip 77 - Stake the boundaries of a match
#### Tip 78 - Escape Problem characters

- / and \ have special meaning for their literal usage they should be escaped

### Chapter 13 - Search

#### Tip 79 - Meet the search command

- / starts a search mode in normal mode

- / forward search
- ? backward search
- n next matchh
- N previous match

- /<CR> repeat last search
- ?<CR> baackward to previous match of same pattern

- browsing search history is same as ex mode, c^p, c^n etc

#### Tip 80 - Highlight search matches

- hlsearch
- nohls
- :nohlsearch mute it temporarily, gets actived in the next search

#### Tip 81 - Preview the first match before execution

- incremental search
- :incsearch
- show preview, esc takes you where you started, enter takes to match

#### Tip 82 - Count the matches for the current pattern

- :%s///gn
- :%s/word//gn
- second pattern is not important, not gonna be used
- careful with last / if you forget, it will use gn as replacement pattern

#### Tip 83 - Offset the cursor to the end of a search match

- /lang/e<CR> places the cursor at the end of the search

#### Tip 84 - Operate on a complete search match
#### Tip 85 - Create complex patterns by iterating upon search history

- q\ similar to q: commandline window

#### Tip 86 - Search for the current visual selection

### Chapter 14 - Substitution

#### Tip 87 - Meet the substitute command

- :substitute command is complex
- a search pattern, replacement string, the range, flags to tweak its behavior

- [range]s/{pattern}/{string}/{flags}

- :h :s_flags

- g globally, all matchnes in a line rather than just changing the first one
- c confirm or reject the substitution
- e error silencing
- & same flag from previous substitution command

#### Tip 88 - Find and replace every match in a file

- by default substitute command acts on the current line, changing first occurence only

```shell
When the going gets tough, the tough get going.
If you are going through hell, keep going.
```

- :s/going/rolling
- above command acts on x-axis and only for first match
- use g flag to cover all matches on the x-axis, globally within the current file
- :s/going/rolling/g

- :%s/going/rolling/g
- on every line of the file, all matches

#### Tip 89 - Eyeball each substitution

- look every match then confirm or reject the substitution
- :%s/content/copy/gc

#### Tip 90 - Reuse the last search pattern

- leaving the search field of the substitution command blank instructs Vim to
  reuse the most recent search pattern

- :%s/\n/,    replacing new lines with comma

#### Tip 91 - Replace with the contents of a register

- leaving the replacement string empty will delete all matches

- pass by value :%s//<C^r>0/g
- if the content of the register has some characters that should be escaped it
  would be a problem, instead use pass by reference

- pass by ref   :%s//\=@0/g

```shell
:%s/Pragramtic Vim/Practical Vim/g

:let @/='Pragmatic Vim'
:let @a='Practical Vim'
:%s//\=@a/g
```

#### Tip 92 - Repeat the previous substitute command

- :s/target/replacement/g

- but then we see that we forget to add %

- g& to repeat command across entire file, similar to :%s//~/&

#### Tip 93 - Rearrange CSV fields using submatches
#### Tip 94 - Perform arithmetic on the replacement

- replacement string doesnt have to be simple one
- we can evaluate a vim script and use it result as a replacement string

#### Tip 95 - Swap two or more words

- abolish.vim plugin

#### Tip 96 - Find and replace across multiple files

### Chapter 15 - Global Commands

#### Tip 97 - Meet the global command

- :global command allows us to run an Ex command on each line that matches a particular pattern

- :[range] global[!] /{pattern}/ [cmd]

- default range for :global command is entire file (%)

- [cmd] could any other Ex command, uses :print by default

- invert the behavior of the :global command by either: :global! or :vglobal

#### Tip 98 - Delete lines containing a pattern

- :delete and :cut command can be used

- :g/re/p
- global, regular expressin, print

- :v/href/d
- delete each line doesnt contain 'href'

#### Tip 99 - Collect TODO items in a register

- combining :global and :yank commands allows us to collect all lines that match
  a pattern in register

- :g/TODO
- default cmd is :print

- clear register a, qaq
- :reg a

- :g/TODO/yank A
- :reg a

- "ap paste the content of register a
- can be used across a list of buffers

- :g/TODO/t$
- copies all the TODOs at the end of the file, practical but cannot be used with bufs

#### Tip 100 - Alphabetize the properties of each rule in a CSS file

## Part VI - Tools

- Vim provides wrapper commands that make it easy to call external programs such
  as 'make' and 'grep'

### Chapter 16 - Index and navigate source code with ctags

- ctags is an external program that scans through a codebase and generates an
  index of keywords

- Vim's ctags support allows us to navigate around a codebase by quickly jumping
  to definitions of functions and classes

- as a secondary benefit, we can also use the output from ctags to generate a
  word list for autocompletion

- Tag navigation and tag autocompletion wont work unless vim knows where to look
  for an up-to-date index file

#### Tip 101 - Meet ctags

- we must first install ctags after vim6 it became a separate project

- sudo apt-get install exuberant-ctags
- ctags --help

- ctags \*.rb

- creates a file in current directory named 'tags'

- inside tags file, keywords are arranged in alphabetical order, so can be
  rapidly located with binary search

- keywords are addressed by pattern, not by line number

#### Tip 102 - Configure Vim to work with ctags

- be sure tags file is up-to-date and vim knows where to look for it
- 'tags' option specifies where vim should look
- :set tags?

- tags file can be in every subdirectory, or a global one
- keeping tags file up-to-date and add it to ignore files

- execute ctags from vim
- :!ctags -R

- adding option become a chore, we can create a mapping:
- nnoremap <F3> :!ctags -R<CR>

- still would be a extra work to press f3 each time we have chance in code

- automatically execute ctags each time a file is saved
- :autocmd BufWritePost * call system("ctags -R")

#### Tip 103 - Navigate keyword definitions with Vim's tag navigation commands

- vim's tag integration turns the keywords in our code into a kind of hyperlink

- C-] jump from the keyword under the cursor to the definition

- vim maintains a history of the tags we've visited
- C-t acts as the back button 

- in case of multiple matches, matches in current buffer gets highest priority

- if there is a single matches, C-] and gC^] are same
- in case of multiple matches, gC^] presents us with a list of choice

- :tselect to bring up the list again
- :tnext to jump next matching tag, :tfirst, :tlast, :tprev 

### Chapter 17 - Compile code and navigate error with the quickfix list

- quickfix list is a core feature that allows us to integrate external tools into our workflow

#### Tip 104 - Compile code without leaving Vim

- run :make in vim
- it gives same output as would be run in shell
- vim parse the output being shown and create a quickfix list
- after coming back to vim, it will place cursor on the first error
- :cnext

- :make! tells vim create your quickfix list but dont jump on the first one
- use C^O to jump back if you forget the bang

#### Tip 105 - Browse the Quickfix list

- quickfix is just single one, for split, windows, tabs or buffers
- there could be location list for each active window

- :copen, :cclose

#### Tip 106 - Recall results from a previous quickfix list

- vim hold onto the last ten lists
- :colder, :cnewer
- they are undo and redo commands for quicklist

#### Tip 107 - Customize the external compiler

- :compiler and :make are not just for compiled languages

- :setlocal makeprg=NODE_DISABLE_COLORS=1\ nodelint\ %
- % expands to current file

- vim knows how to parse errors from make program, so we can tell him how to parse error msgs
- :setglobal errorformat?

- :setlocal efm=%A%f\,\ line\ %l\,\ character\ %c:%m,%Z%.%#,%-G%.%#

- writing those things can be tedious
- :compiler set them up

### Chapter 18 - Search project-wide with grep, vimgrep, and others

#### Tip 108 - Call grep without leaving vim

- vim's :grep command acts as a wrapper to an external grep-like program
- we can search for a pattern across multiple files without leaving vim
= we can navigate the results using the quickfix list

- grep -n aword *
- n includes line numbers
- vim afile.txt +9

- we can call grep from inside vim
- :grep aword *
- vim parses the output and create a quicklist for us
- vim includes -n automatically

- :grep -i award *

#### Tip 109 - Customize the grep program

- we can tell vim to use a different program instead of unix grep

- :set grepprg?
- :set grepformat?

- :set grepprg=ack\ --nogroup\ $\*
- ack output now is exactly same as grep no need to change grepformat

- grep uses POSIX regex
- ack uses Perl regex

- https://github.com/mileszs/ack.vim
- use a plugin for ack and normal grep together

#### Tip 110 - Grep with Vim's internal search engine

- :vimgrep is native regex search engine
- can be used as :vim
- :vim[grep][!] /{pattern}/[g][j] {file}
- j prevents to directly jump to a match

### Chapter 19 - Dial X for autocompletion

#### Tip 111 - Meet Vim's keyword autocompletion

- She sells sea shells
- :infercase
- C^N or C^P trigger autocompletion in insert mode
- they invoke generic keyword autocompletion

command      | Type of completion
-------------|-------------------
C^n          | generic keywords
C^x+C^n      | current buffer keyword
C^x+C^i      | included file keywords
C^x+C^]      | tags file keywords
C^x+C^k      | Dictionary loopup
C^x+C^l      | whole line completion
C^x+C^f      | file name completion
C^x+C^o      | omni-completion

#### Tip 112 - Work with the autocomplete pop-up menu

- c^n next match
- c^p previous match
- c^y accept the currectly selected match, yes
- c^e revert the originally typed text, exit

- use c^nc^p trick bring up suggestion anf filter them

#### Tip 113 - Understand the source of keywords

- :set complete?
- :h complete

#### Tip 114 - Autocomplete words from the dictionary

- C^xC^k to trigger dictionary lookup
- :set spell?
- :set spell "active built-in spell checker
- :h 'dictionary'

#### Tip 115 - Autocomplete entire lines

- C^xC^l
- the beauth of line-wise auto completion is that we dont have to know the loccation of the line we are duplicating

#### Tip 116 - Autocomplete filenames

- :pwd
- :cd {path}
- :cd - 

- expands to paths relative to working directory, not relative to the current file

#### Tip 117 - Autocomplete with context awareness

- Omni-completion is Vim's answer to intellisense
- C^xC^o
- have to install a plugin that implements omni-completion for the language we are working with
- :h compl-omni-filetypes

- to figure out how to write omni-completion plugins :h complete-functions

### Chapter 20 - Find and fix typos with vim's spell checker

#### Tip 118 - Spell check your work

- [s, ]s jump between flagged works
- when cursor is positioned on the misspelled word, z= ask for suggestions
- 1z= if you believe first suggestion will  be correct one
- disable spell checker while writing not to be disturbed, active at the end

- zg add current word to spell file
- zw remove current word from spell file

#### Tip 119 - use alternate spelling dictionaries

- by default Vim comes with a English checker
- spellang
- spellang=en

- :set spell
- :set spellang=en_us
- :set spellang=fr
- vim offers to download it if now available on the system

#### Tip 120 - Add words to the spell file

- zg add a word to spell file
- zw remove a word
- zug undo if did smth wrong with zg or zw

#### Tip 121 - Fix spelling errors from insert  mode

- C^xC^s


### Chapter 21 - Now What?
