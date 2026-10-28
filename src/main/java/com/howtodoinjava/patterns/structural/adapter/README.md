# Adapter pattern example

Source code for the article https://howtodoinjava.com/design-patterns/structural/adapter-design-pattern/

Run from the repository root:

```bash
javac -d out src/main/java/com/howtodoinjava/patterns/structural/adapter/AdapterDemo.java
java -cp out com.howtodoinjava.patterns.structural.adapter.AdapterDemo
```

The legacy thermometer returns Fahrenheit; -999.0 indicates a failed reading. The adapter converts valid values to Celsius and rejects the failure value.
