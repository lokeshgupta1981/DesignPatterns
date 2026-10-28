# Command pattern playlist example

Source code for the article https://howtodoinjava.com/design-patterns/behavioral/command-pattern/

From the repository root, compile and run the in-memory playlist example:

```shell
javac -d target/command-demo -sourcepath src/main/java src/main/java/com/howtodoinjava/patterns/behavioral/command/CommandDemo.java
java -cp target/command-demo com.howtodoinjava.patterns.behavioral.command.CommandDemo
```

The example uses one history for all playlist edits. Create a fresh command object for each new user action. It does not persist commands or reverse external effects.
