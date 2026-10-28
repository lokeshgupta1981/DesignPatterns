package com.howtodoinjava.patterns.behavioral.chainofresponsibility;

import java.util.Optional;

public final class LoyaltyHandler extends DiscountHandler {
    public LoyaltyHandler(DiscountHandler next) {
        super(next);
    }

    @Override
    protected Optional<Discount> tryHandle(DiscountRequest request) {
        if (request.member()) {
            return Optional.of(Discount.percentage("Loyalty", request.subtotal(), "0.05"));
        }
        return Optional.empty();
    }
}
