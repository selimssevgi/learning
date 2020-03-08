# packaging session and message-driven beans

- jee spec allows session and mdbs to be packaged in an ejb-jar module or war module

- when packaged in the ejb-jar module:
  - the beans will run in an full ejb container

- when packaged inside a war module
  - the beans will run in an ejb lite container

- ejb lite has most but not all of the features of a full ejb container

### packaging ejb-jar

- ejb-jar doesnt even need to include META-INF/ejb-jar.xml

- identified by ejb3 annotations or META-INF/ejb.jar.xml

### packaging ejb in war

- jee6 spec allows for sessions and mdbs to be included inside a WAR module
  instead of having to deploy them separately in an ejb-jar module

- when included in a war module, the beans run in the ejb lite container
