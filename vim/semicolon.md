:!<shellcommand> -> execute shell command

:ls -> list of open buffers

:r <filename> -> paste the content of the file in current file

:r !ls -> paste the output of ls command

:w <filename> -> save the file. filename is optional. think as "save as"

:wq -> save and quit

:q! -> quit without saving

:q -> quit when there is no change

:s/old/new -> only changes the first occurence of the old with new in line

:s/old/new/g -> changs occurences of the old with new in line globally

:%s/old/new/g -> change every occurence of the old with new in whole file globally

:%s/old/new/gc -> find and prompt to change every occurence of the old with new in whole file globally

:gui -> switch to gui

:grep # find all accourences and use :cn for the next. changing arguments of a func
