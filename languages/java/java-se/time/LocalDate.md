# java.time.LocalDate

- stores year-month-day (12 september 2013)

- it includes nothing about time zones, time of day

- birthdays, start/end dates, holiday dates


### local date adjusters

- more complex alterations use adjusters
  - change date to the last day of month
  - change date to 3rd Friday of next month


```java
LocalDate date = LocalDate.now();
LocalDate date1 = LocalDate.of(2018, Month.APRIL, 23);
boolean after = date.isAfter(date1); // true
String dateStr = date.toString(); // 2019-04-09
System.out.println(dateStr);
System.out.println(date.isLeapYear());    // false
System.out.println(date.lengthOfMonth()); // 30
System.out.println(date.lengthOfYear());  // 365
System.out.println(date.plusMonths(3).minusDays(1)); // 2019-07-08
// with methods, instead of setters
System.out.println(date.withDayOfMonth(5));          // 2019-04-05
System.out.println(date.withMonth(10));              // 2019-10-09
System.out.println(date.with(Month.SEPTEMBER));      // 2019-09-09

System.out.println(date.with(TemporalAdjusters.lastDayOfMonth()));
System.out.println(date.with(TemporalAdjusters.next(DayOfWeek.THURSDAY)));
```
