package com.howtodoinjava.patterns.behavioral.chainofresponsibility;

import java.math.BigDecimal;
import java.util.Optional;

public class ChainDemo {
    public static void main(String[] args) {
        DiscountHandler chain = new CouponHandler(new LoyaltyHandler(null));
        DiscountRequest both = new DiscountRequest(new BigDecimal("100.00"), "SAVE10", true);
        show("Coupon and member", chain.handle(both));
        show("Member only", chain.handle(new DiscountRequest(new BigDecimal("100.00"), "", true)));
        show("No eligible rule", chain.handle(new DiscountRequest(new BigDecimal("100.00"), "", false)));
        DiscountHandler reversed = new LoyaltyHandler(new CouponHandler(null));
        show("Reversed order", reversed.handle(both));
        try {
            new DiscountRequest(BigDecimal.ZERO, "", false);
        } catch (IllegalArgumentException exception) {
            System.out.println("Invalid request: " + exception.getMessage());
        }
    }

    private static void show(String label, Optional<Discount> result) {
        String description = result
                .map(discount -> discount.rule() + " discount " + discount.amount())
                .orElse("No discount");
        System.out.println(label + ": " + description);
    }
}
