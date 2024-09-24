public class CurrentConditionsDisplay implements Observer, DisplayElement {
  private float temperature;
  private float humidity;
  private Subject weatherData;

  public CurrentConditionsDisplay(Subject weatherData) {
    this.weatherData = weatherData;
    weatherData.registerObserver(this);
  }

  @Override
  public void update(float temp, float hum, float pres) {
    temperature = temp;
    humidity = hum;
    display();
  }

  @Override
  public void display() {
    System.out.println("Current conditions: " +
        temperature + "F degress and " +
        humidity + "% humidity.");
  }

}
