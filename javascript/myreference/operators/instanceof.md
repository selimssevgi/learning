# instanceof

- When you have Car and Dog objects, typeof will not help you identify them

- typeof operator will return 'object' for both of them, cus they are objects

- In JS, objects are dynamic structures, and the type of all objects is just 'object'


```javascript
if (cadi instanceof Car) { // returns true if cadi object is created using Car constructor
}
```

- 'new' operator stores the information of the constructor that it uses in that object

*NOTE:*  instanceof doesnot just look at what kind of object you are, it also
takes into account all the objects you inherit from
