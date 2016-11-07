package leveluptuts;

import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by ssselim on 9/19/16.
 */
public class StateTest {
  List<State> states;

  @Before
  public void setUp() {

    states = new ArrayList<>();

    states.add(new State("WI", "Wisconsin", "MDW", 5726398));
    states.add(new State("FL", "Florida", "SE", 19317568));
    states.add(new State("IA", "Iowa", "MDW", 3078186));
    states.add(new State("CA", "California", "W", 38041430));
    states.add(new State("NY", "New York", "NE", 19570261));
    states.add(new State("CO", "Colorado", "W", 5187582));
    states.add(new State("OH", "Ohio", "MDW", 11544225));
    states.add(new State("ME", "Maine", "NE", 1329192));
    states.add(new State("SD", "South Dakota", "MDW", 833354));
    states.add(new State("TN", "Tennessee", "SE", 6456243));
    states.add(new State("OR", "Oregon", "W", 3899353));
  }

  @Test
  public void get_mdw_traditional() {
    List<State> mdwStates = new ArrayList<>();

    for (State state:states) {
      // filtering
      if (state.getRegionCode().equals("MDW")) {
        mdwStates.add(state);
      }
      System.out.println(mdwStates);
    }
  }


  @Test
  public void get_mdw_states_with_guava() {
    Collection<State> mdwStates = Collections2
            // filter can be moved in a class
            .filter(states, state -> state.getRegionCode().equals("MDW"));

    System.out.println(mdwStates);
  }















}
