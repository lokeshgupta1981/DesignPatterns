package com.howtodoinjava.patterns.creational.abstractfactory;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.zip.GZIPInputStream;

public final class GzipBackupReader implements BackupReader {
    @Override
    public String read(byte[] data) throws IOException {
        try (GZIPInputStream gzip = new GZIPInputStream(
                new ByteArrayInputStream(data))) {
            return new String(gzip.readAllBytes(), StandardCharsets.UTF_8);
        }
    }
}
