# Java IO

- File
- FileWriter
- FileReader
- BufferedWriter
- BufferedReader
- PrintWriter

## File

```java
File f = new File("abc.txt");
```

This line will not create any physical file. First it will check if there is any
physical file named abc.txt is available or not. If it is available, then f
simply refer to that file. If it is not available, then we are just creating
java file object to represent a name abc.txt.

```java
File f = new File("abc.txt");
System.out.println(f.exists()); // false
f.createNewFile();
System.out.println(f.exists()); // true
```

We can use java file object to represent directory also.

```java
File f = new File("dir1");
System.out.println(f.exists()); // false
f.mkdir();
System.out.println(f.exists()); // true
```

**NOTE:** In Unix everything is treated as file. Java File IO concept is
implemented based on Unix OS. Hence Java File object can be used to represent
both files and directories.

### File Class Constructors
1. File f = new File(String pathname)
   Creates a java file object to represent name of the file or directory in
   current working directory.

2. File f = new File(String parent, String child)
   Creates a java file object to represent name of the file or directory present
   in specified 'parent' directory.

3. File f = new File(File parent, String child)


**Example:** Write code to create a file named with 'abc.txt' in current working
directory.

```java
File f = new File("abc.txt");
f.createNewFile();
```

**Example2:** Write code to create directory named with 'selim123' in current
working directory and create a file named with 'demo.txt' in that directory.

```java
File f = new File("selim123");
f.mkdir();
// File f2 = new File("selim123", "demo.txt");
File f2 = new File(f, "demo.txt");
f2.createNewFile();
```

**Example3:** Write code to create a file named 'abc.txt' in E:xyz
folder.(Assume E:xyz is already available in the system)

```java
File f = new File("E:\\xyz", "abc.txt");
f.createNewFile();
```

### Important Methods Present in File Class

- boolean exists() : returns true if the speficied file or directory available

- **boolean createNewFile()** : First checks whether specified file is available or
  not. If it is already available then this method returns false without
  creating a new physical file. If the file is not already available, then this
  method creates a new file and returns true.

- boolean mkdir() :

- boolean isFile() : returns true if file object is pointing to physical file.

- boolean isDirectory() :

- String[] list() : This method returns the names of all files and
  subdirectories present in speficied directory.

- long length() : returns number of characters present in the speficied file.

- boolean delete() : to delete speficied file or directory.

**Question:** Write a program to display the names of all files and directories
present in current working directory.

```java
File f = new File(".");
String[] files = f.list();
for(String file : files) {
  System.out.println(file);
}
```

To display only file names:

```java
File f = new File(".");
String[] files = f.list();
for(String file : files) {
  File f1 = new File(f, file)
  if (f1.isFile()) {
    System.out.println(file);
  }
}
```

To display only directory names:

```java
File f = new File(".");
String[] files = f.list();
for(String file : files) {
  File f1 = new File(f, file)
  if (f1.isDirectory()) {
    System.out.println(file);
  }
}
```

## FileWriter
We can use FileWriter to write 'character data' to the file. 

### Constructors

1. FileWriter fw = new FileWriter(String fileName)
2. FileWriter fw = new FileWriter(File file)

The above FileWriters are meant for overriding of existing data. Instead of
overriding if we want to append operation, then we have to create FileWriter by
using the following constructors.

3. FileWriter fw = new FileWriter(String fileName, boolean append)
4. FileWriter fw = new FileWriter(File file, boolean append)


If the specified file is not already available, then all the above constructors
will create that file.

### Important Methods

1. write(int ch) : to write a single character

2. write(char[] ch) : to write an array of characters

3. write(String s) : to write string to the file

4. flush() : to give the gurantee that total data including last character will
   be written to the file.

5. close() : close the writer

```java
import java.io.*;

class FileWriterDemo {
  public static void main(String[] args) throws IOException {
    FileWriter fw = new FileWriter("abc.txt");
    fw.write(100);
    fw.write("urga\SoftwareSolutions");
    fw.write('\n');
    fw.write(new char[]{'a', 'b', 'c'});
    fw.flush();
    fw.close();
  }  
}
```

In the above program FileWriter can perform overriding of existing data. Instead
of overriding if we want to append operation, then we have to create FileWriter
object as follows:

```java
FileWriter fw = new FileWriter("abc.txt", true); // append : true
```

**NOTE:** The main problem with FileWriter is, we have to insert line
separator(\n) manually, which is varied from system to system. It is difficulty
to the problem. We can solve this problem by usin BufferedWriter and PrintWriter
classes.

## FileReader
We can use FileReader to read 'character data' from the file.

### FileReader Constructors

1. FileReader fr = new FileReader(String fileName)
2. FileReader fr = new FileReader(File file)

### FileReader Important Methods

1. int read() : it attempts to next character from the file and returns its
  unicode value. If the next is not available, then this method returns -1. As
  this method returns unicode value(int value), at the time of printing we have
  perform type-casting.

```java
FileReader fr = new FileReader("abc.txt");
int i = fr.read();
while (i != -1) {
  System.out.println((char) i);
  i = fr.read();
}
```

2. int read(char[] ch) : it attempts to read enough characters from the file
   into char array, and returns the number of characters copied from the file.

```java
File f = new File("abc.txt");
char[] ch = new char[(int) f.length()];
FileReader fr = new FileReader(f);
fr.read(ch);

for (char ch1 : ch) {
  System.out.print(ch);
}
```

3. close() : always close the file.

**NOTE:** By using FileReader we can read data character by character, which is
not convinient to the programmer. (Reading line by line?)

**NOTE:** Usage of FileWriter and FileReader is not recommended because:

1. While writing data by FileWriter we have to insert to line separator(\n)
   manually, which is varied from system to system. It is difficulty to the
   programmer.

2. By using FileReader we can read data character by character, which is not
   convinient to the programmer. 

To overcome these problems we should go for BufferedWriter and BufferedReader.

## BufferedWriter
We can use BufferedWriter to write 'character data' to the file.

### BufferedWriter Constructors

1. BufferedWriter br = new BufferedWriter(Writer out)

2. BufferedWriter br = new BufferedWriter(Writer out, int bufferSize)

**NOTE:** BufferedWriter cannot communicate directly with the file. It can
communicate via some Writer object.

**Question:** Which of the following is valid?
```java
BufferedWriter bw = new BufferedWriter("abc.txt"); // invalid. no such constructor
BufferedWriter bw = new BufferedWriter(new File("abc.txt")); // invalid
BufferedWriter bw = new BufferedWriter(new FileWriter("abc.txt")); // valid
BufferedWriter bw = new BufferedWriter(new BufferedWriter(new FileWriter("abc.txt"))); // valid
// two-level buffering
```

### BufferedWriter Important Methods
1. write(int ch) : to write a single character

2. write(char[] ch) : to write an array of characters

3. write(String s) : to write string to the file

4. flush() : to give the gurantee that total data including last character will
   be written to the file.

5. close() : close the writer

6. newLine() : to insert a new line

**NOTE:** When compare with the FileWriter which of the following capability is
available extra in method form in BufferedWriter?

1. Writing data to the file
2. Close the file
3. Flushing the file
4. Inserting a new line character // extra

```java
import java.io.*;

class BufferedWriterDemo {
  public static void main(String[] args) throws IOException {
    FileWriter fw = new FileWriter("abc.txt");
    BufferedWriter bw = new BufferedWriter(fw);
    bw.write(100);
    bw.newLine();
    char[] ch1 = {'a','b', 'c', 'd'};
    bw.write(ch1);
    bw.newLine();
    bw.write("selim");
    bw.newLine();
    bw.write("software solutions");
    bw.flush();
    bw.close();
  }  
}
```

**NOTE:** Whenever we are closing BufferedWriter automatically internal file
writer will be closed. And we are not required to close explicitly.

```java
bw.close(); // recommended way
//--------------------
fw.close(); // bw didnot close
//--------------------
bw.close();
fw.close(); // fw already closed
```

## BufferedReader
We can use BufferedReader to read 'character data' from the file. The main
advantage of BufferedReader when compared with FileReader is, we can read data
line by line in addition to character by character.

### BufferedReader Constructors

1. BufferedReader br = new BufferedReader(Reader in)

2. BufferedReader br = new BufferedReader(Reader in, int sz)

**NOTE:** BufferedReader cannot communicate directly with a file, and it can
communicate via some reader object.

### BufferedReader Important Methods

1. int read()

2. int read(char[] ch)

3. void close()

4. String readLine() : It attemps to read next line from the file, it returns
   it. If the next line is not available, then this method returns null.


```java
import java.io.*;

class BufferedReaderDemo {
  public static void main(String[] args) throws Exception {
    FileReader fr = new FileReader("abc.txt");
    BufferedReader br = new BufferedReader(fr);
    String line = br.readLine();
    while (line != null) {
      System.out.println(line);
      line = br.readLine();
    }

    br.close();
  }
}
```

**NOTE:** Whenever we are closing BufferedReader, automatically underlying
FileReader will be closed, and we are not required to close explicitly.

**OTE:** The most enhance Reader to read character data from the file is
BufferedReader. 

## PrintWriter
It is most enchanced Writer to write character data to the file. The main
advantage of PrintWriter over FileWriter and BufferedWriter is, we can write any
type of primitive data directly to the file.

### PrintWriter Constructors

1. PrintWriter pw = new PrintWriter(String fileName)

2. PrintWriter pw = new PrintWriter(File file)

3. PrintWriter pw = new PrintWriter(Writer out)

**NOTE:** PrintWriter can communicate directly with a file and can communicate
via some Writer object also.

### PrintWriter Important Methods

1. write(int ch)

2. write(char[] ch)

3. write(String s)

4. flush()

5. close()

6. print(char ch), print(int i), print(double d), print(boolean b), print(String s)

7. println(char ch), println(int i), println(double d), println(boolean b), println(String s)


```java
import java.io.*;

class PrintWriterDemo {
  public static void main(String[] args) {
    FileWriter fw = new FileWriter("abc.txt");
    PrintWriter out = new PrintWriter(fw);
    out.write(100); // unicode value
    out.println(100);
    out.println(true);
    out.println('c');
    out.println("selim")
    out.flush();
    out.close();
  }
}
```

**Question:** What is the difference between write(100) and print(100)?

In the case of write(100) corresponding character 'd' will be added to the file.
But in the case of print(100) int value 100 will be added to the file.

**NOTE:** The most enhance Writer to write 'character data' to a file is
PrintWriter. Whereas the most enhance Reader to read 'character data' from a
file is BufferedReader.


**NOTE:** In general we can use Readers and Writers to handle 'character data'
(text data), whereas we can use Streams to handle 'binary
data'(images,pdf,video,audio file etc). We can use OutputStream to write binary
data to the file, InputStream to read binary data from file.

- Character Data(Text Data)
  - Reader
  - Writer
- Binary Data(images,pdf,video...)
  - InputStream
  - OutputStream

#### Class Hierarchy
- Object
  - Writer(AC)
    - OutputStreamWriter
      - FileWriter
    - BufferedWriter
    - PrintWriter

  - Reader(AC)
    - InputStreamReader
      - FileReader
    - BufferedReader

**Question:** Write a program to merge data from two files into a third file.

```java
import java.io.*;

class FileMerger {
  public static void main(String[] args) throws Exception {
    PrintWriter pw = new PrintWriter("file3.txt"); 
    BufferedReader br = new BufferedReader(new FileReader("file1.txt"));
    String line;
    while ((line = br.readLine()) != null) {
      pw.println(line);
    }

    br = new BufferedReader(new FileReader("file2.txt"));
    while ((line = br.readLine()) != null) {
      pw.println(line);
    }

    pw.flush();
    br.close();
    pw.close();
  }
}
```

**Question:** Write a program to perform file merge operation where merging
should be done line by line alternatively.

```java
import java.io.*;

class FileMerger {
  public static void main(String[] args) throws Exception {
    PrintWriter pw = new PrintWriter("file3.txt"); 
    BufferedReader br1 = new BufferedReader(new FileReader("file1.txt"));
    BufferedReader br2 = new BufferedReader(new FileReader("file2.txt"));
    String line1 = br1.readLine();
    String line2 = br2.readLine();
    while ((line1 != null) || (line2 != null)) {
      if (line1 != null) {
        pw.println(line1);
        line1 = br1.readLine();
      }
      if (line2 != null) {
        pw.println(line2);
        line2 = br2.readLine();
      }
    }

    pw.flush();
    br1.close();
    br2.close();
    pw.close();
  }
}
```

**Question:** Write a program to perform file extraction operation. 
input.txt = input.txt - deleted.txt

```java
import java.io.*;

class FileExtractor {
  public static void main(String[] args) throws Exception {
    PrintWriter pw = new PrintWriter("output.txt");
    BufferedReader br1 = new BufferedReader(new FileReader("input.txt"));
    String line = br1.readLine();
    while (line != null) {
      boolean available = false;
      BufferedReader br2 = new BufferedReader(new FileReader("deleted.txt"));
      String target = br2.readLine();
      while (target != null) {
        if (line.equals(target)) {
          available = true;
          break;
        }
        target = br2.readLine();
      }

      if (available == false) {
        pw.println(line);
      }

      line = br1.readLine();
    }

    pw.flush();
    pw.close();
    br1.close();
  }  
}
```

**Question:** Write a program to remove duplicates from the input file.

```java
import java.io.*;

class DuplicateEliminator {
  public static void main(String[] args) throws Exception {
    PrintWriter pw = new PrintWriter("output.txt");
    BufferedReader br1 = new BufferedReader(new FileReader("input.txt"));
    String line = br1.readLine();
    while (line != null) {
      boolean available = false;
      BufferedReader br2 = new BufferedReader(new FileReader("output.txt"));
      String target = br2.readLine();
      while (target != null) {
        if (line.equals(target)) {
          available = true;
          break;
        }
        target = br2.readLine();
      }

      if (available == false) {
        pw.println(line);
        pw.flush(); // we have to read and check against in output file
      }

      line = br1.readLine();
    }

    pw.flush();
    pw.close();
    br1.close();
  }  
}
```
