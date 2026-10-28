package com.howtodoinjava.patterns.behavioral.state;

/** Behavior available at one stage of a delivery. */
interface PackageState {
    void advance(Delivery delivery);
    String name();
}
