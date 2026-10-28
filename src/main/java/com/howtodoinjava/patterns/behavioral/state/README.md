# State pattern delivery example

`Delivery` delegates `advance()` to its current `PackageState`. The allowed transitions are `Packed -> Shipped -> Delivered`. A further call in `Delivered` throws `IllegalStateException`.

From the repository root:

```shell
javac -d target/state-demo -sourcepath src/main/java src/main/java/com/howtodoinjava/patterns/behavioral/state/StateDemo.java
java -cp target/state-demo com.howtodoinjava.patterns.behavioral.state.StateDemo
```

Expected output:

```text
Packed
Shipped
Delivered
The package is already delivered
Status after rejected advance = Delivered
```

This example changes only in-memory objects. It does not persist a delivery or call a shipping service.
