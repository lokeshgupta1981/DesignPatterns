package com.howtodoinjava.patterns.behavioral.visitor;

import java.util.Objects;

public record TextBlock(String text) implements DocumentBlock {
    public TextBlock {
        Objects.requireNonNull(text, "text is required");
    }

    @Override
    public void accept(DocumentVisitor visitor) {
        visitor.visit(this);
    }
}
