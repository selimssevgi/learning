import java.util.Observer;
import java.util.Observable;

public class CurrentConditionsDisplay implements Observer, DisplayElement {
  private float temperature;
  private float humidity;
  private Observable observable;

  public CurrentConditionsDisplay(Observable observable) {
    this.observable = observable;
    observable.addObserver(this);
  }

  @Override
  public void update(Observable ob, Object arg) {
    if (ob instanceof WeatherData) {
      WeatherData weatherData = (WeatherData) ob;
      temperature = weatherData.getTemperature();
      humidity = weatherData.getHumidity();
      display();
    }
  }

  @Override
  public void display() {
    System.out.println("Current conditions: " +
        temperature + "F degress and " +
        humidity + "% humidity.");
  }

}
