package ru.airux.operationgenerator.projectdirectory;

import java.util.List;

class Chain implements ProjectDirectoryProvider {
    private final List<ProjectDirectoryProvider> providers;

    public Chain(List<ProjectDirectoryProvider> providers) {
        this.providers = providers;
    }

    @Override
    public String provide() {
        for (ProjectDirectoryProvider provider : providers) {
            String directory = provider.provide();
            if (null != directory) {
                return directory;
            }
        }

        throw new RuntimeException("Cannot provide project directory");
    }
}
