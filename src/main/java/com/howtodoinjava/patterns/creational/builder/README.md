# Builder pattern example

Source code for the article https://howtodoinjava.com/design-patterns/creational/builder-pattern-in-java/

Requires JDK 17 or later and Maven. From this directory, compile all three implementations and run their comparison:

```bash
mvn -q clean compile
java -cp target/classes com.howtodoinjava.patterns.creational.builder.BuilderVariantsDemo
```

The local pom.xml configures Lombok 1.18.42 as a provided dependency and annotation processor. This project is built independently of the repository's root pom.xml.

The program compares a classic nested builder, a generic builder and a Lombok builder using the same sales-report settings. It demonstrates defaults, rejected date ranges, validation timing and mutation after construction. It constructs request data; it does not generate a report file.

ReportRequest and its nested Builder are immutable product/mutable builder counterparts. GenericBuilder records setter operations for MutableReportRequest. LombokReportRequest uses a constructor annotation to generate its builder while retaining validation and defaults in the constructor. Its null format and region mean defaults; the other two implementations reject explicit null options.

For the original classic-only scenarios, run BuilderDemo after compilation.
