package selimssevgi;

import org.hamcrest.Matchers;
import org.junit.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by ssselim on 10/18/16.
 */
public class HamcrestExampleTest {

  @Test
  public void mapShouldContainValue() {
    Map<String, Integer> values = getValues();
    // following doesnt give a good diagnostic message
    // Assert.assertTrue(values.containsKey("B"));

    Assert.assertThat(values, Matchers.hasKey("B"));
  }

  private Map<String,Integer> getValues() {
    final HashMap<String, Integer> map = new HashMap<String, Integer>();
    map.put("A", 1);
    map.put("b", 2);
    // fix error
    map.put("B", 3);
    return map;
  }

  @Test
  public void listOrderingIsIrrelevant() {
    List<Integer> numbers = getNumbers();

//    Assert.assertEquals(5, (int) numbers.get(4));
    Assert.assertThat(numbers, Matchers.hasItem(5));
  }

  private List<Integer> getNumbers() {
    return Arrays.asList(1, 2, 3, 5, 4);
  }
}
