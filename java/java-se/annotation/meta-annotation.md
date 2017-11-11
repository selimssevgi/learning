# Meta Annotations

- Annotations that apply to other annotations are called meta-annotations
- several are defined in java.lang.annotation

## @Retention

- specifies how the marked annotation is stored

- RetentionPolicy.SOURCE   - retained only in the source, is ignored by compiler
- RetentionPolicy.CLASS    - retained by the compiler at compile time, ignored by JVM
- RetentionPolicy.RUNTIME  - retained by JVM, so can be used by rt environment

## @Target

- restrict what kind of Java elements the annotation can be applied to

- ElementType.ANNOTATION_TYPE     - can be applied to an annotation type
- ElementType.CONSTRUCTOR         -
- ElementType.FIELD               - 
- ElementType.LOCAL_VARIABLE      -
- ElementType.METHOD              -
- ElementType.PACKAGE             -
- ElementType.PARAMETER           -
- ElementType.TYPE                - can be applied to any element of a class

## @Documented

- include annotations in javadoc

## @Inherited

- indicated that the annotation type can be inherited from the super class

## @Repeatable

- introduced in Java SE 8
- indicates that the marked annotation can be applied more than once to the same
  declaration or type use
