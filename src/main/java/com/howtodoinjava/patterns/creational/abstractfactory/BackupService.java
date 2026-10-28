package com.howtodoinjava.patterns.creational.abstractfactory;

import java.io.IOException;
import java.util.Objects;

public final class BackupService {
    private final BackupWriter writer;
    private final BackupReader reader;

    public BackupService(BackupFactory factory) {
        Objects.requireNonNull(factory, "factory is required");
        writer = factory.createWriter();
        reader = factory.createReader();
    }

    public byte[] backup(String text) throws IOException {
        return writer.write(Objects.requireNonNull(text, "text is required"));
    }

    public String restore(byte[] data) throws IOException {
        return reader.read(Objects.requireNonNull(data, "data is required"));
    }
}
