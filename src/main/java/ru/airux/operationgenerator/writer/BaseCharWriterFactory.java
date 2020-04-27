package ru.airux.operationgenerator.writer;

import ru.airux.operationgenerator.ElementType;
import ru.airux.operationgenerator.Operation;

import java.io.FileOutputStream;
import java.io.IOException;

public class BaseCharWriterFactory implements CharWriterFactory {
    private final FileCreator fileCreator;

    public BaseCharWriterFactory(FileCreator fileCreator) {
        this.fileCreator = fileCreator;
    }

    @Override
    public CharWriter create(ElementType type, Operation operation) {
        try {
            return new BaseCharWriter(new FileOutputStream(fileCreator.create(operation, type), true));
        } catch (IOException exception) {
            exception.printStackTrace();

            return new EmptyWriter();
        }
    }
}
