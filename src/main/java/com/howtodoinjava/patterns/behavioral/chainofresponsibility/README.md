# Chain of Responsibility: checkout discounts

JDK 17 or later. From the repository root:

```shell
javac -d out src/main/java/com/howtodoinjava/patterns/behavioral/chainofresponsibility/*.java
java -cp out com.howtodoinjava.patterns.behavioral.chainofresponsibility.ChainDemo
```

The policy chooses the first eligible discount: SAVE10 gives 10 percent; membership gives 5 percent. Rates are illustrative. Discounts do not stack. Reversing the order changes the result for a member with the coupon. Optional.empty means no eligible discount; invalid subtotals fail before processing.

Successor links are private final fields, established in constructors. No coupon database, redemption state or payment processing is implemented. BigDecimal computes a two-decimal discount using HALF_UP rounding; production rounding and eligibility must follow the application's actual policy.
