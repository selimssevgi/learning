# chmod: change mod

- change the permissions of a file or directory

- Earliest version of chmod just used bits to modify permissions

- now we can use some letters:
  - u - user
  - g - group
  - o - other
  - r - read
  - w - write
  - x - execute
  - a - stands for all

- g+a means add all permissions to group category

- a+r means add read permissions to all category

```shell
chmod a+r file        # gives everyone read permission

chmod go-w file       # takes away write permission from group, others

chmod u+x file        # sets up a shell script so u can execute it like a command

chmod +x file         # make filename executable
```


```shell
rwx rwx rwx = 111 111 111
rw- rw- rw- = 110 110 110
rwx --- --- = 111 000 000

rwx = 111 in binary = 7
rw- = 110 in binary = 6
r-x = 101 in binary = 5
r-- = 100 in binary = 4
```

- 777 - (rwxrwxrwx) No restrictions on permissions

- 755 - (rwxr-xr-x) This setting is common for programs that are used by all users

- 700 - (rwx------) This setting is useful for programs that must be kept private from others

- 666 - (rw-rw-rw-) All users may read and write the file

- 644 - (rw-r--r--) A common setting for data files that everybody may read, but only the owner may change

- 600 - (rw-------) A common setting for data files that the owner wants to keep private

## Directory Permission

- r - Allows the contents of the directory to be listed if the x attribute is also set
- w - Allows files within the directory to be created, deleted, or renamed if the x attribute is also set
- x - Allows a directory to be entered (i.e. cd dir)

- 777 - (rwxrwxrwx) Generally not a good setting

- 755 - (rwxr-xr-x) This setting is common for directories that you wish to share with other users

- 700 - (rwx------) Nobody else has any rights, private from others.


