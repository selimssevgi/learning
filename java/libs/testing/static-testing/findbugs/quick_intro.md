# FindBugs

- It look at the byte codes
- It can find error that source based tool(pmd) cannot find

## Installation

- http://findbugs.sourceforge.net/
- Download and unzip it
- chmod +x findbugs-x.x.x/bin/\*
- EXPORT FINDBUGS_HOME="/path/to/findbugs-x.x.x"

## Usage of GUI

- $ findbugs
- Resize gui elements to see more of things
- New Project (resize)
- Add classpath: /target/classes
- add source: /src/main/java

## Usage of FindBugs with Maven

- findbugs-maven-plugin
- mvn clean compile findbugs:check package

## Read Bug Descriptions

- http://findbugs.sourceforge.net/ -> Bug Descriptions(onleft)
