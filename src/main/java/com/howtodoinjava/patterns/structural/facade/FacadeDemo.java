package com.howtodoinjava.patterns.structural.facade;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Objects;

interface ReportDataSource {
    List<String> loadRows();
}

final class ReportFormatter {
    String format(String title, List<String> rows) {
        return title + "\n" + String.join("\n", rows);
    }
}

final class ReportWriter {
    void write(String content, Path destination) throws IOException {
        Files.writeString(destination, content);
    }
}

final class ReportGeneratorFacade {
    private final ReportDataSource dataSource;
    private final ReportFormatter formatter = new ReportFormatter();
    private final ReportWriter writer = new ReportWriter();

    ReportGeneratorFacade(ReportDataSource dataSource) {
        this.dataSource = Objects.requireNonNull(dataSource);
    }

    void generate(String title, Path destination) throws IOException {
        Objects.requireNonNull(title);
        Objects.requireNonNull(destination);
        List<String> rows = dataSource.loadRows();
        String content = formatter.format(title, rows);
        writer.write(content, destination);
    }
}

public class FacadeDemo {
    public static void main(String[] args) throws IOException {
        ReportDataSource source = () -> List.of("Orders 12", "Refunds 2");
        ReportGeneratorFacade reports = new ReportGeneratorFacade(source);
        Path destination = Files.createTempFile("weekly-report-", ".txt");

        try {
            reports.generate("Weekly report", destination);
            System.out.println(Files.readString(destination));
        } finally {
            Files.deleteIfExists(destination);
        }

        Path directory = Files.createTempDirectory("report-dir-");
        try {
            try {
                reports.generate("Weekly report", directory);
            } catch (IOException e) {
                System.out.println("Report write failed: " + e.getClass().getSimpleName());
            }
        } finally {
            Files.deleteIfExists(directory);
        }
    }
}
