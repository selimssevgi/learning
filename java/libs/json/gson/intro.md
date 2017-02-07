# Gson

- Java model classes from Json: http://www.jsonschema2pojo.org/

## Basic Object

```java
User user = new User("selim", 25, true);

Gson gson = new Gson();
String userJson = gson.toJson(user);

System.out.println(userJson);
// {"name":"selim","age":25,"isDeveloper":true}


String testJson
        = "{\"name\":\"ahmet\",\"age\":30,\"isDeveloper\":false}";
User anotherUser = gson.fromJson(testJson, User.class);
System.out.println(anotherUser);
// User{name='ahmet', age=30, isDeveloper=false}
```

## Nested Objects

```java
// public Address(String street, String city, String country)
// User(String name, int age, boolean isDeveloper, Address address)

{
  "name":"selim",
  "age":25,
  "isDeveloper":true,

  "address": {
    "street":"21",
    "city":"Istanbul",
    "country":"Turkey"
  }
}
```

## List or Array of Objects

```shell
// BasicUser(String name, int age)
// Company(String name, List<BasicUser> people)
{
  "name":"ACompany",
  "people":[
    {"name":"Selim","age":25},
    {"name":"Ahmet","age":15}
  ]
}
```

```java
// to Array
BasicUser[] people = gson.fromJson(theJsonString, BasicUser[].class);

// to List
Type peopleListType = new TypeToken<ArrayList<BasicUser>>(){}.getType();
List<BasicUser> myPeople = gson.fromJson(peopleJsonArr, peopleListType);
```

## Map


```java
// AmountWithCurrency(String currency, int amount)
String dollarJson = "{ '1$': { 'amount': 1, 'currency': 'Dollar'}, +
                       '2$': { 'amount': 2, 'currency': 'Dollar'}, +
                       '3€': { 'amount': 3, 'currency': 'Euro'} }";

Type amountCurrencyType =
    new TypeToken<HashMap<String, AmountWithCurrency>>(){}.getType();

HashMap<String, AmountWithCurrency> amountCurrency =
    gson.fromJson(dollarJson, amountCurrencyType);

```

## null

- Gson doesnot include JSON values for null.
- While deserializing Gson will populate the fields in hands, leave them others
  fields in their default values.(0, false, null)

```java
// BasicUser(String name, int age)
BasicUser buser = new BasicUser(null, 25);
System.out.println(gson.toJson(buser)); // {"age":25}
```
