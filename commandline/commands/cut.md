Is used to select sections of text from each line of files.
You can use the cut command to select fields or columns from a line 
by specifying a delimiter or you can select a portion of text by specifying the range or characters.
Basically the cut command slices a line and extracts the text.

# indexing start from 1

cut -c4 file.txt # fourth character from each line in the file
cut -c4,6 file.txt # fourth and sixth chracter
cut -c4-7 file.txt # from 4th to 6th
cut -c-6 file.txt # from first to 6th
cut -c10- file.txt # from 10th to last

cut -d' ' -f2 file.txt # use ' ' as delimeter an extract field 2
cut -d' ' -f2,3 file.txt # field 2 and 3
cut -d' ' -f1-3 file.txt # field 1,2 and 3

TAB=$(printf '\t') # cannot use \t direclty ask for a single character. 
cut -f-3 -d"$TAB" # first three field separated by tab
