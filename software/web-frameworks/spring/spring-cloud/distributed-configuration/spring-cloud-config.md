# Spring Cloud Config

- provides server and client-side support for externalized configuration in a distributed system.

## Config Client

- Embedded in application
- Spring 'Environment' abstract

## Config Server

- Standalone (can be embedded)
- Spring 'PropertySource' abstraction (classpath:file.properties)

## As a configuration server impelementation

- HTTP REST access

- Output formats: JSON(default), Properties, YAML

- Backend stores: Git(default), SVN, Filesystem

- Configuration scopes
