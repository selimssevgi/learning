# XML Mapping Files

- It is not mandatory to declare one mapping file for one object, but is advised

- Trade.hbm.xml


```xml
<hibernate-mapping>
  <class name="com.selimssevgi.domain.Trade" table="TRADES">
    <id name="tradeId" column="TRADE_ID">
      <generator class="assigned"/>
    </id>
    <property name="quantity" column="QUANTITY" type="double" />
    <property name="security" column="SECURITY" type="string" />
  </class>
</hibernate-mapping>
```
