# JDBC Driver Types

### Type 1: JDBC-ODBC Bridge Driver
JDBC bridge is used to access ODBC drivers installed on each client machine.

The type 1 driver is not considered a deployment-level driver, and is typically
used for development and testing purposes only.

### Type 2: JDBC-Native API
JDBC API calls are converted into native C/C++ API calls, which are unique to
the database.

Type 2 drivers are useful in situations, where a type 3 or type 4 driver is not
available yet for your database.

### Type 3: JDBC-Net pure Java
If your Java Application is accessiong multiple types of databases at the same
time, type 3 is the preferred driver.

#### Type 4: 100% Pure Java
a pure Java-based driver communicates directly with the vendors database
through socket connection. This is the highest performance driver available for
the database and is usually provided by the vendor itself.

If you are accessing one type of database, such as Oracle, Sybase, the preferred
driver type is 4.
