package ru.airux.operationgenerator.writer;

import java.io.FileOutputStream;
import java.io.IOException;

public class BaseCharWriter implements CharWriter {
    private final FileOutputStream fileOutputStream;

    public BaseCharWriter(FileOutputStream fileOutputStream) {
        this.fileOutputStream = fileOutputStream;
    }

    @Override
    public void write(int c) {
        try {
            fileOutputStream.write(c);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}
