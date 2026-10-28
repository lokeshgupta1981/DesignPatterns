package com.howtodoinjava.patterns.creational.abstractfactory;

public final class GzipBackupFactory implements BackupFactory {
    @Override
    public BackupWriter createWriter() {
        return new GzipBackupWriter();
    }

    @Override
    public BackupReader createReader() {
        return new GzipBackupReader();
    }
}
