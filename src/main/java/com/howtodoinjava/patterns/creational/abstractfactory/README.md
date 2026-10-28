# Abstract Factory: notes backup and restore

JDK 17 or later. From the repository root:

```shell
javac -encoding UTF-8 -d out src/main/java/com/howtodoinjava/patterns/creational/abstractfactory/*.java
java -cp out com.howtodoinjava.patterns.creational.abstractfactory.AbstractFactoryDemo
```

TextBackupFactory creates a UTF-8 writer/reader pair. GzipBackupFactory creates a GZIP writer/reader pair. BackupService receives one factory and uses both products. The demo checks Unicode round trips, an empty note, and a text backup passed to the GZIP reader.

This is an in-memory example for small trusted notes. It does not implement persistent storage, automatic format detection, encryption, or bounded streaming. Select the matching format when restoring saved data. The common interfaces do not enforce family membership at compile time.
