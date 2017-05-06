change the permissions of a file or directory.

# Earliest version of chmod just used bits to modify permissions. 
  but now we can use some letters.
  u - user, g - group, o - other
  r - read, w - write, x - execute
  a - stands for all

# g+a means add all permissions to group category

# a+r means add read permissions to all category.

# chmode a+r file // gives everyone read permission

# chmode go-w file // takes away write permission from group, others

# chmode u+x file // sets up a shell script so u can execute it like a command


rwx rwx rwx = 111 111 111
rw- rw- rw- = 110 110 110
rwx --- --- = 111 000 000


rwx = 111 in binary = 7
rw- = 110 in binary = 6
r-x = 101 in binary = 5
r-- = 100 in binary = 4

777 - (rwxrwxrwx) No restrictions on permissions. Anybody may do anything. Generally not a desirable setting.

755 - (rwxr-xr-x) The file's owner may r, w, and x the file. All others may r and e the file. This setting is common for programs that are used by all users.

700 - (rwx------) The file's owner may r, w, and x the file. Nobody else has any rights. This setting is useful for programs that must be kept private from others.

666 - (rw-rw-rw-) All users may read and write the file.

644 - (rw-r--r--) The owner may r and w a file, while all others may only read the file. A common setting for data files that everybody may read, but only the owner may change.

600 - (rw-------) The owner may read and write a file. All others have no rights. A common setting for data files that the owner wants to keep private.

Directory Permission

r - Allows the contents of the directory to be listed if the x attribute is also set.
w - Allows files within the directory to be created, deleted, or renamed if the x attribute is also set.
x - Allows a directory to be entered (i.e. cd dir).

777 - (rwxrwxrwx) No restrictions on permissions. Anybody may list files, create new files in the directory and 
                  delete files in the directory. Generally not a good setting.

755 - (rwxr-xr-x) The directory owner has full access. All others may list the directory,
                  but cannot create files nor delete them. 
                  This setting is common for directories that you wish to share with other users.

700 - (rwx------) The directory owner has full access. Nobody else has any rights.
                  This setting is useful for directories that only the owner may use and must be kept private from others.

chmod +x ~/filename #make filename executable

