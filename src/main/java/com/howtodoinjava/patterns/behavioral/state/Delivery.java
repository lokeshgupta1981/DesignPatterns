package com.howtodoinjava.patterns.behavioral.state;

import java.util.Objects;

/** A delivery whose next action depends on its current stage. */
public final class Delivery {
    private PackageState state = new Packed();

    public void advance() {
        state.advance(this);
    }

    void changeState(PackageState next) {
        state = Objects.requireNonNull(next);
    }

    public String status() {
        return state.name();
    }
}
