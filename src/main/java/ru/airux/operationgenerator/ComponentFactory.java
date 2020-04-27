package ru.airux.operationgenerator;

public interface ComponentFactory {
    Component create(String[] consoleArguments);
}
