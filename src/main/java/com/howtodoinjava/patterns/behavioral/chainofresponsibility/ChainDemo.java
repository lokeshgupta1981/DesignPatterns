package com.howtodoinjava.patterns.behavioral.chainofresponsibility;

import java.util.Objects;

public class ChainDemo {
    public static void main(String[] args) {
        SupportHandler manager = new SupportHandler("Manager", 3, null);
        SupportHandler supervisor = new SupportHandler("Supervisor", 2, manager);
        SupportHandler frontDesk = new SupportHandler("Front desk", 1, supervisor);

        System.out.println(frontDesk.handle(1));
        System.out.println(frontDesk.handle(3));
        System.out.println(frontDesk.handle(4));
    }
}

final class SupportHandler {
    private final String name;
    private final int maximumLevel;
    private final SupportHandler next;

    SupportHandler(String name, int maximumLevel, SupportHandler next) {
        this.name = Objects.requireNonNull(name);
        if (maximumLevel < 1) {
            throw new IllegalArgumentException("Maximum level must be positive");
        }
        this.maximumLevel = maximumLevel;
        this.next = next;
    }

    String handle(int requestLevel) {
        if (requestLevel < 1) {
            throw new IllegalArgumentException("Request level must be positive");
        }
        if (requestLevel <= maximumLevel) {
            return name + " handled level " + requestLevel;
        }
        if (next != null) {
            return next.handle(requestLevel);
        }
        return "No handler for level " + requestLevel;
    }
}
