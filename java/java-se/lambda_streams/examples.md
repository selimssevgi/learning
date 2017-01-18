# Refactoring Examples

```java
public static boolean isPrime(int number) {
//    boolean divisible = false;
//
//    for (int i=2; i<number; i++) {
//      if (number % i == 0)
//        divisible = true;
//        break;
//    }
//    return number > 1 && !divisible;

   return number > 1 &&
          IntStream.range(2, number)
          .noneMatch(i -> number % i == 0);
}
```


```java
public static void lineCounts() {
  try {
    String searchWord = "localhost";
    String path = "/etc/hosts";

//      long count = 0;
//      BufferedReader br = new BufferedReader(new FileReader(path));
//
//      String line = null;
//      while ((line = br.readLine()) != null) {
//        if (line.contains(searchWord))
//          count++;
//      }

    long count =
    Files.lines(Paths.get(path))
    .filter(line -> line.contains(searchWord))
    .count();

    System.out.printf("%s has word '%s' %d many times.", path, searchWord, count);
  } catch (IOException e) {
    e.printStackTrace();
  }
}
```

```java
public static Map<String, Integer> getScores() {
    Map<String, Integer> scores = new HashMap<>();
    scores.put("Jack", 12);
    scores.put("Jill", 15);
    scores.put("Tom", 11);
    scores.put("Darla", 15);
    scores.put("Nick", 15);
    scores.put("Nancy", 11);
    return scores;
}

private static Map<Integer, List<String>>
groupingByScores(Map<String, Integer> scores) {
  Map<Integer, List<String>> byScores = new HashMap<>();

//    for (String name : scores.keySet()) {
//      int score = scores.get(name);
//      List<String> names = new ArrayList<>();
//      if (byScores.containsKey(score))
//        names = byScores.get(score);
//
//      names.add(name);
//      byScores.put(score, names);
//    }

   return scores.keySet().stream()
   .collect(Collectors.groupingBy(scores::get));
 }
```
