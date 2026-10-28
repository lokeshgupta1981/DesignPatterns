# Bridge pattern example

Source code for the article https://howtodoinjava.com/design-patterns/structural/bridge-design-pattern/

The report type chooses the content. A renderer chooses plain text or HTML output. `BridgeDemo` runs all four combinations.

From the repository root:

```bash
javac -d out src/main/java/com/howtodoinjava/patterns/structural/bridge/BridgeDemo.java
java -cp out com.howtodoinjava.patterns.structural.bridge.BridgeDemo
```

The directory also retains the earlier file-downloader example used by the original article.
