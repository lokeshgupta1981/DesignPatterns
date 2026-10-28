Source code for the article https://howtodoinjava.com/design-patterns/behavioral/strategy-design-pattern/

# Strategy discount example

Run these commands from the repository root. The example has no external dependencies.

```shell
javac -d target/strategy-demo -sourcepath src/main/java src/main/java/com/howtodoinjava/patterns/behavioral/strategy/StrategyDemo.java
java -cp target/strategy-demo com.howtodoinjava.patterns.behavioral.strategy.StrategyDemo
```

Expected output

```text
Regular customer = 10000
Member = 9000
Member with 99 cents = 90
```

All amounts are whole cents. The member policy truncates fractional discount cents.
The context rejects negative subtotals and discounts outside the subtotal range.
