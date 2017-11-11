# JAX-WS Annotations

## @WebService

- can be used on a concrete class asa the implementing web service
- can be used on an interface, in other words Service Endpoint interface

```java
@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface UserService {}

@WebService(endpointInterface="com.selimssevgi.service.UserService")
public class UserServiceImpl implements UserService {}
```

## @SOAPBinding(style = SOAPBinding.Style.RPC)

- used to specify the SOAP messaging 'style'
- can be either 'RPC' or 'DOCUMENT' (default)
- style represents the encoding style of message

- Affects the "types" elements in WSDL file

### DOCUMENT

- it is default value
- Creates a new xsd document for type definition, hence the new
- DOCUMENT style indicates that in the underlying message shall contain full XML documents
- can use complex types in java code

### RPC

- doesnt have much to do with RPC, it is just a style
- RPC style indicates that underlying message contains parameters and return values in req and res message
- With RPC style a WS is capable of only using simple data types

- "use" has to values as "LITERAL" and "ENCODED"
- "ENCODED" is not standard to no really necessary to use it

## @WebMethod

- can be applied over a method only
- method represents a web service operation

- has "excluded" parameters not to include a method in WSDL

## @WebParam

- in WSDL parameters are named arg0, arg1 etc
- can modify it by using WebParam annotation
- method(@WebParam(partName="lookupInput"))

## @WebResult

- to modify return type name in WSDL
- it is used over a method definition
- @WebResult(partName="lookupOutput")
