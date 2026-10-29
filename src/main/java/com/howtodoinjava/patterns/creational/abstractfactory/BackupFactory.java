package com.howtodoinjava.patterns.creational.abstractfactory;

public interface BackupFactory {
    BackupWriter createWriter();
    BackupReader createReader();
}
