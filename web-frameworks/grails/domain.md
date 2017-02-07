# Grails Domain


```shell
$ grails create-domain-class org.packagename.DomainName
# it creates Domain class and Spec class for it
```


```groovy
static constraints = {
    year  min: 1900
    name  maxSize: 255
    make  inList: ['Ford', 'Chevrolet', 'Nissan']
    model nullable: true
}
```
