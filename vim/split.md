One of the best parts of managing files in Vim is its splits.
With Vim, you can split your current window into 2 windows at any time,
and then resize and arrange them into any configuration you like.

# Open a new split 
:sp <filename>    # horizontal split
:vs <filename>    # vertical split

# move between splits
C^W[h|j|k|l]

# internal move operations are not so efficient and easy.
# You may use this ones : 
nnoremap <C-J> <C-W><C-J> "Ctrl-j to move down a split  
nnoremap <C-K> <C-W><C-K> "Ctrl-k to move up a split  
nnoremap <C-L> <C-W><C-L> "Ctrl-l to move    right a split  
nnoremap <C-H> <C-W><C-H> "Ctrl-h to move left a split

# Jumplist
# also ctrl-o and ctrl-i can be useful while moving between
# splits. to go where you were before. move forward and backward
