# Grails Command Line Utility

## Create project

```shell
$ grails create-app com.packagename.myAppName # default profile 'web'
$ grails create-app com.packagename.myAppName -profile rest-api
```

## Run application

```shell
# start the application on localhost:8080
$ grails run-app

$ grails run-app --port=8090
```

## Create domain object

```shell
$ grails create-domain-class org.packagename.DomainName
```

## Create Controller

```shell
# grails adds *Controller suffix
$ grails create-controller org.packagename.DomainName # for Which Domain?
```
