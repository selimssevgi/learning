# Folds in Vim
It is something similar to plus sign next to line numbering in an IDE. 
Collapsing and expanding a method or a class.

#### Some Commands
zf{motion}        - create a fold zfap for paragraph folding
{visual}
zF {N}            - Fold N lines

zd                - Delete the fold under the cursor
zo                - Open the fold under the cursor
zc                - Close the fold under the cursor

#### Example
- on class definition in normal mode: zf}, then zo and zc

```java
public class Test {
  public static void main(String[] args)  {
    System.out.println("Hello World!");
  }
}
```



