package ru.airux.operationgenerator.writer;

import ru.airux.operationgenerator.ElementType;
import ru.airux.operationgenerator.Operation;

public interface CharWriterFactory {
    CharWriter create(ElementType type, Operation operation);
}
