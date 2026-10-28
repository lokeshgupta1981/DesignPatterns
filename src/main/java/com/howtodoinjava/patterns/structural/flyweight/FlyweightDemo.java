package com.howtodoinjava.patterns.structural.flyweight;

import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

enum BrushSize {
    THIN, MEDIUM, THICK
}

record Pen(BrushSize size) {
    Pen {
        Objects.requireNonNull(size);
    }

    void draw(String color, String content) {
        System.out.println(size + " " + color + " " + content);
    }
}

final class PenFactory {
    private final ConcurrentMap<BrushSize, Pen> pens = new ConcurrentHashMap<>();

    Pen get(BrushSize size) {
        Objects.requireNonNull(size);
        return pens.computeIfAbsent(size, Pen::new);
    }
}

public final class FlyweightDemo {
    public static void main(String[] args) {
        PenFactory factory = new PenFactory();
        Pen first = factory.get(BrushSize.THIN);
        Pen second = factory.get(BrushSize.THIN);
        Pen thick = factory.get(BrushSize.THICK);

        first.draw("BLUE", "Hello");
        second.draw("RED", "World");

        System.out.println("Same size reuses a pen: " + (first == second));
        System.out.println("Different size reuses a pen: " + (first == thick));

        Pen otherFactoryPen = new PenFactory().get(BrushSize.THIN);
        System.out.println("Separate factories share a pen: " + (first == otherFactoryPen));
    }
}
