import java.util.Observable;
import java.util.Observer;

public class WeatherData extends Observable {
  private float temperature;
  private float humidity;
  private float pressure;

  public WeatherData() {}

  public void measurementsChanged() {
    setChanged();
    notifyObservers(); // not sending any data, PULL model
  }

  // for testing
  public void setMeasurements(float temp, float hum, float pres) {
    temperature = temp;
    humidity = hum;
    pressure = pres;
    measurementsChanged();
  }

  // PULL model, methods for pulling data

  public float getTemperature() {
    return temperature;
  }

  public float getHumidity() {
  return humidity;
  }
  public float getPressure() {
  return pressure;
  }
}
