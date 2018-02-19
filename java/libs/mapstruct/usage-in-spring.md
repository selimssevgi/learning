# Mapstruct in Spring (Boot)

- Add client side annotation as dependency

- Add annotation-preprocessor in maven-compiler-plugin


```java
@Mapper(componentModel = "spring")
public interface CarMapper {
  // do not add INSTANCE with DI
  CarDto toCarDto(Car car);
  Car toCar(CarDto carDto);
}

// injection
public class XyzService {
  @AutoWired
  private CarMapper carMapper;
}
```

- May need to enable "annotation pre-processor" in Idea Settings -> Compiler
