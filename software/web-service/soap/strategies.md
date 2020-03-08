# ws strategies

1. contract first (wsdl)
2. service first (jax-ws annotations)
3. wsdl and code both by hand

- Service first is known as "code first" as well

## Contract (Interface) First

- WSDL -> Java Code
- A throwaway java class can be written to a starting point as WSDL
- firstly write interface(WSDL), then WSDL will be locked
- then write implementation
- implementation can be changed without affecting service contract

- WSDL is the interface to the web service

## Service First

- Java Code -> WSDL

- generated wsdl may not be optimal and might not be portable across languages

## both

- well-written wsdl
- clean java code

- for services targeted at other languages and platform with a long-term life expectancy
