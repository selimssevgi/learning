# Mocking/Stubbing with Spock

- A *stub* is a fake class that comes with preprogrammed return values. It is
  injected in the class under test so that you have absolute control of what is
  being tested as input.

- A *mock* is a fake class that can be examined after the test is finished for
  its interactions with the class under test.(how many times a method is called)

```groovy
class CoolantSensorSpec extends Specification {

    def "if current temp diff is within the limit, everything is ok"() {
        given: "that temp readings are in limit"
        def previous =
                new TemperatureReadings(sensor1Data: 20, sensor2Data: 40, sensor3Data: 80)
        def current =
                new TemperatureReadings(sensor1Data: 30, sensor2Data: 45, sensor3Data: 73)

        // Spock creates a dummy implementation
        TemperatureReader reader = Stub(TemperatureReader)
        // return previous value in first invocation,
        // and current for the second invocation
        reader.getCurrentReadings() >>> [previous, current] // groovy support operator overloading

        def monitor = new TemperatureMonitor(reader)

        when: "we ask the status of temp control"
        monitor.readSensor()
        monitor.readSensor()

        then: "everything is okay"
        monitor.isTemperatureNormal()
    }

    def "if current temp diff is more than 20 degrees, then the alarm should sound"() {
        given: "that temp readings are out of limit"
        def previous =
                new TemperatureReadings(sensor1Data: 20, sensor2Data: 40, sensor3Data: 80)
        def current =
                new TemperatureReadings(sensor1Data: 50, sensor2Data: 65, sensor3Data: 103)


        TemperatureReader reader = Stub(TemperatureReader)
        reader.getCurrentReadings() >>> [previous, current]

        ReactorControl reactorControl = Mock(ReactorControl)

        def monitor = new ImprovedTemperatureMonitor(reader, reactorControl)

        when: "we ask the status of temp control"
        monitor.readSensor()
        monitor.readSensor()

        then: "the alarm should sound"
        0 * reactorControl.shutdownReactor() // zero interaction
        1 * reactorControl.activateAlarm()   // one interaction
    }
}

```
