package com.howtodoinjava.patterns.creational.abstractfactory;

import java.io.IOException;

public class AbstractFactoryDemo {
    public static void main(String[] args) throws IOException {
        String note = "Meeting at 10:00 - café";
        BackupService text = new BackupService(new TextBackupFactory());
        BackupService gzip = new BackupService(new GzipBackupFactory());
        System.out.println("Text restored: " + text.restore(text.backup(note)));
        System.out.println("GZIP restored: " + gzip.restore(gzip.backup(note)));
        System.out.println("Empty note restored: " + gzip.restore(gzip.backup("")).isEmpty());
        try {
            gzip.restore(text.backup(note));
        } catch (IOException exception) {
            System.out.println("Wrong reader: incompatible backup rejected");
        }
    }
}
