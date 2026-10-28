# Template Method: shipping quotes

JDK 17 or later. Rates are illustrative currency units, not carrier tariffs.

```shell
javac -d out src/main/java/com/howtodoinjava/patterns/behavioral/templatemethod/*.java
java -cp out com.howtodoinjava.patterns.behavioral.templatemethod.TemplateMethodDemo
```

The final quote operation validates, calculates a base charge, calls an optional surcharge hook and rounds the result. Standard shipping inherits the zero surcharge; express shipping adds 2.00 during peak periods. Invalid weight is rejected before either extension method runs.

Article: https://howtodoinjava.com/design-patterns/behavioral/template-method-pattern/
