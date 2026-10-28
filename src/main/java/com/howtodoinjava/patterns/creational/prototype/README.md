# Prototype demo

Source code for the article [Prototype Design Pattern in Java](https://howtodoinjava.com/design-patterns/creational/prototype-design-pattern-in-java/).

From the repository root:

```bash
javac -d target/prototype-demo src/main/java/com/howtodoinjava/patterns/creational/prototype/PrototypeDemo.java
java -cp target/prototype-demo com.howtodoinjava.patterns.creational.prototype.PrototypeDemo
```

`Movie.copy()` makes a new tag list. `ShallowMovie.copy()` intentionally shares its list to demonstrate the copying bug; do not use it for independently editable copies.
