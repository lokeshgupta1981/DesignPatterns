package com.howtodoinjava.patterns.behavioral.visitor;

public interface DocumentBlock {
    void accept(DocumentVisitor visitor);
}
