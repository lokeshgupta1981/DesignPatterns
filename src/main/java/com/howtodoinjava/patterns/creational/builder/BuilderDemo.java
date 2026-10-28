package com.howtodoinjava.patterns.creational.builder;

import java.time.LocalDate;

public class BuilderDemo {
    public static void main(String[] args) {
        ReportRequest detailed = new ReportRequest.Builder(
                LocalDate.of(2026, 10, 1), LocalDate.of(2026, 10, 31))
                .format(ReportRequest.Format.PDF)
                .region("EU")
                .includeDetails(true)
                .build();
        ReportRequest basic = new ReportRequest.Builder(
                LocalDate.of(2026, 9, 1), LocalDate.of(2026, 9, 30))
                .build();

        System.out.println(detailed);
        System.out.println(basic);

        try {
            new ReportRequest.Builder(
                    LocalDate.of(2026, 10, 31), LocalDate.of(2026, 10, 1)).build();
        } catch (IllegalArgumentException exception) {
            System.out.println("Invalid dates: " + exception.getMessage());
        }
        try {
            new ReportRequest.Builder(
                    LocalDate.of(2026, 10, 1), LocalDate.of(2026, 10, 31))
                    .region(" ");
        } catch (IllegalArgumentException exception) {
            System.out.println("Invalid region: " + exception.getMessage());
        }
    }
}
