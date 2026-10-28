package com.howtodoinjava.patterns.behavioral.observer;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

record Message(String text) {
    Message {
        Objects.requireNonNull(text, "text");
    }
}

@FunctionalInterface
interface MessageListener {
    void update(Message message);
}

final class MessagePublisher {
    private final Set<MessageListener> listeners = new LinkedHashSet<>();

    void subscribe(MessageListener listener) {
        listeners.add(Objects.requireNonNull(listener, "listener"));
    }

    void unsubscribe(MessageListener listener) {
        listeners.remove(listener);
    }

    void publish(Message message) {
        Objects.requireNonNull(message, "message");
        for (MessageListener listener : List.copyOf(listeners)) {
            listener.update(message);
        }
    }
}

final class OneTimeListener implements MessageListener {
    private final MessagePublisher publisher;
    private final String name;

    OneTimeListener(MessagePublisher publisher, String name) {
        this.publisher = Objects.requireNonNull(publisher, "publisher");
        this.name = Objects.requireNonNull(name, "name");
    }

    @Override
    public void update(Message message) {
        System.out.println(name + " received: " + message.text());
        publisher.unsubscribe(this);
    }
}

public class ObserverDemo {
    public static void main(String[] args) {
        MessagePublisher publisher = new MessagePublisher();
        MessageListener alex = new OneTimeListener(publisher, "Alex");
        MessageListener brian = message ->
                System.out.println("Brian received: " + message.text());

        publisher.subscribe(alex);
        publisher.subscribe(brian);
        publisher.publish(new Message("First message"));
        publisher.publish(new Message("Second message"));
    }
}
