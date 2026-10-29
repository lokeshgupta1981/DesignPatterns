package com.howtodoinjava.patterns.behavioral.visitor;

import java.util.List;

public class VisitorDemo {
    public static void main(String[] args) {
        List<DocumentBlock> document = List.of(
                new TextBlock("Hello"),
                new ImageBlock("Team photo"),
                new TextBlock("Java"));
        TextExportVisitor export = new TextExportVisitor();
        StatisticsVisitor statistics = new StatisticsVisitor();
        for (DocumentBlock block : document) {
            block.accept(export);
            block.accept(statistics);
        }
        System.out.print(export.result());
        System.out.println("Text units: " + statistics.textUnits());
        System.out.println("Images: " + statistics.images());
        document.get(0).accept(statistics);
        System.out.println("After visiting Hello again: " + statistics.textUnits());
        StatisticsVisitor empty = new StatisticsVisitor();
        System.out.println("Empty document: " + empty.textUnits() + ", " + empty.images());
    }
}
