package com.howtodoinjava.patterns.creational.abstractfactory;

public final class TextBackupFactory implements BackupFactory {
    @Override
    public BackupWriter createWriter() {
        return new TextBackupWriter();
    }

    @Override
    public BackupReader createReader() {
        return new TextBackupReader();
    }
}
