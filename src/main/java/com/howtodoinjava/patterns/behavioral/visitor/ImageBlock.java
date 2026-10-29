package com.howtodoinjava.patterns.behavioral.visitor;

import java.util.Objects;

public record ImageBlock(String description) implements DocumentBlock {
    public ImageBlock {
        Objects.requireNonNull(description, "description is required");
    }

    @Override
    public void accept(DocumentVisitor visitor) {
        visitor.visit(this);
    }
}
