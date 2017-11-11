# Service First and Contract First

- Service first is known as "code first" as well

## Contract (Interface) First

- WSDL -> Java Code
- A throwaway java class can be written to a starting point as WSDL
- firstly write interface(WSDL), then WSDL will be locked
- then write implementation
- implementation can be changed without affecting service contract

- WSDL is the interface to the web service
- @WebService creates WSDL based on the class that it is applied

- If @WebService is applied to a concrete class, then WSDL will be generated from Service implementation

- If @WebService is applied to an interface, then WSDL will be generated from Contract (interface)


- Applying @WebService to an interface, gives much more flexibility

## Service First

- Java Code -> WSDL
