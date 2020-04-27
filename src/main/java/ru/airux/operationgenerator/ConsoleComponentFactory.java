package ru.airux.operationgenerator;

import javax.annotation.Nonnull;

public class ConsoleComponentFactory implements ComponentFactory {
    @Nonnull
    @Override
    public Component create(String[] consoleArguments) {
        String componentName = null;
        String sourceDirectory = null;
        String packagePrefix = null;
        for (int i = 0; i < consoleArguments.length; i++) {
            if ("--component-name".equals(consoleArguments[i]) && i + 1 < consoleArguments.length) {
                componentName = consoleArguments[i + 1];
            }
            if ("--source-dir".equals(consoleArguments[i]) && i + 1 < consoleArguments.length) {
                sourceDirectory = consoleArguments[i + 1];
            }
            if ("--package-prefix".equals(consoleArguments[i]) && i + 1 < consoleArguments.length) {
                packagePrefix = consoleArguments[i + 1];
            }
        }

        if (null == componentName || null == sourceDirectory || null == packagePrefix) {
            System.out.println("You must define arguments --component-name and --source-dir and --package-prefix");
            throw new RuntimeException("Cannot create component");
        }

        return new Component(componentName, sourceDirectory, packagePrefix);
    }
}
