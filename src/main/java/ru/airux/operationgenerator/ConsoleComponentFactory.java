package ru.airux.operationgenerator;

import javax.annotation.Nonnull;

public class ConsoleComponentFactory implements ComponentFactory {
    @Nonnull
    @Override
    public Component create(String[] consoleArguments) {
        String componentDirectory = null;
        String componentPackage = null;
        for (int i = 0; i < consoleArguments.length; i++) {
            if ("--component-dir".equals(consoleArguments[i]) && i + 1 < consoleArguments.length) {
                componentDirectory = consoleArguments[i + 1];
            }
            if ("--namespace".equals(consoleArguments[i]) && i + 1 < consoleArguments.length) {
                componentPackage = consoleArguments[i + 1];
            }
        }

        if (null == componentDirectory || null == componentPackage) {
            System.out.println("You must define arguments --component-dir and --namespace");
            throw new RuntimeException("Cannot create component");
        }

        return new Component(componentPackage, componentDirectory);
    }
}
