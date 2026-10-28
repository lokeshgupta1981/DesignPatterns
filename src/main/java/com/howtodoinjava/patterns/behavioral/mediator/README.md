# Mediator demo

`MediatorDemo` is a small in-process chat feature. Each `ChatUser` sends through `ChatMediator`; `ChatRoom` registers users and routes by recipient ID. The demo prints two deliveries and one unknown-recipient rejection.

From the repository root:

```bash
javac -d target/mediator-demo src/main/java/com/howtodoinjava/patterns/behavioral/mediator/MediatorDemo.java
java -cp target/mediator-demo com.howtodoinjava.patterns.behavioral.mediator.MediatorDemo
```

Expected output:

```text
Brian received: Alex says: Hello
Alex received: Brian says: Hi Alex
Unknown recipient: 9
```

This example is synchronous and single-threaded. It has no network or persistent message storage.
