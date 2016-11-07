package selimssevgi;

import com.selimssevgi.Cafe;
import com.selimssevgi.Coffee;
import static com.selimssevgi.CoffeeType.Espresso;
import static com.selimssevgi.CoffeeType.Latte;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasProperty;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import org.hamcrest.Matchers;
import org.junit.*;

/**
 * Created by ssselim on 10/18/16.
 */
public class CafeTest {

  public static final int ESPRESSO_BEANS = Espresso.getRequiredBeans();
  public static final int NO_MILK = 0;
  private Cafe cafe;

  @Before
  public void before() {
    cafe = new Cafe();
  }

  @After
  public void after() {
    System.out.println("after");
  }

  @Test
  public void canBrewEspresso() {
    // given
    withBeans();

    // when
    Coffee coffee = cafe.brew(Espresso);

    // then
    assertEquals(Espresso, coffee.getType());
    assertEquals("Wrong number of milk", NO_MILK, coffee.getMilk());
    assertEquals("Wrong number of beans", ESPRESSO_BEANS, coffee.getBeans());
    // a better way with the help of hamcrest
    assertThat(coffee, hasProperty("beans", equalTo(ESPRESSO_BEANS)));
  }


  @Test
  public void brewingEspressoConsumesBeans() {
    // given
    withBeans();

    // when
    Coffee coffee = cafe.brew(Espresso);

    // then
    assertEquals(0, cafe.getBeansInStock());
  }

  // then
  @Test(expected = IllegalStateException.class)
  public void latteRequiresMilk() {
    // given
    withBeans();

    // when
    cafe.brew(Latte);
  }

  private void withBeans() {
    cafe.restockBeans(7);
  }
}
