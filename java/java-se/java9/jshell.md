# jshell Notes

- 

```shell
$ jshell
jshell> /help
```

### Optional Items

- Optionality works with snippets, with methods is normal strict java
- Semicolons(mandatory in methods)
- Try/Catch

### Helpful Tips

- Up and down arrows, brings even from previous sessions
- TAB to complete or see options
- CTRL+A goes to beginning of line
- CTRL+E goes to end of the line
- CTRL+C cancels what you are doing on the that line
- CTRL+D exits
- CTRL+L clears screen
- method( SHIFT-TAB to see overloaded method signatures
- ALT-V to assign the snippet to a variable, interfere the type

### Commands 

#### /list

- /! executes last line again
- /list
- /2
- /-2 backwards second command
- /history : /list + jshell commands

#### /imports

- Lists imported packages
- /import java.lang.annotation

#### /vars

- Lists currently defined explicit and implicit variables

#### /methods

- List defined methods

#### /drop

- Remove variables or methods
- /drop max

#### /save

- Save your session
- /save sessionname

#### /open

- Load particular session
- /open sessionname

#### /edit

- Edit variable names
- /edit $1

#### /reset

- Resetting state. Removing all variables.

#### /set

- /set feedback verbose # too much noise
- /set feedback silent  # too quite
- /set feedback normal  # normal
- /set mode mymode normal|silent|verbose
- /set prompt mymode ">" "|"
- /set feedback mymode

#### Startup file

- jshell -nostartup # starts without defaults
- jshell -startup mystartup.jshell
