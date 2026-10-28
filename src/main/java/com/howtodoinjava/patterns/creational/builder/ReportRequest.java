package com.howtodoinjava.patterns.creational.builder;

import java.time.LocalDate;
import java.util.Objects;

public final class ReportRequest {
    public enum Format { CSV, PDF }

    private final LocalDate startDate;
    private final LocalDate endDate;
    private final Format format;
    private final String region;
    private final boolean includeDetails;

    private ReportRequest(Builder builder) {
        startDate = builder.startDate;
        endDate = builder.endDate;
        format = builder.format;
        region = builder.region;
        includeDetails = builder.includeDetails;
    }

    @Override
    public String toString() {
        return startDate + " to " + endDate + " format=" + format
                + " region=" + region + " details=" + includeDetails;
    }

    public static final class Builder {
        private final LocalDate startDate;
        private final LocalDate endDate;
        private Format format = Format.CSV;
        private String region = "ALL";
        private boolean includeDetails;

        public Builder(LocalDate startDate, LocalDate endDate) {
            this.startDate = Objects.requireNonNull(startDate, "start date");
            this.endDate = Objects.requireNonNull(endDate, "end date");
        }

        public Builder format(Format format) {
            this.format = Objects.requireNonNull(format, "format");
            return this;
        }

        public Builder region(String region) {
            Objects.requireNonNull(region, "region");
            if (region.isBlank()) {
                throw new IllegalArgumentException("Region cannot be blank");
            }
            this.region = region;
            return this;
        }

        public Builder includeDetails(boolean includeDetails) {
            this.includeDetails = includeDetails;
            return this;
        }

        public ReportRequest build() {
            if (endDate.isBefore(startDate)) {
                throw new IllegalArgumentException("End date precedes start date");
            }
            return new ReportRequest(this);
        }
    }
}
