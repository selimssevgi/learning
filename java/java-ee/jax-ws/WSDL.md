# WSDL

- WSDL can be thought in same sense of a Java interface
- package, interface name, method, parameters, return types

- Service
  - Port
  - Binding
    - PortType
      - Operations
        - Input Message
        - Output Message
          - Types

## Types

- types element in WSDL can be tought as non-builtin types, like user types
- it has definition of these types imported in WSDL

```java
MyDataType add(MyDataType a, MyDataType b)
```

## Operation

- are method in the interface
- has a name, input and output
- even if there are more than one parameters in definition of a method, there is
  only one input element in WSDL for an operation

- the reason is that operation takes one SOAP message as input, and another for output
- multiple parameters are encoded in a single SOAP message

## Binding

- information about how service accepts request
