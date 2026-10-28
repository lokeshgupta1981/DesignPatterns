package com.howtodoinjava.patterns.behavioral.chainofresponsibility;

import java.util.Optional;

public final class CouponHandler extends DiscountHandler {
    public CouponHandler(DiscountHandler next) {
        super(next);
    }

    @Override
    protected Optional<Discount> tryHandle(DiscountRequest request) {
        if ("SAVE10".equals(request.couponCode())) {
            return Optional.of(Discount.percentage("Coupon", request.subtotal(), "0.10"));
        }
        return Optional.empty();
    }
}
