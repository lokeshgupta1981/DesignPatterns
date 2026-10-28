# Facade: report generation

`FacadeDemo.java` contains a small report workflow. `ReportGeneratorFacade` coordinates a data source, formatter, and file writer. The demo reads back a generated file and then shows that a write failure reaches the caller.

From the repository root:

```bash
javac -d out src/main/java/com/howtodoinjava/patterns/structural/facade/FacadeDemo.java
java -cp out com.howtodoinjava.patterns.structural.facade.FacadeDemo
```
