# soap intro

- Simple Object Access Protocol
- microsoft originally developed SOAP in 1998
- W3C manages the specification

- Simple Object Access Protocol
- XML based industry standard protocal for web services
- platform and language indepenedent
- server and client could be implemented using different languages
- String in a java is different than the one in C++
- SOAP use XML based messages to overcome such differences

## WSDL

- Web Service Description Language
- XML based document
- interface of web services
- Provides technical details about the web service
- Some useful information in WSDL: method name, port types, end point, binding, parameters

## UDDI

- Universal Description, Discovery and Integration
- Is a directory of WS where client apps can lookup for Web Services
- Web Services can register to the UUDI server and make themselves available to client applications
- where are gonna find and look for WSDL?

## SEI

- Service Endpoint Interface
- Provides a way for the client application irrespective the technology to call the web service
- Conversion from Java or C++ string to SOAP message
- this is an automatic step
- can be generated from WSDL
