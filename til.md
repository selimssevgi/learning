# til - today i learned

## 09/01/20

- cannot easily use cxf for client factory in jee/liberty environment
- even adding compileOnly does not work at runtime
- liberty hides them from you so they will swap the implementation as they want
- solution: remove jax-ws feature, add your own cxf in your project
- how about server?

"You either need to include your own version of JAX-WS with all the required
libraries, or allow Liberty to do this for you without the need to include your
own CXF."

https://developer.ibm.com/answers/questions/455069/websphere-liberty-deployed-applications-failed-to/

1. how to call https service on postman, turn off ssl verification

2. SoapFault: transaction not authorized
  - given user/pass is wrong
  - or the url wrong, hitting production?

## 10/01/20

- override wsdl location on @WebServiceClient so it is relative
- otherwise in deployment, it will have the path of build server and it wont find the wsdl

```java
wsdl2java {
  generatedWsdlDir = file("${project.projectDir.path}/src/main/generated")
  wsdlDir = file("${project.projectDir.path}/src/main/resources/META-INF/wsdl")
  wsdlsToGenerate = [
    [
      '-wsdlLocation', 'META-INF/wsdl/NonfOrderLegacyRetSvcV1.wsdl',
      "$wsdlDir/NonfOrderLegacyRetSvcV1.wsdl"],
  ]
}
```

## 14/01/20

- faces-config.xml is needed for deployment script to know this is a new stack
  application, and use webservice and jms properties

## 20/01/20

- The activate method has thrown an exception Bundle:com.ibm.ws.jca(id=80) java.lang.IllegalArgumentException:
  CWSJY0034E: Unable to load classes from the WebSphere MQ resource adapter at
  location /Users/ssr24if/IdeaProjects/csorchmw/local-libs/wmq.jmsra.rar which
  is specified by the *wmqJmsClient.rar.location* variable. Verify that the
  WebSphere MQ resource adapter file is accessible at this location. 

- ComponentManager registers components

- ibm jms error messages are:
  - https://www.ibm.com/support/knowledgecenter/en/SSFKSJ_7.5.0/com.ibm.mq.javadoc.doc/WMQJMSClasses/errorcodes.html

- ComponentManager is initialized once

- ComponentManager#findComponents:82:418
  - ClassLoader threadContextClassloader = Thread.currentThread().getContextClassLoader();
  - in native lib(c++) it will cause problems but that thread may not have contextClassLoader
  - NPE exception will cause components not to be registered even though they are there

- better to make a call in application thread so ComponentManager will register
  all components, and later calls will just use those components


