# properties

- each instance of Project and Task provides properties that are accessible
  through getter and setter methods

## extra properties

- gradle allows defining user-defined variables through extra properties


```groovy
project.ext.myProp = 'myValue'

ext {
  someOtherProp = 123  
}

assert myProp == 'myValue'
println project.someOtherProp
ext.someOtherProp = 567
```

* additional properties can be fed through a properties file

## gradle.properties

- in $GRADLE_HOME
- or in project's root directory

- they can be accessed via the project instance

## project property

- via the -P command-line option

## system property

- via the -D command-line option

## environment property

- ORG_GRADLE_PROJECT_propertyName = someValue
