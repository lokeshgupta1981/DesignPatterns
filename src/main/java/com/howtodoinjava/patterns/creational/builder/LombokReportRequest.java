package com.howtodoinjava.patterns.creational.builder;

import java.time.LocalDate;
import java.util.Objects;
import lombok.Builder;
import lombok.Getter;
import com.howtodoinjava.patterns.creational.builder.ReportRequest.Format;

@Getter
public final class LombokReportRequest {
    private final LocalDate startDate;
    private final LocalDate endDate;
    private final Format format;
    private final String region;
    private final boolean includeDetails;

    @Builder
    private LombokReportRequest(LocalDate startDate, LocalDate endDate,
            Format format, String region, boolean includeDetails) {
        this.startDate = Objects.requireNonNull(startDate, "start date");
        this.endDate = Objects.requireNonNull(endDate, "end date");
        if (endDate.isBefore(startDate)) {
            throw new IllegalArgumentException("End date precedes start date");
        }
        if (region != null && region.isBlank()) {
            throw new IllegalArgumentException("Region cannot be blank");
        }
        this.format = format == null ? Format.CSV : format;
        this.region = region == null ? "ALL" : region;
        this.includeDetails = includeDetails;
    }

    @Override
    public String toString() {
        return startDate + " to " + endDate + " format=" + format
                + " region=" + region + " details=" + includeDetails;
    }
}
