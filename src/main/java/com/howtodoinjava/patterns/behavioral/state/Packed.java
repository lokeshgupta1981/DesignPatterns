package com.howtodoinjava.patterns.behavioral.state;

/** The package is ready to leave the warehouse. */
final class Packed implements PackageState {
    @Override
    public void advance(Delivery delivery) {
        delivery.changeState(new Shipped());
    }

    @Override
    public String name() {
        return "Packed";
    }
}
