import java.util.ResourceBundle;
/**
 *
 * resources/environment.properties
 * env = dev
 *
 * */

public class ResourceBundleTest {

  public String getName() {
    ResourceBundle resourcesBundle = ResourceBundle.getBundle("environment");
    return resourcesBundle.getString("env");
  }
}
