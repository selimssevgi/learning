# Installation

- Download from the official website

- Unzip and run the following command

```shell
$SONAR_HOME/bin/linux-x86-64/sonar.sh start
```

- It will start using in-memory database on localhost:9000

- It may use elasticsearch instance which will not be run as root

- Start sonarqube as normal user process

```shell
mvn sonar:sonar \
      -Dsonar.organization=todarch \
      -Dsonar.host.url=https://sonarcloud.io \
      -Dsonar.login=<token-from-sonarqube>
```
