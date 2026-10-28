package com.howtodoinjava.patterns.behavioral.strategy;

import java.util.Objects;

public final class Checkout {
    private final DiscountPolicy policy;

    public Checkout(DiscountPolicy policy) {
        this.policy = Objects.requireNonNull(policy);
    }

    public long totalCents(long subtotalCents) {
        if (subtotalCents < 0) {
            throw new IllegalArgumentException("Subtotal cannot be negative");
        }
        long discount = policy.discountCents(subtotalCents);
        if (discount < 0 || discount > subtotalCents) {
            throw new IllegalArgumentException("Invalid discount");
        }
        return subtotalCents - discount;
    }
}
