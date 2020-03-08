# java enterprise edition history

- java 2 platform, enterprise edition (J2EE)
- java enterprise edition (JEE)
- Jakarta EE

## history

- J2EE 1.2 (1999)
- J2EE 1.3 (2001)
- J2EE 1.4 (2003)
- JEE 5 (2006)
- JEE 6 (2009)
- JEE 7 (2013)
- JEE 8 (2017)
- Jakarta EE 8 (2019)

### version matrix

api     | jee6 | jee7 | jee8 
------------------------------
servlet | 3.0  | 3.1  | 4.0
jax-rs  | 1.1  | 2.0  | 2.1
jax-ws  | 2.2  | 
ejb     | 3.1  | 3.2  | 3.2
cdi     | 1.0  | 1.1  | 2.0
di      | 1.0  | 1.0  | 1.0
jpa     | 2.0  | 2.1  | 2.2
jms     | 1.1  | 2.0
jta     | 1.1  | 1.2  | 1.2

### deployment descriptor

api     | jee6 | jee7 | jee8 | file
-------------------------------------
ear     | OPT  | OPT  | OPT  | application.xml
servlet | 3.0  | 3.1  | 4.0  | 
ejb     | OPT  | 3.2  | 3.2  | ejb-jar.xml
cdi     | 1.0  | OPT  | 2.0  | beans.xml
