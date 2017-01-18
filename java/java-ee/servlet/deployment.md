# Deployment Structure


```shell
- webapps
  |
  |--- MyApp
       |
       |--- <jsp-files>
       |--- <static-content>
       |--- META-INF
            |--- MANIFEST.MF
       |--- WEB-INF
            |
            |--- web.xml
            |--- classes
            |--- lib
            |--- tags
            |--- TLDs
```
- DD must be named "web.xml" and it must be immediately inside "WEB-INF".

### war Files

- A war file is a snapshot of your web app structure.
- It is jar file with extension of war.
- It is portable.
- Content under WEB-INF and META-INF cannot be accessed directly.

### MANIFEST.MF
In war file, you can declare library dependencies in META-INF/MANIFEST.MF, which
gives you a deploy-time check for whether the Container can find the packages
and classes your app depends on.

### Rules about servlet Mapping

1. It looks first for an exact match.
2. It looks for a directory match.
3. It looks for an extension match.
