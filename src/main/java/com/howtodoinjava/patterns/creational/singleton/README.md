# Singleton example

Source code for the article [Singleton Design Pattern in Java](https://howtodoinjava.com/design-patterns/creational/singleton-design-pattern-in-java/).

The example uses only the Java standard library. From the repository root:

```bash
javac -d out src/main/java/com/howtodoinjava/patterns/creational/singleton/*.java
java -cp out com.howtodoinjava.patterns.creational.singleton.SingletonDemo
```

The same commands work with a current JDK. The program checks that each variant returns one shared instance and assigns consecutive order numbers through two references. Each variant has its own sequence, which starts at 1 on each run. These in-memory numbers are for demonstrating the pattern; they are not durable or unique across JVM processes.
