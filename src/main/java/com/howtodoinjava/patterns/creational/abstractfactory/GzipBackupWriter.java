package com.howtodoinjava.patterns.creational.abstractfactory;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.zip.GZIPOutputStream;

public final class GzipBackupWriter implements BackupWriter {
    @Override
    public byte[] write(String text) throws IOException {
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        try (GZIPOutputStream gzip = new GZIPOutputStream(buffer)) {
            gzip.write(text.getBytes(StandardCharsets.UTF_8));
        }
        return buffer.toByteArray();
    }
}
