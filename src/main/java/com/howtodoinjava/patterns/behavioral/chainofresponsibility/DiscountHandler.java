package com.howtodoinjava.patterns.behavioral.chainofresponsibility;

import java.util.Objects;
import java.util.Optional;

public abstract class DiscountHandler {
    private final DiscountHandler next;

    protected DiscountHandler(DiscountHandler next) {
        this.next = next;
    }

    public final Optional<Discount> handle(DiscountRequest request) {
        Objects.requireNonNull(request, "request is required");
        Optional<Discount> result = tryHandle(request);
        if (result.isPresent()) {
            return result;
        }
        return next == null ? Optional.empty() : next.handle(request);
    }

    protected abstract Optional<Discount> tryHandle(DiscountRequest request);
}
