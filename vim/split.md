# Splits

- One of the best parts of managing files in Vim is its splits
- you can split your current window into 2 windows at any time
- resize and arrange them into any configuration you like

```shell
:sp <filename>    # horizontal split
:vs <filename>    # vertical split

:split            # it will start open same file in the new window
:split file       # opens the file in a new window
:10split file     # opens a file 10 lines below the above
:new              # opens a empty file in a new window

ctrl-ww           # to jump from one window another (or ctrl-w ctrl-w) 
ctrl-wj           # to go down a window
ctrl-wk           # to go up a window
crtl-wc           # to close a window ( or ZZ or :q )
ctrl-w+           # to increase the window size one line
ctrl-w-           # to decrease the window size one line
ctrl-w=           # to make all windows the same size

C^W[h|j|k|l]      # move between splits
```

* Internal move operations are not so efficient and easy

- You may use this ones :

```shell
nnoremap <C-J> <C-W><C-J> "Ctrl-j to move down a split
nnoremap <C-K> <C-W><C-K> "Ctrl-k to move up a split
nnoremap <C-L> <C-W><C-L> "Ctrl-l to move    right a split
nnoremap <C-H> <C-W><C-H> "Ctrl-h to move left a split
```

### Jumplist

- also C^O and C^I can be useful while moving between splits
- to go where you were before. move forward and backward

