package com.howtodoinjava.patterns.creational.builder;

import java.time.LocalDate;
import com.howtodoinjava.patterns.creational.builder.ReportRequest.Format;

public class BuilderVariantsDemo {
    public static void main(String[] args) {
        LocalDate start = LocalDate.of(2026, 10, 1);
        LocalDate end = LocalDate.of(2026, 10, 31);

        ReportRequest classic = new ReportRequest.Builder(start, end)
                .format(Format.PDF).region("EU").includeDetails(true).build();
        MutableReportRequest generic = GenericBuilder
                .of(() -> new MutableReportRequest(start, end))
                .with(MutableReportRequest::setFormat, Format.PDF)
                .with(MutableReportRequest::setRegion, "EU")
                .with(MutableReportRequest::setIncludeDetails, true)
                .build();
        LombokReportRequest lombok = LombokReportRequest.builder()
                .startDate(start).endDate(end)
                .format(Format.PDF).region("EU").includeDetails(true).build();

        System.out.println("Classic: " + classic);
        System.out.println("Generic: " + generic);
        System.out.println("Lombok: " + lombok);

        System.out.println("Classic defaults: " + new ReportRequest.Builder(start, end).build());
        System.out.println("Generic defaults: " + GenericBuilder
                .of(() -> new MutableReportRequest(start, end)).build());
        System.out.println("Lombok defaults: " + LombokReportRequest.builder()
                .startDate(start).endDate(end).build());

        reject("Classic dates", () -> new ReportRequest.Builder(end, start).build());
        reject("Generic dates", () -> GenericBuilder
                .of(() -> new MutableReportRequest(end, start)).build());
        reject("Lombok dates", () -> LombokReportRequest.builder()
                .startDate(end).endDate(start).build());

        reject("Classic region", () -> new ReportRequest.Builder(start, end).region(" "));
        GenericBuilder<MutableReportRequest> pending = GenericBuilder
                .of(() -> new MutableReportRequest(start, end))
                .with(MutableReportRequest::setRegion, " ");
        System.out.println("Generic steps recorded");
        reject("Generic region", () -> pending.build());
        reject("Lombok region", () -> LombokReportRequest.builder()
                .startDate(start).endDate(end).region(" ").build());

        generic.setRegion("APAC");
        System.out.println("Generic region after build: " + generic.getRegion());
    }

    private static void reject(String label, Runnable action) {
        try {
            action.run();
            throw new AssertionError(label + " was accepted");
        } catch (IllegalArgumentException exception) {
            System.out.println(label + ": " + exception.getMessage());
        }
    }
}
