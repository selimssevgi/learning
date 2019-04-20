# spock.lang.Specification

- test classes must extends spock.lang.Specification

- contains useful helpers

- instruct JUnit to use Sputnik

## Fixture methods

- def setup() {}

- def cleanup() {}

- def setupSpec() {}

- def cleanupSpec() {}

## Fields

- not shared between feature methods

- use @Shared for expensive members

## Features

- this is where you write your tests

- feature declaration in String format

- code inside feature is separated by blocks
