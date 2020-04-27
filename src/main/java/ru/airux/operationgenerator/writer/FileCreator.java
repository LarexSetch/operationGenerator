package ru.airux.operationgenerator.writer;

import ru.airux.operationgenerator.ElementType;
import ru.airux.operationgenerator.Operation;

import java.io.File;

public interface FileCreator {
    File create(Operation operation, ElementType elementType);
}
