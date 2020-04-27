package ru.airux.operationgenerator;

import java.util.List;

public interface OperationsFactory {
    List<Operation> create(String[] consoleArgument);
}
