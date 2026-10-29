package com.howtodoinjava.patterns.creational.abstractfactory;

import java.nio.charset.StandardCharsets;

public final class TextBackupWriter implements BackupWriter {
    @Override
    public byte[] write(String text) {
        return text.getBytes(StandardCharsets.UTF_8);
    }
}
