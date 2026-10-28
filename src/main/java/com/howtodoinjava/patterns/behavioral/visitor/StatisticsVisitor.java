package com.howtodoinjava.patterns.behavioral.visitor;

public final class StatisticsVisitor implements DocumentVisitor {
    private int textUnits;
    private int images;

    @Override
    public void visit(TextBlock block) {
        textUnits += block.text().length();
    }

    @Override
    public void visit(ImageBlock block) {
        images++;
    }

    public int textUnits() {
        return textUnits;
    }

    public int images() {
        return images;
    }
}
