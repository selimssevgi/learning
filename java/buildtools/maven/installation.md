# Maven Installation

- http://maven.apache.org/

- sdk man

## Steps

```shell
$ tar xvf apache-maven*
$ sudo mv <untar maven path> /usr/local/maven

# set M2_HOME pointing untar
# export M2_HOME=/usr/local/maven

# set M2 pointing maven bin
# export M2=$M2_HOME/bin

# add M2 to your path
# export PATH=$PATH:$M2

# test maven install
$ mvn -version
```
