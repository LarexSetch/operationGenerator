package ru.airux.operationgenerator.projectdirectory;

class ConsoleProjectDirectoryProvider implements ProjectDirectoryProvider {
    private final String[] consoleArguments;
    private final ProjectDirectoryProvider projectDirectoryProvider;

    public ConsoleProjectDirectoryProvider(String[] consoleArguments, ProjectDirectoryProvider projectDirectoryProvider) {
        this.consoleArguments = consoleArguments;
        this.projectDirectoryProvider = projectDirectoryProvider;
    }

    @Override
    public String provide() {
        for (int i = 0; i < consoleArguments.length; i++) {
            if ("--project-dir".equals(consoleArguments[i]) && i + 1 < consoleArguments.length) {
                return resolveDirectory(consoleArguments[i + 1]);
            }
        }

        return null;
    }

    private String resolveDirectory(String directory) {
        if ('/' == directory.charAt(0)) {
            return directory;
        } else {
            return projectDirectoryProvider.provide() + System.getProperty("file.separator") + directory;
        }
    }
}
