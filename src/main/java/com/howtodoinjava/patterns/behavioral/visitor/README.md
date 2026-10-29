# Visitor: document export and statistics

JDK 17 or later.

```shell
javac -d out src/main/java/com/howtodoinjava/patterns/behavioral/visitor/*.java
java -cp out com.howtodoinjava.patterns.behavioral.visitor.VisitorDemo
```

DocumentBlock implementations dispatch to the matching DocumentVisitor overload. TextExportVisitor builds plain text; StatisticsVisitor counts text UTF-16 code units and image blocks. Use fresh visitors for each document because they accumulate state. Traversal is performed by the client loop. Images carry descriptions only; no image file is loaded.

Article: https://howtodoinjava.com/design-patterns/behavioral/visitor-design-pattern-example-tutorial/
