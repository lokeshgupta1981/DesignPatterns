package com.howtodoinjava.patterns.behavioral.state;

/** The package is on its way to the customer. */
final class Shipped implements PackageState {
    @Override
    public void advance(Delivery delivery) {
        delivery.changeState(new Delivered());
    }

    @Override
    public String name() {
        return "Shipped";
    }
}
