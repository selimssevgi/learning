# Annotation

## @Expose

- Optional annotation to annotate which field we dont want to include
- Annotation itself is not enough, we have to set parameters to false explicitly.
- Even that would not be enough, a custom Gson object is needed to used
- transient could be used to exclude a field for two ways.
- @Exclude annotation gives control for both ways.

```java
@Expose
String name;

@Expose(serialize = false)
String middleName;

@Expose(deserialize = false)
String surname;

GsonBuilder gBuilder = new GsonBuilder();
gBuilder.excludeFieldsWithoutExposeAnnotation();
Gson gson1 = gBuilder.create();

```

## @SerializedName

- A way to deal naming differences, for both de/serialization

```java
@SerializedName("fullName")
String name;
```
