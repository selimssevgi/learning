# discovery (beans.xml)

- in java ee, each specification has an optional xml deployment descriptor

- with cdi, deployment descriptor is META-INF/beans.xml, is optional

- it can be used for bean discovery

```xml
<beans bean-discovery-mode="all">
</beans>
```

- "all" -- all POJO will be cdi beans
- "none"
- "annotated" (default)

*NOTE:* ejb session beans are an exception to bean discovery mechanism as they
are always discovered as cdi beans (unless explicitly excluded)

- beans.xml should be placed where the classes and libs will be

*NOTE:* cdi interceptors should be placed in beans.xml
