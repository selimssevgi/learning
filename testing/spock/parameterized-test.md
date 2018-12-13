# Parameterized Tests in Spock

- less verbose and maintainable than JUnit parameterized tests

- given:when:then:where

```groovy
class NuclearReactorSpec extends Specification {

    def "complete tests of all nuclear scenarios"() {
        given:
        NuclearReactorMonitor nuclearReactorMonitor =
                new NuclearReactorMonitor()

        when: "we examine the sensor data"
        nuclearReactorMonitor.feedFireSensorData(fireSensors)
        nuclearReactorMonitor.feedRadiationSensorData(radiation)
        nuclearReactorMonitor.feedPressureInBar(pressure)
        NuclearReactorStatus nuclearReactorStatus =
                nuclearReactorMonitor.getCurrentStatus()

        then: "we act according to safety requirements"
        nuclearReactorStatus.alarmActive == alarm
        nuclearReactorStatus.shutDownNeeded == shutDown
        nuclearReactorStatus.evacuationMinutes == evacuation

        where: "possible nuclear incidents are:"
        pressure | fireSensors | radiation             || alarm | shutDown | evacuation
        150      | 1           | []                    || false | false    | -1
        150      | 1           | []                    || true  | false    | -1
        150      | 3           | []                    || true  | true     | -1
        150      | 0           | [110.4f ,0.3f, 0.0f]  || true  | true     | 1
        150      | 0           | [45.3f ,10.3f, 47.7f] || false | false    | -1
        155      | 0           | [0.0f ,0.0f, 0.0f]    || true  | false    | -1
        170      | 0           | [0.0f ,0.0f, 0.0f]    || true  | true     | 3
        180      | 0           | [110.4f ,0.3f, 0.0f]  || true  | true     | 1
        500      | 0           | [110.4f ,300f, 0.0f]  || true  | true     | 1
        30       | 0           | [110.4f ,1000f, 0.0f] || true  | true     | 1
        155      | 4           | [0.0f ,0.0f, 0.0f]    || true  | true     | -1
        170      | 1           | [45.3f ,10.3f, 47.7f] || true  | true     | 3
    }
}

```
