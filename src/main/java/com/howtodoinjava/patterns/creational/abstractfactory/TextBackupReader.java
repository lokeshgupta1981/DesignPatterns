package com.howtodoinjava.patterns.creational.abstractfactory;

import java.nio.charset.StandardCharsets;

public final class TextBackupReader implements BackupReader {
    @Override
    public String read(byte[] data) {
        return new String(data, StandardCharsets.UTF_8);
    }
}
