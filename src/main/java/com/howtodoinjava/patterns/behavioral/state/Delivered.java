package com.howtodoinjava.patterns.behavioral.state;

/** The final stage of this one-way delivery example. */
final class Delivered implements PackageState {
    @Override
    public void advance(Delivery delivery) {
        throw new IllegalStateException("The package is already delivered");
    }

    @Override
    public String name() {
        return "Delivered";
    }
}
