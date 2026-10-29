package com.howtodoinjava.patterns.creational.builder;

import java.time.LocalDate;
import java.util.Objects;
import com.howtodoinjava.patterns.creational.builder.ReportRequest.Format;

public final class MutableReportRequest {
    private final LocalDate startDate;
    private final LocalDate endDate;
    private Format format = Format.CSV;
    private String region = "ALL";
    private boolean includeDetails;

    public MutableReportRequest(LocalDate startDate, LocalDate endDate) {
        this.startDate = Objects.requireNonNull(startDate, "start date");
        this.endDate = Objects.requireNonNull(endDate, "end date");
        if (endDate.isBefore(startDate)) {
            throw new IllegalArgumentException("End date precedes start date");
        }
    }

    public void setFormat(Format format) {
        this.format = Objects.requireNonNull(format, "format");
    }

    public void setRegion(String region) {
        Objects.requireNonNull(region, "region");
        if (region.isBlank()) {
            throw new IllegalArgumentException("Region cannot be blank");
        }
        this.region = region;
    }

    public void setIncludeDetails(boolean includeDetails) {
        this.includeDetails = includeDetails;
    }

    public LocalDate getStartDate() { return startDate; }
    public LocalDate getEndDate() { return endDate; }
    public Format getFormat() { return format; }
    public String getRegion() { return region; }
    public boolean isIncludeDetails() { return includeDetails; }

    @Override
    public String toString() {
        return startDate + " to " + endDate + " format=" + format
                + " region=" + region + " details=" + includeDetails;
    }
}
