# Singleton Pattern Example from Spring Source Code

- org.springframework.boot.convert.ApplicationConversionService#getSharedInstance()

```java
/**
 * Return a shared default application {@code ConversionService} instance, lazily
 * building it once needed.
 * <p>
 * Note: This method actually returns an {@link ApplicationConversionService}
 * instance. However, the {@code ConversionService} signature has been preserved for
 * binary compatibility.
 * @return the shared {@code ApplicationConversionService} instance (never
 * {@code null})
 */
public static ConversionService getSharedInstance() {
  ApplicationConversionService sharedInstance = ApplicationConversionService.sharedInstance;
  if (sharedInstance == null) {
    synchronized (ApplicationConversionService.class) {
      sharedInstance = ApplicationConversionService.sharedInstance;
      if (sharedInstance == null) {
        sharedInstance = new ApplicationConversionService();
        ApplicationConversionService.sharedInstance = sharedInstance;
      }
    }
  }
  return sharedInstance;
}
```
