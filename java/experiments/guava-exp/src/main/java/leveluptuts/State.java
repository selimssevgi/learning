package leveluptuts;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;

/**
 * Created by ssselim on 9/19/16.
 */
public class State {
  private String stateCode;
  private String name;
  private String regionCode;
  private int population;

  public State(String stateCode, String name, String regionCode, int population) {
    this.stateCode = stateCode;
    this.name = name;
    this.regionCode = regionCode;
    this.population = population;
  }

  public String getStateCode() {
    return stateCode;
  }

  public void setStateCode(String stateCode) {
    this.stateCode = stateCode;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getRegionCode() {
    return regionCode;
  }

  public void setRegionCode(String regionCode) {
    this.regionCode = regionCode;
  }

  public int getPopulation() {
    return population;
  }

  public void setPopulation(int population) {
    this.population = population;
  }

  @Override
  public String toString() {
    Preconditions
    return MoreObjects.toStringHelper(this)
            .add("stateCode", stateCode)
            .add("name", name)
            .toString();
  }
}
