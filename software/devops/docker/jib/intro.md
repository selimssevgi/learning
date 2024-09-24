# jib

- https://circleci.com/blog/dockerizing-java-apps-with-circleci-and-jib/

- build and test locally

```shell
mvn clean compile com.google.cloud.tools:jib-maven-plugin:1.0.2:dockerBuild
```

- image name is artifactId:version by default
