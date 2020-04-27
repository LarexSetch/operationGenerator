package ru.airux.operationgenerator.projectdirectory;

public interface ProjectDirectoryProviderFactory {
    ProjectDirectoryProvider create(String[] consoleArguments);

    static ProjectDirectoryProviderFactory getInstance() {
        return new Factory();
    }
}
