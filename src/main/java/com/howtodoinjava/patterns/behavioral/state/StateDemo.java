package com.howtodoinjava.patterns.behavioral.state;

/** Runs the valid and invalid transitions in the delivery example. */
public final class StateDemo {
    public static void main(String[] args) {
        Delivery delivery = new Delivery();
        System.out.println(delivery.status());
        delivery.advance();
        System.out.println(delivery.status());
        delivery.advance();
        System.out.println(delivery.status());

        try {
            delivery.advance();
        } catch (IllegalStateException exception) {
            System.out.println(exception.getMessage());
        }
        System.out.println("Status after rejected advance = " + delivery.status());
    }
}
