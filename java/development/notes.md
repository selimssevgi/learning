


## javac - javacompiler
We can use javac command to compile a single or group of java source files.

```shell
$ javac [options] Test.java
$ javac [options] A.java B.java C.java
$ javac [options] *.java
```

- Options :
  - version
  - d
  - source
  - verbose
  - cp | classpath

## java - jvm
We can use java command to run a signle class file.

```java
$ java [options] Test arg1 arg2 arg2
# Test.class
```

- Options:
  - version
  - D
  - cp | classpath
  - ea | esa | dsa | da

**NOTE:** We can compile any number of sources files at a time, but we can run
only one .class file at a time.


## Classpath
Describes the location where required .class files are available. Java Compiler
and JVM will use classpath to locate required .class files.


```java
public class Test {
  public static void main(String[] args) {
    System.out.println("classpath demo");
  }
}
```

```java
~/javatest/ $ javac Test.java
~/javatest/ $ java  Test
classpath demo
~/javatest/ $ cd ..
~/ $ java Test
RE: NoClassDefFoundError : Test
```

By default JVM always searches in current directory for the required .class
file. If we set classpath explicitly, then JVM will search in our specified
classpath location and JVM wont search in current working directory.

We can set classpath in the following three ways:

1. By using environment variable classpath : This way of setting classpath is
   permenant, and it will be preserved across system restarts. Whenever we are
   installing a permenant software in our system, then this approach is
   recommended.

2. At the command prompt level by using set command : This way of setting
   classpath will be preserved only for particular command prompt. Once command
   prompts closes, automatically classpath will be lost.

```shell
set classpath = /home/ssselim/javaclasses
```

3. At the command level by using -cp option: This way of setting classpath will
   be preserved only for particular command. Once command execution complites,
   automatically classpath will be lost.

```java
$ java -cp /home/ssselim/javaclasses Test
```

**NOTE:** Among three ways of setting classpath, setting classpath at command
level is recommended. Because dependent classes are varied from command to
command.

Once we set the classpath, we can run our program from any location.

```shell
~/javatest/ $ javac Test.java
~/javatest/ $ java  Test
classpath demo
~/javatest/ $ cd ..
~/ $ java Test
RE: NoClassDefFoundError : Test
~/ $ java  -cp ~/javatest/ Test
classpath demo
~/Downloads/ $ java  -cp ~/javatest/ Test
classpath demo
```
Once we set classpath, JVM wont search in curret working directory. It will
always search in the specified classpath location only.

```shell
~/javatest/ $ java  -cp ~/Downloads/ Test
RE: NoClassDefFoundError : Test

~/javatest/ $ java  -cp .;~/Downloads/ Test # in unix it might be ":" not ;.  TRY!
classpath demo
```

```java
// ~/Desktop/testJava/AClass/AStudent.java
public class AStudent {
  public void m1() {
    System.out.println("I want a JOB!");
  }
}
```

```java
// ~/Desktop/testJava/BClass/ITIndustry.java
public class ITIndustry {
  public static void main(String[] args) {
    AStudent s = new AStudent();
    s.m1();
    System.out.println("you will get soon!");
  }
}
```

```shell
~/Desktop/testJava/AClass/ $ javac AStudent.java
~/Desktop/testJava/AClass/ $ ls
AStudent.class AStudent.java
~/Desktop/testJava/BClass/ $ javac ITIndustry.java
CE: cannot find symbol, symbol: class Student, location: class ITIndustry
~/Desktop/testJava/BClass/ $ javac -cp ../AClass/ ITIndustry.java
~/Desktop/testJava/AClass/ $ ls
ITIndustry.class ITIndustry.java
~/Desktop/testJava/AClass/ $ java ITIndustry
RE: NoClassDefFoundError: AStudent
~/Desktop/testJava/AClass/ $ java -cp ../AClass/ ITIndustry
Error: Could not find or load main class ITIndustry
~/Desktop/testJava/AClass/ $ java -cp .:../AClass/ ITIndustry
I want a JOB!
you will get soon!
~/ $ java -cp ~/Desktop/testJava/BClass/:/home/ssselim/Desktop/testJava/BClass/ ITIndustry
I want a JOB!
you will get soon!
```


```java
// /tmp/C/Kareena.java
package pack1.pack2;

public class Kareena {
  public void m1() {
   System.out.println("Hello Saif! can you please set hellotune!");
  }
}
```

```shell
/tmp/C/ $ javac -d . Kareena.java
/tmp/C/ $ tree .
.
|--- Kareena.java
|--- pack1
     |--- pack2
          |--- Kareena.class
```

```java
// /tmp/C/Saif.java
package pack3.pack4;

public class Saif {
  public void m2() {
    Kareena k = new Kareena();
    k.m1();
    System.out.println("No, I cant!!");
  }
}
```

```shell
/tmp/D/ $ javac -d . Saif.java
CE: cannot find symbol, symbol: class Kareena, location: class Saif
```

If we are refering to another class in a package, we have specify the directory
in import statement.

```java
// /tmp/C/Saif.java
package pack3.pack4;

import pack1.pack2.Kareena;

public class Saif {
  public void m2() {
    Kareena k = new Kareena();
    k.m1();
    System.out.println("No, I cant!!");
  }
}
```

```shell
/tmp/D/ $ javac -d . Saif.java
CE: package pack1.pack2 does not exist
/tmp/D/ $ javac -d . -cp /tmp/C/ Saif.java
/tmp/D/ $ tree .
.
|--- Saif.java
|--- pack3
     |--- pack4
          |--- Saif.class
```


```java
// /tmp/E/Durga.java
import pack3.pack4.Saif;

public class Durga {
  public static void main(String[] args) {
    Saif s = new Saif();
    s.m2();
    System.out.println("Hello! How I can help you?");
  }
}
```

```shell
/tmp/E/ $ javac -d . Durga.java
CE: package pack3.pack4 does not exist
/tmp/E/ $ javac -d . -cp /tmp/D/ Durga.java
/tmp/E/ $ ls
Durga.class Durga.java

/tmp/E/ $ java Durga
RE: NoClassDefFoundError: pack3/pack4/Saif
/tmp/E/ $ java -cp .:/tmp/D/ Durga
RE: NoClassDefFoundError: pack1/pack2/Kareena
/tmp/E/ $ java -cp .:/tmp/D/:/tmp/C/ Durga
Hello Saif! can you please set hellotune!
No, I cant!!
Hello! How I can help you?
```

##### Conclusion 1
If any location created because of package statement, that location should be
resolved by using import statement. And base package location we have to update
in classpath.

```shell
// in class file
import pack1.pack2.Kareena;
// while specifing classpath
/tmp/D/ $ javac -d . -cp /tmp/C/ Saif.java

```

##### Conclusion 2
Compiler will check only one level dependency, whereas JVM will check all levels
of dependency.

```shell
/tmp/E/ $ javac -d . -cp /tmp/D/ Durga.java
/tmp/E/ $ java -cp .:/tmp/D/:/tmp/C/ Durga
```

##### Conclusion 3
In classpath the order of location is important. JVM will always considered from
left to right until required match available.

```java
// /tmp/C/Navigable.java
public class Navigable {
  public static void main(String[] args) {
    System.out.println("C:navigable");
  }
}
```

```java
// /tmp/D/Navigable.java
public class Navigable {
  public static void main(String[] args) {
    System.out.println("D:navigable");
  }
}
```

```java
// /tmp/E/Navigable.java
public class Navigable {
  public static void main(String[] args) {
    System.out.println("E:navigable");
  }
}
```


```shell
$ java -cp /tmp/D/:/tmp/C/:/tmp/E/ Navigable
D:navigable
$ java -cp /tmp/E/:/tmp/D/:/tmp/C/ Navigable
E:navigable
```

## Jar
If several dependent class files are there, then it is not recommended to set
classpath indivually. 

Jar file is a group of class files.

```shell
java -cp /path1:/path2/:/path3/:/path4/ Test
# classpath is 1 KM
```
All third party software plugins are by default available in the form of jar
file only.

**Example1:**
To develop a servlet all dependent class files are available in servlet-api.jar.
WE have to place this jar file in classpath to compile a servlet program.

**Example2:**
To run a jdbc program, all dependent classes are available in ojdbc14.jar. To
run jdbc program we have to place this jar file in classpath.

**Example3:**
To use log4j in our application, dependent classes are available in log4j.jar.
We have to place this jar file in the classpath, then only log4j based
application can run.

### Various Commands related to Jar File (zip file)

- to create a jar file, c:create, v:verbose, f:jarfilename

```shell
$ jar -cvf selim.jar Test.class
$ jar -cvf selim.jar A.class B.class C.class
$ jar -cvf selim.jar *.class
$ jar -cvf selim.jar *.*
```

- to extract a Jar file (unzip), x:extract

```shell
$jar -xvf selim.jar
```

- to display table of contents, t: table

```shell
$ jar -tvf selim.jar
```

#### Service Provider's Role


```java
// /tmp/calc/ColorfulCalc.java
public class ColorfulCalc {
  public static void add(int x, int y) {
    System.out.println(x * y);
  }

  public static void multiply(int x, int y) {
    System.out.println(2 * x * y);
  }
}
```

```shell
/tmp/calc/ $ javac ColorfulCalc
/tmp/calc/ $ ls
ColorfulCalc.class  ColorfulCalc.java
/tmp/calc/ $ jar -cvf mycalc.jar ColorfulCalc.class
/tmp/calc/ $ ls
ColorfulCalc.class  ColorfulCalc.java  mycalc.jar
/tmp/calc/ $ jar -tvf mycalc.jar
META-INF
META-INF/MANIFEST.MF
ColorfulCalc.class
```

#### Client's Role
He downloaded jar file and placed in /tmp/jars.

```java
// /tmp/client/Calculator.java
public class Calculator {
  public static void main(String[] args) {
    ColorfulCalc.add(10, 20);
    ColorfulCalc.multiply(10, 20);
  }
}
```

```shell
/tmp/client/ $ javac Calculator.java
CE: cannot find symbol, symbol: variable ColorfulCalc, location: class Calculator

/tmp/client/ $ javac -cp /tmp/jars Calculator.java
CE: cannot find symbol, symbol: variable ColorfulCalc, location: class Calculator

## !!
/tmp/client/ $ javac -cp /tmp/jars/mycalc.jar Calculator.java

/tmp/client/ $ ls
Calculator.class Calculator.java

/tmp/client/ $ java Calculator
RE: NoClassDefFoundError: ColorfulCalc

/tmp/client/ $ java -cp /tmp/jars Calculator
Error: Could not find or load main class Calculator

/tmp/client/ $ java -cp .:/tmp/jars Calculator
RE: NoClassDefFoundError: ColorfulCalc

/tmp/client/ $ java -cp .:/tmp/jars/mycalc.jar Calculator
200
400
```

**NOTE:** To place .class file in classpath just location is enough. but to make
jar file available in classpath, location is not enough. Compalsory we have to
include name of the jar file also.

###### Short-cut way to place jar file in classpath
If we place jar file in the following location, then all classes and interfaces
present in the jar file by default available to java compiler and JVM. We are
not required to set classpath explicity.


```shell
--- JDK
     |--- JRE
           |--- lib
                 |--- ext (extension)
                       |--- *.jar
```

## System Properties
For every system some persisten information will be maintained in the form of
SystemProperties. These include the name of OS, Java version, JVM vendor, user
country etc.


```java
// demo program to print system properties
// SP.java
import java.util.*;

public class SP {
  public static void main(String[] args) {
    Properties p = System.getProperties();
    p.list(System.out);
  }
}
```

We can set system propery explicity from command prompt by using -D option.

```shell
$ java -Ddurga=ocjp SP
# -D option
# no space is allowed
# durga is system property name
# ocjp  is system property value
```

The main advantage of setting system property is, we can customize behavior of
java program.

```java
public class Test {
  public static void main(String[] args) {
    String course = System.getProperty("course");

    if (course.equals("scjp")) {
      System.out.println("scjp information");
    } else {
      System.out.println("other course information");
    }
  }
}
```


```shell
$ java -Dcourse=scjp Test
scjp information
$ java Test
other course information
$ java -Dcourse=xx Test
other course information
```

## Important VS

- jar vs war vs ear
- web application vs enterprise application
- web server and application server
- How to create an executable jar file
- In how many ways we can run a java program
- classpath vs path
- JDK vs JRE vs JVM
- java vs javaw javaws

### jar vs war vs ear

1. jar(java archieve): It contains a group of .class files.

2. war(web archieve): A war represents one web application, which contains
   servlets, JSPs, HTML pages, JS files etc. The main advantage of maintaining
   web application in a form of war file is, project deployment, project
   delivery and project transportation will be easier.

3. ear(enterprise archieve): An ear file represent one enterprise application,
   which contains servlets, JSPs, EJBs and JMS components etc.

**NOTE:**  In general ear file presents a group of war files and jar files.

### web application vs enterprise application
A web application can be developed by only web related technologies like
Servlets, JSP, HTML, JS, CSS, XML etc. Example: Online library management
system, Online shopping cart.

An enterprise application can be developed by any technology from Java to JEE
like Servlets, JSP, EJBs, JMS components etc. Example; banking application,
telecom based project.

**NOTE:** J2EE/JEE compatible application is enterprise application.

### web server vs application server
Web server provides environment to run web application, provide support for web
related technologies like servlet, JSP, HTML etc. Example: tomcat

Application server provides environment to run enterprise applications, can
provide support for any tehcnology from java to j2ee like servlets, jsp, ejb,
jms components etc. Example: Weblogic, Webshipher, JBoss etc.

**NOTE:** Every application server contains built-in web server to provide
support for web related technologies.(We could replace built-in web server).
J2EE compatible server is application server.

### How to create executable jar file


```java
// /tmp/gui/JarDemo.java
import java.awt.*;
import java.awt.event.*;

public class JarDemo {
  public static void main(String[] args) {
    Frame f = new Frame();
    f.addWindowListener( new WindowAdapter(){
      public void windowClosing(WindowEvent e) {
        for (int i=0; i<=10; i++) {
          System.out.println("I am closing window:" + i);
          System.exit(0);
        }
      }
    } );

    f.add(new Label("I can create executable jar file!"));
    f.setSize(500, 500);
    f.setVisible(true);
  }
}
```


```shell
$ javac JarDemo.java
$ ls
JarDemo$1.class JarDemo.class JarDemo.java
```

- We have to create a manifest file, which can be named anything. Each line has
  to end with new line character(enter).


```shell
// /tmp/gui/manifest.MF
Main-class: JarDemo

```


```shell
$ jar -cvfm demo.jar manifest.MF JarDemo.class JarDemo$1.class
# -m : specify manifest file
# order is important
```

- Run jar file from command line

```shell
$ java -jar demo.jar

# Even we can run jar file by double-clicking
```

### How many ways to run a Java program:
We can run a java program in the following ways:

1. From command prompt run .class file

```shell
$ java JarDemo
```

2. From command prompt run .jar file

```shell
$ java -jar JarDemo.jar
```

3. By double-clicking a jar file
4. By double-clicking a batch file

##### Batch File (Windows)
A batch file contains a group of commands. Wheneer we click a batch file, then
all commands will be executed one by one in sequence.


```shell
// abc.bat
java -cp /path/to/class/file Test
```

### classpath vs path

- **classpath**: describes the location where required .class files are available.
  Java compiler and JVM will use classpath to locate required class files. IF we
  are not setting classpath, then our program may not compile and may not run.

- **path**: describes the location where required binary executables are
  available. If we are not setting path, then javac and java commands wont work.


### JDK vs JRE vs JVM

- JDK(java development kit): JDK provides environment to develop and run java
  applications.

- JRE(java runtime environment): JRE provides environment to run Java
  application.

- JVM(java virtual machine): JVM is responsible to run java problem line by
  line. Hence it is an interpreter.


JDK = JRE + Development Tools
JRE = JVM + Library Classes

JVM is the part of JRE whereas JRE is part of JDK.

**NOTE:** On developer's machine we have to install JDK, whereas on the client
machine we have to install JRE.

### java vs javaw vs javaws

- **java**: We can use java command to run a java class file, where sout will be
  executed and corresponding output will be displayed to the console.

- **javaw**: java without console output. we can use javaw command to run a java
  class file, where sout will be executed but corresponding output wont be
  displayed to the console. In general we can use javaw command to run GUI based
  applications.

- **javaws**: (java web start utility) We can use javaws to download a java
  application from the web and to start its execution. can be used as follows:

```shell
$ javaws jnlp-url
```

It downloads the application from specified url and starts execution.

The main advantage in this approach is, every end user will get updated version
and enhancement will become easier because of centralized control.
