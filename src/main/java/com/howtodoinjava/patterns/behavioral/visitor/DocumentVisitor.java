package com.howtodoinjava.patterns.behavioral.visitor;

public interface DocumentVisitor {
    void visit(TextBlock block);
    void visit(ImageBlock block);
}
