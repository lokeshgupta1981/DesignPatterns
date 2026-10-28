# Flyweight pattern: shared pens

Source code for the article [Flyweight Design Pattern in Java](https://howtodoinjava.com/design-patterns/structural/flyweight-design-pattern/).

The factory stores one immutable `Pen` per `BrushSize`. A drawing call supplies its color and content without changing the shared pen. The cache belongs to a factory instance.

From the repository root:

```bash
javac -d target/flyweight-demo -sourcepath src/main/java src/main/java/com/howtodoinjava/patterns/structural/flyweight/FlyweightDemo.java
java -cp target/flyweight-demo com.howtodoinjava.patterns.structural.flyweight.FlyweightDemo
```

Expected output:

```text
THIN BLUE Hello
THIN RED World
Same size reuses a pen: true
Different size reuses a pen: false
Separate factories share a pen: false
```
