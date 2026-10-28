package com.howtodoinjava.patterns.behavioral.mediator;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

interface ChatMediator {
    void register(ChatUser user);
    void send(String recipientId, String message);
}

final class ChatRoom implements ChatMediator {
    private final Map<String, ChatUser> users = new HashMap<>();

    @Override
    public void register(ChatUser user) {
        Objects.requireNonNull(user, "user");
        if (users.putIfAbsent(user.id(), user) != null) {
            throw new IllegalArgumentException("User is already registered: " + user.id());
        }
    }

    @Override
    public void send(String recipientId, String message) {
        Objects.requireNonNull(recipientId, "recipientId");
        Objects.requireNonNull(message, "message");
        ChatUser recipient = users.get(recipientId);
        if (recipient == null) {
            throw new IllegalArgumentException("Unknown recipient: " + recipientId);
        }
        recipient.receive(message);
    }
}

final class ChatUser {
    private final String id;
    private final String name;
    private final ChatMediator room;

    ChatUser(String id, String name, ChatMediator room) {
        this.id = Objects.requireNonNull(id, "id");
        this.name = Objects.requireNonNull(name, "name");
        this.room = Objects.requireNonNull(room, "room");
    }

    String id() { return id; }

    void send(String recipientId, String message) {
        room.send(recipientId, name + " says: " + Objects.requireNonNull(message, "message"));
    }

    void receive(String message) {
        System.out.println(name + " received: " + message);
    }
}

public class MediatorDemo {
    public static void main(String[] args) {
        ChatMediator room = new ChatRoom();
        ChatUser alex = new ChatUser("1", "Alex", room);
        ChatUser brian = new ChatUser("2", "Brian", room);
        room.register(alex);
        room.register(brian);

        alex.send("2", "Hello");
        brian.send("1", "Hi Alex");
        try {
            alex.send("9", "Are you there?");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
