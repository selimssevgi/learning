# today i learned


## Mon Aug  9 11:47:03 CEST 2021

- spring boot rest json accepting date
  - spring.jackson.date-format did not work
  - @JsonFormat did not work
  - DateTimeFormat did not work

- accept as a string and do the conversion yourself


```shell
    public LocalDateTime setStartDateTime() {
        if (startDateTime != null) {
            return LocalDateTime.parse(startDateTime, DateTimeFormatter.ISO_DATE_TIME);
        }
        return null;
    }
```
