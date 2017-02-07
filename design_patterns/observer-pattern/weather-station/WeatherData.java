import java.util.ArrayList;

public class WeatherData implements Subject {
  private final ArrayList<Observer> observers;
  private float temperature;
  private float humidity;
  private float pressure;

  public WeatherData() {
    observers = new ArrayList<>();
  }

  @Override
  public void registerObserver(Observer observer) {
    observers.add(observer);
  }

  @Override
  public void removeObserver(Observer observer) {
    int i = observers.indexOf(observer);
    if (i >= 0) {
      observers.remove(observer);
    }
  }

  @Override
  public void notifyObservers() {
    for (Observer observer : observers) {
      observer.update(temperature, humidity, pressure);
    }
  }

  public void measurementsChanged() {
    notifyObservers();
  }

  // for testing
  public void setMeasurements(float temp, float hum, float pres) {
    temperature = temp;
    humidity = hum;
    pressure = pres;
    measurementsChanged();
  }
}
