# Factory Pattern

- Constructor pattern

```shell
Abstract Factory
  - Concrete Factory
  - Concrete Factory

Abstract Type
  - Concrete Type
  - Concrete Type
```

- it lets us abstract away the contruction of some type so we don't need to use
  the name of that type directly in our code.


```shell
CameraLib:
  - CanonCamera
  - CanonCameraFactory
  - ICamera
  - ICameraFactory
  - NikonCamera
  - NikonCameraFactory
```

```java
public interface ICameraFactory {
  ICamera createCamera();
}

public interface NikonCameraFactory implements ICameraFactory {
  @Override
  public ICamera createCamera() { return new NikonCamera(); }
}

public interface CanonCameraFactory implements ICameraFactory {
  @Override
  public ICamera createCamera() { return new CanonCamera(); }
}
```

```java
psvm(String[] args) {
  ICameraFactory cameraFactory = new NikonCameraFactory();
  ICamera camera = cameraFactory.createCamera();

  camera.takePhoto();
}
```

- we hard-coded the name of factory in aboe code, we might want to configure that


```json
{
   "factoryType": "com.selimssevgi.NikonCameraFactory",
   "location": "file:///some-location.jar"
}
```


```java
psvm(String[] args) {
  Configuration conf = Configuration.load(args[0]);
  String location = conf.getLocation();
  URL url = new URL(location);
  URLClassLoader ucl = new URLClassLoader(new URL[]{ url });
  Class<ICameraFactory> cls = (Class<ICameraFactory>)
    Class.forName(configuration.getFactoryType(), true, ucl);

  ICameraFactory cameraFactory = cls.newInstance();
  ICamera camera = cameraFactory.createCamera();

  camera.takePhoto();
}
```

- Now we can simply change the configuration file, and the behavior of the
  application will change.
