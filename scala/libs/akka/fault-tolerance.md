# Fault Torelarance

- Akka encourages nondefensive programming

- failure is a valid state in the lifecycle of an application

- you cannot prevent every error, better to prepare your application for errors

- Akka provides fault-tolerance support through the supervisor hierarchy

- the responsibility of a supervisor is to start, stop, and monitor child actors

- it is hard to build a fault-tolerant system with one box

- spread supervisor hierarchy across multiple machines

- supervision strategies in akka:
  1. One-for-One
  2. All-for-One

- by default, each actor has one supervisor, which also parent actor

- when no supervisor strategy defined, it uses the default strategy(OneForOne)

## One-for-One

- if one actor dies, it's recreated

- it is a great strategy if actors are independent in the system

## All-for-One

- all actors supervised by a supervisor are restarted when one of them dies


```scala
class AActor extends Actor {
  override val supervisorStrategy = AllForOneStrategy() {
    case _ : Exception => println("Restarting...") ; Restart
  }

  // or
  override val supervisorStrategy = AllForOneStrategy(nmbrOfRetries = 3,
  withinTimeRange = 5 seconds) {
    case _ : Exception => Restart  
  }
}
```


