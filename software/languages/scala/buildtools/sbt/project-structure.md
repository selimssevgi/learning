# Project Structure for SBT

1. there are multiple ways to create your project structure


```shell
mkdir -p src/{main,test}/{scala,java,resources} lib project
```

2. A SBT plugin can also be used to create new project, see plugin.md

3. giter8 is a command-line tool to generate files and dirs from templates published in Github


```shell
sbt-project structure
  - build.sbt                    # build definition
  - lib                          # unmanaged dependencies
  - project
    - build.properties           # SBT properties
    - build.scala                # build definition
    - plugin.sbt                 # SBT plugins
    - project                    # SBT project output
  - src
    - main
      - java
      - resources
      - scala
    -test
      - java
      - resources
      - scala
  -target
```

