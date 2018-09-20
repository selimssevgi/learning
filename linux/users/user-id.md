# User Identification

## User ID

- The user ID from the entry in /etc/passwd file is a numeric value

- It identifies user to the system

- It cannot be changed

- The user whose user Id is 0 either root or the superuser

## Group ID

- The entry in the /etc/passwd file also specifies the numeric group ID

- Groups are normally used to collect users together into projects or deparments

- There is also a group file that maps group names into numeric group IDs: /etc/group

- With every file on disk, the file system stores both the user ID and the group ID of a file's owner

- Storing both of these values requires only four bytes

- If the full ASCII login name and group name were used instead, additional disk
  space would be required. In addition, comparing string during permission
  checks is more expensice than comparing integers
