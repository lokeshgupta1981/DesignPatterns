# Observer demo

`MessagePublisher` notifies registered `MessageListener` objects in registration order. The `OneTimeListener` removes itself during the first callback. A snapshot of the listener set keeps the current notification stable while the next one reflects the removal.

From the repository root:

```bash
javac -d target/observer-demo src/main/java/com/howtodoinjava/patterns/behavioral/observer/ObserverDemo.java
java -cp target/observer-demo com.howtodoinjava.patterns.behavioral.observer.ObserverDemo
```

Output:

```text
Alex received: First message
Brian received: First message
Brian received: Second message
```

The callbacks run synchronously on one thread. The publisher is not safe for concurrent modification without further coordination.
