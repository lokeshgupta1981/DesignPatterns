package com.howtodoinjava.patterns.creational.builder;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;

public final class GenericBuilder<T> {
    private final Supplier<T> factory;
    private final List<Consumer<T>> steps = new ArrayList<>();

    private GenericBuilder(Supplier<T> factory) {
        this.factory = factory;
    }

    public static <T> GenericBuilder<T> of(Supplier<T> factory) {
        return new GenericBuilder<>(factory);
    }

    public <V> GenericBuilder<T> with(BiConsumer<T, V> setter, V value) {
        steps.add(target -> setter.accept(target, value));
        return this;
    }

    public T build() {
        T target = factory.get();
        for (Consumer<T> step : steps) {
            step.accept(target);
        }
        return target;
    }
}
