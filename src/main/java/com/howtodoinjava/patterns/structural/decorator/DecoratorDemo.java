package com.howtodoinjava.patterns.structural.decorator;

import java.util.Locale;
import java.util.Objects;

interface Report {
    String text();
}

final class SupportReport implements Report {
    @Override
    public String text() {
        return "2 open support tickets";
    }
}

abstract class ReportDecorator implements Report {
    protected final Report wrapped;

    ReportDecorator(Report wrapped) {
        this.wrapped = Objects.requireNonNull(wrapped, "wrapped");
    }

    @Override
    public String text() {
        return wrapped.text();
    }
}

final class HeadingReport extends ReportDecorator {
    HeadingReport(Report wrapped) {
        super(wrapped);
    }

    @Override
    public String text() {
        return "Support summary\n" + super.text();
    }
}

final class FooterReport extends ReportDecorator {
    FooterReport(Report wrapped) {
        super(wrapped);
    }

    @Override
    public String text() {
        return super.text() + "\nEnd of report";
    }
}

final class UppercaseReport extends ReportDecorator {
    UppercaseReport(Report wrapped) {
        super(wrapped);
    }

    @Override
    public String text() {
        return super.text().toUpperCase(Locale.ROOT);
    }
}

public class DecoratorDemo {
    public static void main(String[] args) {
        Report original = new SupportReport();
        Report decorated = new FooterReport(new HeadingReport(original));

        System.out.println("Original: " + original.text());
        System.out.println("Decorated:\n" + decorated.text());
        System.out.println("Uppercase outside:\n"
                + new UppercaseReport(new HeadingReport(original)).text());
        System.out.println("Heading outside:\n"
                + new HeadingReport(new UppercaseReport(original)).text());
    }
}
