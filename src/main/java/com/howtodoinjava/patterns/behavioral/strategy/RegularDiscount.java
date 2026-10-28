package com.howtodoinjava.patterns.behavioral.strategy;

public final class RegularDiscount implements DiscountPolicy {
    @Override
    public long discountCents(long subtotalCents) {
        return 0;
    }
}
