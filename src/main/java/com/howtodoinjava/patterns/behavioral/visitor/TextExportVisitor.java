package com.howtodoinjava.patterns.behavioral.visitor;

public final class TextExportVisitor implements DocumentVisitor {
    private final StringBuilder output = new StringBuilder();

    @Override
    public void visit(TextBlock block) {
        output.append(block.text()).append('\n');
    }

    @Override
    public void visit(ImageBlock block) {
        output.append("[Image: ").append(block.description()).append("]\n");
    }

    public String result() {
        return output.toString();
    }
}
