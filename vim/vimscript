# let allows you to change a variable
let <var-name>=<value>

# set allows you to reador change an option value
set <option-name>                          # for toggle options
set <option-name>=<option-value>>          # for numeric or string-based options

# map and its many variations allow you to create new keymappings

# learder key
You might be wondering what the notation is there.
The <leader> key is a Vim convention for a key that comes before user created keystrokes.
It's meant to minimize conflicts, and allow plugins to provide default mappings 
while still allowing the user a bit of flexibility.
The leader key can be set in your vimrc with the command let mapleader=<yourleaderkey>.
The default is \, and I would recommend leaving it that way to start.
You can change it later if you find it to be inconvenient,
and it doesn't cause any conflicts since its the default key.
Common replacements like , overwrite useful functionality that may not be immediately obvious 
(, allows you to move backwards on a characterwise search for instance).

# file type specific rules
You can also set file-type specific rules.
Rather than placing these in your main vimrc,
these go into a special "file type plugins" directory, ~/.vim/ftplugin.
Within that directory, you can create files like javascript.vim,
python.vim or html.vim, and those files will be loaded after the vimrc when 
you open files of that type. Using those files,
you can create completely separate profiles for each file type.
