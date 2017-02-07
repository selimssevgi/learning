import java.util.Observer;
import java.util.Observable;

public class ForecastDisplay implements Observer, DisplayElement {
  private float currentPressure = 29.92f;
  private float lastPressure;
  private Observable observable;

  public ForecastDisplay(Observable observable) {
    this.observable = observable;
    observable.addObserver(this);
  }

  @Override
  public void update(Observable ob, Object arg) {
    if (ob instanceof WeatherData) {
      WeatherData wd = (WeatherData) ob;
      lastPressure = currentPressure;
      currentPressure = wd.getPressure();
      display();
    }
  }

  @Override
  public void display() {
    System.out.println("Forecast: " +
        "Current Pressure: " + currentPressure +
        "Last Pressure: " + lastPressure);
  }

}
