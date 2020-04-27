package ru.airux.operationgenerator.projectdirectory;

import java.util.Arrays;

class Factory implements ProjectDirectoryProviderFactory {
    @Override
    public ProjectDirectoryProvider create(String[] consoleArguments) {
        return new Chain(
                Arrays.asList(
                        new ConsoleProjectDirectoryProvider(consoleArguments, new DefaultProjectDirectoryProvider()),
                        new DefaultProjectDirectoryProvider()
                )
        );
    }
}
