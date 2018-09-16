# @EnableAutoConfiguration

- Provides opiniated ways of configuring stuff.

- Spring Boot is not Spring Boot without Auto Configurations

- Makes most of its decisions based on conditions

* Presence/Absence of Jar
* Presence/Absence of Bean
* Presence/Absence of Property
* Many more.

## Auto-configuration reports

- Positive matches
- Negative matches
- Exclusions
- Unconditional classes

* Ways of enabling it:

```shell
# command line args: --debug
# VM args: -Ddebug
# environment var: export DEBUG=true
# application.properties: debug=true
# application.properties: logging.level.=debug
# intellij idea -> edit configuration -> 'Enable debug output'
```
