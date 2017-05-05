# Buffers in Vim
A buffer is a copy of the file that you edit. 
When you finish changing the buffer and exit,
the contents of the buffer are written to the file.
Buffers not only contain file contents,
but also all the marks, settings, and other stuff that go with it.

* If it has a windows on the screen, it is a buffer.

- :hide command is to hide a buffer/file, so in a way is closing it,
but without losing the buffer.

### A buffer can have three states:
- Active    Appears onscreen
- Hidden    A file is being edited, but does not appear onscreen.
- Inactive  The file is not being edited, but keep the information about it anyway.

:buffers lists the buffers.

```vim
- Inactive buffer
h Buffer is hidden
% Current buffer
# alternate buffer
+ file has been modified
```
#### Navigation
- :buffer number
- :buffer file
