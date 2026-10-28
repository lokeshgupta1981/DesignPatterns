package com.howtodoinjava.patterns.behavioral.strategy;

public final class MemberDiscount implements DiscountPolicy {
    @Override
    public long discountCents(long subtotalCents) {
        return subtotalCents / 10;
    }
}
