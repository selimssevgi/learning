# BDD with Spock

- even though spock is not full-featured BDD testing tool, still helps in that direction

- given:when:then: blocks

```groovy
class FireSensorSpec extends Specification {

    def "if all sensors are inactive, everything is ok"() {
        given: "that all sensors are inactive"
        FireEarlyWarning fireEarlyWarning = new FireEarlyWarning();
        int triggeredSensors = 0

        when: "we ask the status of the fire control"
        fireEarlyWarning.feedData(triggeredSensors)
        WarningStatus currentStatus = fireEarlyWarning.getCurrentStatus()

        then: "no alarm/notification should be alarmed"
        !currentStatus.alarmActive
        !currentStatus.fireDepartmentNotified
    }

    def "if one sensor is active, the alarm should sound as precaution"() {
        given: "that one sensor is active"
        FireEarlyWarning fireEarlyWarning = new FireEarlyWarning();
        int triggeredSensors = 1

        when: "we ask the status of the fire control"
        fireEarlyWarning.feedData(triggeredSensors)
        WarningStatus currentStatus = fireEarlyWarning.getCurrentStatus()

        then: "only the alarm should be triggered"
        currentStatus.alarmActive
        !currentStatus.fireDepartmentNotified
    }

    def "if more than one sensor is active, then we have a fire"() {
        given: "that two sensors is active"
        FireEarlyWarning fireEarlyWarning = new FireEarlyWarning();
        int triggeredSensors = 2

        when: "we ask the status of the fire control"
        fireEarlyWarning.feedData(triggeredSensors)
        WarningStatus currentStatus = fireEarlyWarning.getCurrentStatus()

        then: "alarm is triggered and fire department is notified"
        currentStatus.alarmActive
        currentStatus.fireDepartmentNotified

    }
}
```
