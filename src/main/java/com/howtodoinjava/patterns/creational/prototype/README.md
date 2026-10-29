# Prototype: duplicate a newsletter campaign

Use JDK 17 or later. From the repository root:

```shell
javac -d out src/main/java/com/howtodoinjava/patterns/creational/prototype/*.java
java -cp out com.howtodoinjava.patterns.creational.prototype.PrototypeDemo
java -cp out com.howtodoinjava.patterns.creational.prototype.RegistryDemo
```

`Campaign.copy()` copies the campaign, list and mutable sections. Immutable string values can be shared. Editing the October copy leaves the original template unchanged.

The last part of `PrototypeDemo` intentionally copies only a list. Its output shows two different lists containing the same mutable section, so changing that section through one list is visible through the other.

`RegistryDemo` selects a stored campaign and copies it before changing its subject. It prints `Template: Monthly update` and `Draft: November update`. The registry is an optional way to select a prototype, not a requirement of the pattern.
